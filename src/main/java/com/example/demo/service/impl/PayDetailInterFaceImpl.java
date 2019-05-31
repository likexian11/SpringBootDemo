package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AcademyInfoMapper;
import com.example.demo.mapper.CostListMapper;
import com.example.demo.mapper.PaycostDetailMapper;
import com.example.demo.mapper.ProfessionalMapper;
import com.example.demo.mapper.SchoolInfoMapper;
import com.example.demo.mapper.SecretkeyMapper;
import com.example.demo.pojo.AcademyInfo;
import com.example.demo.pojo.CostList;
import com.example.demo.pojo.PaycostDetail;
import com.example.demo.pojo.Professional;
import com.example.demo.pojo.SchoolInfo;
import com.example.demo.service.PayDetailInterFace;

@Service
public class PayDetailInterFaceImpl implements PayDetailInterFace {

	//引入dao层借口
	@Autowired PaycostDetailMapper PaycostDetailMapper;
	@Autowired SchoolInfoMapper schoolInfoMapper;
	@Autowired AcademyInfoMapper academyInfoMapper;
	@Autowired ProfessionalMapper professionalMapper;
	@Autowired CostListMapper costListMapper;
	@Autowired SecretkeyMapper SecretkeyMapper;
	
	@Override
	public PaycostDetail queryDetail(String paycost_num){
		// TODO Auto-generated method stub
		return PaycostDetailMapper.queryDetail(paycost_num);
	}
	
	@Override
	public List<SchoolInfo> querySchoolList() {
		// TODO Auto-generated method stub
		return schoolInfoMapper.selectAll();
	}

	@Override
	public List<AcademyInfo> queryAcademyList(int school_id,int school_area_id) {
		// TODO Auto-generated method stub
		return academyInfoMapper.queryAcademyList(school_id,school_area_id);
	}

	@Override
	public List<Professional> queryPrfList(int school_id, int school_area_id, int academy_id) {
		// TODO Auto-generated method stub
		return professionalMapper.queryPrfList(school_id, school_area_id, academy_id);
	}

	@Override
	public List<CostList> queryCostList(int professional_id) {
		// TODO Auto-generated method stub
		return costListMapper.queryCostList(professional_id);
	}

}
