package com.example.demo.mapper;

import com.example.demo.pojo.PayInfo;
import com.example.demo.utils.ParentMapper;

public interface PayInfoMapper extends ParentMapper<PayInfo> {
	//查询某条支付信息并加锁
	PayInfo getPayInfoByIdLock(String id);
	
}