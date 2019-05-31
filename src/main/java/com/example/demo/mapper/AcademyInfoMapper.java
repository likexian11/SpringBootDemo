package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.AcademyInfo;
import com.example.demo.utils.ParentMapper;

public interface AcademyInfoMapper extends ParentMapper<AcademyInfo> {
	
	public List<AcademyInfo> queryAcademyList(int school_id,int school_area_id);
}