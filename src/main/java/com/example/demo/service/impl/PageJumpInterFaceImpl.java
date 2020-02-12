package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.mapper.CityMapper;
import com.example.demo.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.PageJumpInterFace;

@Service
public class PageJumpInterFaceImpl implements PageJumpInterFace {


    @Autowired
    CityMapper cityMapper;

    @Override
    public List<City> queryCityList() {
        List<City> cityList = cityMapper.getCityList();
        return cityList;
    }

//	@Autowired PayPageMapper payPageMapper;
//
//	@Override
//	public List<PayPage> queryPageUrl(String bid) {
//
//		List<PayPage> pageInfoList = payPageMapper.getPageUrlByBId(bid);
//		//拼接显示图片地址
//		for(PayPage page : pageInfoList) {
//			if(1 == page.getType()) {
//				page.setUrl(BasicConfig.IMG_HOST + page.getUrl());
//			}
//		}
//		return pageInfoList;
//	}


}
