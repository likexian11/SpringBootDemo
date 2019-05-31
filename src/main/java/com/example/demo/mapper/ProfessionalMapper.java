package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.Professional;
import com.example.demo.utils.ParentMapper;

public interface ProfessionalMapper extends ParentMapper<Professional> {
	
	List<Professional> getPrfList(int school_id, int school_area_id,int academy_id);
}