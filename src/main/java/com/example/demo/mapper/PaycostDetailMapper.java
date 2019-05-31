package com.example.demo.mapper;

import com.example.demo.pojo.PaycostDetail;
import com.example.demo.utils.ParentMapper;

public interface PaycostDetailMapper extends ParentMapper<PaycostDetail> {

	PaycostDetail queryDetail(String paycost_num);
	
}

