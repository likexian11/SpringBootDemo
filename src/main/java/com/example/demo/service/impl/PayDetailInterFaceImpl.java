package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DeptMapper;
import com.example.demo.pojo.Dept;
import com.example.demo.service.PayDetailInterFace;

@Service
public class PayDetailInterFaceImpl implements PayDetailInterFace {

	@Autowired DeptMapper deptMapper;
	
	@Override
	public List<Dept> queryOrgList(String pid) {
		return deptMapper.getOrgListByPId(pid);
	}


}
