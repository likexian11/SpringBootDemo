package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.UserInfo;

@Mapper
public interface UserDao {
	
    @Select("select id,username,password from userinfo where id = #{id}")
    UserInfo findById(@Param("id") int id);

    @Select("select id,username,password from userinfo")
    List<UserInfo> userList();
    
    @Insert("insert into  userinfo(username, password) values(#{username}, #{password})")
    int insert(@Param("username") String name, @Param("password") String password);

    @Update("update userinfo set password = #{password} where id = #{id}")
    int update(@Param("password") String password, @Param("id") int id) ; 
    
    @Delete("delete from userinfo where id = #{id}")
    int delete(@Param("id") int id) ; 
    
}
