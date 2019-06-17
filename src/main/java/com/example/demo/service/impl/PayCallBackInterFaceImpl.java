package com.example.demo.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.n3r.idworker.Sid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.PayInfoDetailMapper;
import com.example.demo.mapper.PayInfoMapper;
import com.example.demo.pojo.PayInfo;
import com.example.demo.pojo.PayInfoDetail;
import com.example.demo.service.PayCallBackInterFace;
import com.example.demo.utils.DateUtil;

import ch.qos.logback.classic.Logger;

@Service
public class PayCallBackInterFaceImpl implements PayCallBackInterFace {

	@Autowired  PayInfoMapper payInfoMapper;
	@Autowired  PayInfoDetailMapper payInfoDetailMapper;
	
	@Autowired private Sid sid;
	
	private final Logger log = (Logger) LoggerFactory.getLogger(PayCallBackInterFaceImpl.class);
	
	@Override
	@Transactional
	public void updatePayInfo(Map<String, String> map) {
		
		log.info("支付完成，支付信息更改....");
//		String payDetailId = map.get("appOrderNo").split("_")[0];
//		String payInfoId = map.get("appOrderNo").split("_")[1];
		String payDetailId = sid.nextShort();
		String payInfoId = map.get("appOrderNo");
		Date payDate =  DateUtil.scsToData(map.get("payTime"));
		PayInfo payInfo = new PayInfo();
		PayInfoDetail payInfoDetail = new PayInfoDetail();
		//
		payInfo = payInfoMapper.selectByPrimaryKey(payInfoId);
		//总共需缴金额
		double tkPayMoney = payInfo.getPay_money();
		//已缴金额
		double rdPayMoney = payInfo.getAlready_pay();
		//本次缴费金额
		double thisPayMoney = Double.valueOf(map.get("receiveAmount"))/100;
		//若 总共需缴金额 = 已缴金额 + 次缴费金额，则缴费完成
		payInfo.setAlready_pay(rdPayMoney + thisPayMoney);
		if(rdPayMoney + thisPayMoney == tkPayMoney) {
			payInfo.setIs_pay_over("1");
			payInfo.setPay_over_time(payDate);
		}
		
		
		if( map.get("appOrderNo").split("_").length >= 2) {
			payInfo.setId(payInfoId);
			payInfoMapper.updateByPrimaryKeySelective(payInfo);
		}else {
			map.put("appOrderNo", map.get("appOrderNo")+UUID.randomUUID());
			payInfo.setId(payInfoId);
			//TODO  自助招生信息录入
			//payInfo.set
		}
		
		log.info("新增流水信息....");
		payInfoDetail.setApp_order_no(payDetailId);
		payInfoDetail.setCb_order_no(map.get("cbOrderNo"));
		payInfoDetail.setDiscount_amount(Double.valueOf(map.get("discountAmount")));
		payInfoDetail.setOrder_status(map.get("orderStatus"));
		payInfoDetail.setOut_order_no(map.get("outOrderNo"));
		payInfoDetail.setPay_info_id(payInfoId);
		payInfoDetail.setPay_time(payDate);
		payInfoDetail.setPayment_channel("WECHAT".equals(map.get("paymentChannel"))?"微信支付":"支付宝支付");
		payInfoDetail.setPayment_way( "QRCODE".equals(map.get("paymentWay"))?"二维码":"其它");
		payInfoDetail.setReceive_amount(Double.valueOf(map.get("receiveAmount"))/100);
		payInfoDetail.setRemark("");
		payInfoDetail.setSubject(map.get("subject"));
		payInfoDetail.setTotal_amount(Double.valueOf(map.get("totalAmount"))/100);
		payInfoDetailMapper.insertSelective(payInfoDetail);
		log.info("新增流水信息完成 ,流水订单号为: "+payInfoDetail.getApp_order_no());
		
		log.info("支付信息和流水修改完成！");
		
	}

}
