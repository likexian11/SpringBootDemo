package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.PayProject;
import com.example.demo.utils.ParentMapper;

public interface PayProjectMapper extends ParentMapper<PayProject> {
	
	List<PayProject> getProListByOrgId(String orgId);
}