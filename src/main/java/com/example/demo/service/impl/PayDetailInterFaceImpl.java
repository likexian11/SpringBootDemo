package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.BasicConfig;
import com.example.demo.mapper.CustomMapper;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.PayProjectMapper;
import com.example.demo.pojo.Custom;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.PayProject;
import com.example.demo.service.PayDetailInterFace;

@Service
public class PayDetailInterFaceImpl implements PayDetailInterFace {

	@Autowired DeptMapper deptMapper;
	@Autowired PayProjectMapper payProjectMapper;
	@Autowired CustomMapper customMapper;
	
	@Override
	public List<Dept> queryOrgList(String pid) {
		return deptMapper.getOrgListByPId(pid);
	}

	@Override
	public List<PayProject> queryCostList(String orgId) {
		return payProjectMapper.getProListByOrgId(orgId);
	}

	@Override
	public List<Custom> queryDetail(String payNo) {
		return customMapper.getPayInfoByNo(payNo);
	}

	@Override
	public List<Dept> queryOrgInfo(Integer id) {
		Dept dept = new Dept();
		List<Dept> deptList =  new ArrayList<Dept>();
		while( id != BasicConfig.FKR_ORGAN_ID) {
			dept = deptMapper.getOrgInfoById(id);
			deptList.add(dept);
			id = dept.getParent_id();
		}
		return deptList;
	}

}
