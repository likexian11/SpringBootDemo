package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserInfo;

public interface TestInterFace {
	
	public int testInterFace();
	
	//public UserInfo testUser();
	
	//会员List
	public List<UserInfo> findUserList();
	
	//根据id查找会员
	public UserInfo findUserById(int id);
	
	//增加会员
	public int insertUser(String username,String password);
	
	//修改会员密码
	public int updateUserPwd(int id,String password);
	
	//修改会员密码
	public int deleteUser(int id);

}
