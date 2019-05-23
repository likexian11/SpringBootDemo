package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserInfo;

@Service
public class TestInterFaceImpl implements TestInterFace {

	//引入dao层借口
	@Autowired UserDao userDao;
	
	@Override
	public int testInterFace() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserInfo> findUserList() {
		// TODO Auto-generated method stub
		return (List<UserInfo>) userDao.userList();
	}
	
	@Override
	public UserInfo findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}
	
    @Override 
    public int insertUser(String username,String password) {
    	return userDao.insert(username,password);
    }

	@Override
	public int updateUserPwd(int id, String password) {
		// TODO Auto-generated method stub
		return userDao.update(password,id);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

}
