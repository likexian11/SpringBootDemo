package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.AcademyInfo;
import com.example.demo.pojo.CostList;
import com.example.demo.pojo.PaycostDetail;
import com.example.demo.pojo.Professional;
import com.example.demo.pojo.SchoolInfo;

public interface PayDetailInterFace {
	
	//
	public PaycostDetail queryDetail(String paycost_num);
	
	//获取学校
	public List<SchoolInfo> querySchoolList();
	
	//获取学院
	public List<AcademyInfo> queryAcademyList(int school_id,int school_area_id);
	
	//获取专业
	public List<Professional> queryPrfList(int school_id,int school_area_id,int academy_id);
	
	//获取缴费类型
	public List<CostList> queryCostList(int professional_id);

}
