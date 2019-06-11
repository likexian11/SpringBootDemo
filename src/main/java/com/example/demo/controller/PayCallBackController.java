package com.example.demo.controller;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.PayCallBackInterFace;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value ="/pay")
public class PayCallBackController {
	
	Logger log = (Logger) LoggerFactory.getLogger(PayCallBackController.class);
	
	@Autowired
	private PayCallBackInterFace payCallBackInterFace;
	
	//支付回调
	@RequestMapping(value ="/callback")
	public String callBack(@RequestParam Map<String,String> map) throws ParseException, UnknownHostException {
		String paramsJson = JSON.toJSONString(map);
		log.info("json: "+ paramsJson);
		payCallBackInterFace.updatePayInfo(map);
		return "success";
	}
	
}
