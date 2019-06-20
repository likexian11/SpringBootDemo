package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.config.BasicConfig;
import com.example.demo.mapper.PayInfoDetailMapper;
import com.example.demo.mapper.PayInfoMapper;
import com.example.demo.mapper.PaySecretkeyInfoMapper;
import com.example.demo.pojo.PayInfo;
import com.example.demo.pojo.PayInfoDetail;
import com.example.demo.service.PayCallBackInterFace;
import com.example.demo.utils.DateUtil;
import com.example.demo.utils.Rsa256Sign;
import com.example.demo.utils.VerifySign;

import ch.qos.logback.classic.Logger;

@Service
public class PayCallBackInterFaceImpl implements PayCallBackInterFace {
	
	@Autowired  PayInfoMapper payInfoMapper;
	@Autowired  PayInfoDetailMapper payInfoDetailMapper;
	@Autowired  PaySecretkeyInfoMapper paySecretkeyInfoMapper;
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(PayCallBackInterFaceImpl.class);
	
	@Override
	@Transactional
	public boolean updatePayInfo(Map<String, String> map) {
		//验签
		String sign = map.get("sign");
		//去掉sign字段验签
		map.remove("sign");
		//排序
		String newStrTemp = Rsa256Sign.getSignContent(map);
		try {
			String payInfoId = map.get("appOrderNo").split("_")[0];
			if(VerifySign.rsaCheck(newStrTemp, sign, BasicConfig.PUBLIC_KEY, "UTF-8", "RSA2")) {
				
				logger.info("验签成功，支付信息更改...缴费号：."+ payInfoId);
				String payDetailId = map.get("appOrderNo").split("_")[1];
				Date payDate =  DateUtil.secToData(map.get("payTime"));
				PayInfo payInfo = new PayInfo();
				PayInfoDetail payInfoDetail = new PayInfoDetail();
				DecimalFormat df  = new DecimalFormat("0.00");
				//
				payInfo = payInfoMapper.getPayInfoByIdLock(payInfoId);
				//总共需缴金额
				BigDecimal tkPayMoney = new BigDecimal(df.format(payInfo.getPay_money())) ;
				//已缴金额
				BigDecimal rdPayMoney = new BigDecimal(df.format(payInfo.getAlready_pay()));
				//本次缴费金额
				BigDecimal thisPayMoney = new BigDecimal(df.format(Double.parseDouble( map.get("receiveAmount"))/100));
				//若 总共需缴金额 = 已缴金额 + 次缴费金额，则缴费完成
				payInfo.setAlready_pay( (thisPayMoney.add(rdPayMoney)).doubleValue());
				
				if(payInfo.getAlready_pay() >= tkPayMoney.doubleValue()) {
					payInfo.setIs_pay_over("1");
					payInfo.setPay_over_time(payDate);
					logger.info("该笔缴费已全部缴费完成.共："+payInfo.getAlready_pay());
				}
				if( map.get("appOrderNo").split("_").length >= 2) {
					payInfo.setId(payInfoId);
					//更新缴费项目金额信息
					payInfoMapper.updateByPrimaryKeySelective(payInfo);
				}else {
					//map.put("appOrderNo", map.get("appOrderNo")+UUID.randomUUID());
					//payInfo.setId(payInfoId);
					//TODO  自助招生信息录入
				}
				
				logger.info("新增流水信息....订单号："+payDetailId);
				payInfoDetail.setApp_order_no(payDetailId);
				payInfoDetail.setCb_order_no(map.get("cbOrderNo"));
				payInfoDetail.setDiscount_amount(Double.valueOf(map.get("discountAmount")));
				payInfoDetail.setOrder_status(map.get("orderStatus"));
				payInfoDetail.setOut_order_no(map.get("outOrderNo"));
				payInfoDetail.setPay_info_id(payInfoId);
				payInfoDetail.setPay_time(payDate);
				//payInfoDetail.setPayment_channel("WECHAT".equals(map.get("paymentChannel"))?"微信支付":"支付宝支付");
				//payInfoDetail.setPayment_way( "QRCODE".equals(map.get("paymentWay"))?"二维码":"其它");
				payInfoDetail.setPayment_channel(map.get("paymentChannel"));
				payInfoDetail.setPayment_way(map.get("paymentWay"));
				payInfoDetail.setReceive_amount(Double.valueOf(map.get("receiveAmount"))/100);
				payInfoDetail.setRemark("");
				payInfoDetail.setSubject(map.get("subject"));
				payInfoDetail.setTotal_amount(Double.valueOf(map.get("totalAmount"))/100);
				//新增流水信息
				payInfoDetailMapper.insertSelective(payInfoDetail);
				logger.info("新增流水信息完成 ,流水订单号为: " + payDetailId);
				logger.info("支付信息和流水修改完成！");
				return true;
			}else{
				logger.error("验签失败...订单号："+payInfoId);
				return false;
			}
		} catch (Exception e) {
			//数据回滚
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("支付成功回调错误，数据回滚",e);
			return false;
		}
	}

}
