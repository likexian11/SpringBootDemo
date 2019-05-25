package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PayDetailDao;
import com.example.demo.model.AcademyInfo;
import com.example.demo.model.PayDetail;
import com.example.demo.model.Professional;
import com.example.demo.model.SchoolInfo;

@Service
public class PayDetailInterFaceImpl implements PayDetailInterFace {

	//引入dao层借口
	@Autowired PayDetailDao payDetailDao;
	
	@Override
	public PayDetail queryDetail(){
		// TODO Auto-generated method stub
		return payDetailDao.getDetail();
	}

	@Override
	public List<SchoolInfo> querySchoolList() {
		// TODO Auto-generated method stub
		return payDetailDao.getSchoolList();
	}

	@Override
	public List<AcademyInfo> queryAcademyList(int school_id,int school_area_id) {
		// TODO Auto-generated method stub
		return payDetailDao.getAcademyList(school_id,school_area_id);
	}

	@Override
	public List<Professional> queryPrfList(int school_id, int school_area_id, int academy_id) {
		// TODO Auto-generated method stub
		return payDetailDao.getPrfList(school_id, school_area_id, academy_id);
	}

}
