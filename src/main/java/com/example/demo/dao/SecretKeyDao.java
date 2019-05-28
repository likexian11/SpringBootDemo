package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.FKRSecretKey;

@Mapper
public interface SecretKeyDao {
	
	//获取商户对应key信息
	@Select("select k.command,k.app,k.operator_id,k.version,k.redirect_url,k.key from fkr_secretkey_tb k where k.business_id=#{businessId}")
	FKRSecretKey queryKeyInfo(@Param("businessId") String businessId);

}
