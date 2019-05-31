package com.example.demo.mapper;

import com.example.demo.pojo.Secretkey;
import com.example.demo.utils.ParentMapper;

public interface SecretkeyMapper extends ParentMapper<Secretkey> {
	
	Secretkey queryKeyInfo(String businessId);
	
}