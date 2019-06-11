package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PayPageMapper;
import com.example.demo.pojo.PayPage;
import com.example.demo.service.PageJumpInterFace;

@Service
public class PageJumpInterFaceImpl implements PageJumpInterFace {

	@Autowired PayPageMapper payPageMapper;
	
	@Override
	public List<PayPage> queryPageUrl(String bid) {
		return payPageMapper.getPageUrlByBId(bid);
	}


}
