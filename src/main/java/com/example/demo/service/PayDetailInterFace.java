package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AcademyInfo;
import com.example.demo.model.PayDetail;
import com.example.demo.model.Professional;
import com.example.demo.model.SchoolInfo;

public interface PayDetailInterFace {
	
	//
	public PayDetail queryDetail();
	
	//获取学校
	public List<SchoolInfo> querySchoolList();
	
	//获取学院
	public List<AcademyInfo> queryAcademyList(int school_id,int school_area_id);
	
	//获取专业
	public List<Professional> queryPrfList(int school_id,int school_area_id,int academy_id);

}
