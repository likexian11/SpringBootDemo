package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.AcademyInfo;
import com.example.demo.pojo.Professional;
import com.example.demo.utils.ParentMapper;

public interface ProfessionalMapper extends ParentMapper<Professional> {
	
	public List<Professional> queryPrfList(int school_id, int school_area_id, int academy_id);
}