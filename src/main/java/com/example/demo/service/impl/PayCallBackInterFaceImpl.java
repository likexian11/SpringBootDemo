package com.example.demo.service.impl;

import java.util.Map;
import java.util.UUID;

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
	
	private final Logger log = (Logger) LoggerFactory.getLogger(PayCallBackInterFaceImpl.class);
	
	@Override
	@Transactional
	public void updatePayInfo(Map<String, String> map) {
		
		log.info("支付完成，支付信息更改....");
		PayInfo payInfo = new PayInfo();
		PayInfoDetail payInfoDetail = new PayInfoDetail();
		payInfo.setAlready_pay(Double.valueOf(map.get("receiveAmount"))/100 );
		payInfo.setIs_pay_over("1");
		if( map.get("appOrderNo").split("_").length >= 2) {
			payInfo.setId( (map.get("appOrderNo")).split("_")[1] );
			payInfoMapper.updateByPrimaryKeySelective(payInfo);
		}else {
			map.put("appOrderNo", map.get("appOrderNo")+UUID.randomUUID());
			payInfo.setId((map.get("appOrderNo")).split("_")[1]);
			//payInfo.set
		}
		
		log.info("新增流水信息....");
		payInfoDetail.setApp_order_no(map.get("appOrderNo").split("_")[0]);
		payInfoDetail.setCb_order_no(map.get("cbOrderNo"));
		payInfoDetail.setDiscount_amount(Double.valueOf(map.get("discountAmount")));
		payInfoDetail.setOrder_status(map.get("orderStatus"));
		payInfoDetail.setOut_order_no(map.get("outOrderNo"));
		payInfoDetail.setPay_info_id(map.get("appOrderNo").split("_")[1]);
		payInfoDetail.setPay_time(DateUtil.scsToData(map.get("payTime")));
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
