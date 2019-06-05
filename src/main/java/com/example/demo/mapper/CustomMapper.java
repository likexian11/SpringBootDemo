package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.Custom;
import com.example.demo.utils.ParentMapper;

public interface CustomMapper extends ParentMapper<Custom> {

	List<Custom> getPayInfoByNo(String payNo);
}