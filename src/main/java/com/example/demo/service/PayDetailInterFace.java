package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Custom;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.PayProject;

public interface PayDetailInterFace {
	
	//
	public List<Custom> queryDetail(String payNo);
	
	//获取父机构信息
	public List<Dept> queryOrgInfo(Integer id);
	
	//获取机构列表
	public List<Dept> queryOrgList(String pid);
	
	//获取机构信息
	public Dept queryOrg(Integer id);
	
	//获取缴费类型
	public List<PayProject> queryCostList(String orgId);
	
}
