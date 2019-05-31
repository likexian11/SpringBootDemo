package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.SchoolInfo;
import com.example.demo.utils.ParentMapper;

public interface SchoolInfoMapper extends ParentMapper<SchoolInfo> {
	
	List<SchoolInfo> getSchoolList();
}