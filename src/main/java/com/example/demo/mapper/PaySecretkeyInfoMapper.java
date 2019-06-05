package com.example.demo.mapper;

import com.example.demo.pojo.PaySecretkeyInfo;
import com.example.demo.utils.ParentMapper;

public interface PaySecretkeyInfoMapper extends ParentMapper<PaySecretkeyInfo> {
	
	public PaySecretkeyInfo getKeyInfo(String businessId);
}