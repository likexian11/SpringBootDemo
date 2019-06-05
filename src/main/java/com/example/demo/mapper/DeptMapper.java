package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.Dept;
import com.example.demo.utils.ParentMapper;

public interface DeptMapper extends ParentMapper<Dept> {

	List<Dept> getOrgListByPId(String pid);
	
	Dept getOrgInfoById(Integer id);
}