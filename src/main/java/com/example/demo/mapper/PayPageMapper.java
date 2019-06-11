package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.PayPage;
import com.example.demo.utils.ParentMapper;

public interface PayPageMapper extends ParentMapper<PayPage> {
	
	List<PayPage> getPageUrlByBId(String bid);
}