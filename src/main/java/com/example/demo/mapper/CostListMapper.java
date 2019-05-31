package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.CostList;
import com.example.demo.utils.ParentMapper;

public interface CostListMapper extends ParentMapper<CostList> {
	
	//获取缴费类型
		public List<CostList> queryCostList(int professional_id);
}