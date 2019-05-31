package com.example.demo.mapper;

import com.example.demo.pojo.PaycostDetail;
import com.example.demo.utils.ParentMapper;

public interface PaycostDetailMapper extends ParentMapper<PaycostDetail> {
	
	PaycostDetail getDetailList(String paycost_num);

}