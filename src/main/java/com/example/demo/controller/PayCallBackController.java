package com.example.demo.controller;

import java.net.UnknownHostException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.PayCallBackInterFace;

@RestController
@RequestMapping(value ="/pay")
public class PayCallBackController {
	
	@Autowired
	private PayCallBackInterFace payCallBackInterFace;
	
	//支付回调
	@RequestMapping(value ="/callback")
	public String callBack(@RequestParam Map<String,String> map) throws ParseException, UnknownHostException {
		String paramsJson = JSON.toJSONString(map);
		System.out.println("json: "+ paramsJson);
		payCallBackInterFace.updatePayInfo(map);
		return "success";
	}
	
}
