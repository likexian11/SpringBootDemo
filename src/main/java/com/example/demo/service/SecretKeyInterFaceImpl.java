package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SecretKeyDao;
import com.example.demo.model.FKRSecretKey;
import com.example.demo.util.EmptyUtil;;

@Service
public class SecretKeyInterFaceImpl implements SecretKeyInterFace {

	@Autowired SecretKeyDao secretKeyDao;
	
	@Override
	public String getPayUrl(String businessId,Map<String, String> map){
		// TODO Auto-generated method stub
		/*
		FKRSecretKey secretKey = secretKeyDao.queryKeyInfo(businessId);
		if(EmptyUtil.isNotEmpty(secretKey)) {
			System.out.println(secretKey.getApp());
		}
		*/
		return "";
	}

}
