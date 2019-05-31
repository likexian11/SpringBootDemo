package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.CostList;
import com.example.demo.utils.ParentMapper;

public interface CostListMapper extends ParentMapper<CostList> {
	
	List<CostList> getCostTyteList(int professional_id);
}