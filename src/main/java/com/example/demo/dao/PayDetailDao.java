package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.AcademyInfo;
import com.example.demo.model.CostType;
import com.example.demo.model.PayDetail;
import com.example.demo.model.Professional;
import com.example.demo.model.SchoolInfo;

@Mapper
public interface PayDetailDao {
	
	@Select("select d.paycost_num,d.school_id,d.school_area_id,d.school_name,d.academy_id,d.academy_name,d.professional_id,d.prf_name,d.student_name"
			+ ",d.class_num,d.cost_id,d.cost_name,d.money from fkr_paycost_detail_tb d where status=1 and paycost_num=#{paycost_num};")
	PayDetail getDetail(@Param("paycost_num") String paycost_num);
	
	@Select("select school_id,school_area_id,school_name,area_name from fkr_school_info_tb;")
	List<SchoolInfo> getSchoolList();
	
	@Select("select a.academy_id,a.academy_name from fkr_academy_info_tb a "
			+ "where a.school_id=#{school_id} and a.school_area_id=#{school_area_id};")
	List<AcademyInfo> getAcademyList(@Param("school_id") int school_id,@Param("school_area_id") int school_area_id);
	
	@Select("select p.professional_id,prf_name from fkr_professional_tb p "
			+ "where p.school_id=#{school_id} and p.school_area_id=#{school_area_id} and academy_id=#{academy_id};")
	List<Professional> getPrfList(@Param("school_id") int school_id,@Param("school_area_id") int school_area_id,@Param("academy_id") int academy_id);
	
	@Select("select c.cost_id,c.cost_name,c.money from fkr_cost_list_tb c where c.professional_id=#{professional_id};")
	List<CostType> getCostTyteList(@Param("professional_id") int professional_id);
	
	/*
    @Select("select id,username,password from userinfo where id = #{id}")
    UserInfo findById(@Param("id") int id);

    
    @Insert("insert into  userinfo(username, password) values(#{username}, #{password})")
    int insert(@Param("username") String name, @Param("password") String password);

    @Update("update userinfo set password = #{password} where id = #{id}")
    int update(@Param("password") String password, @Param("id") int id) ; 
    
    @Delete("delete from userinfo where id = #{id}")
    int delete(@Param("id") int id) ; 
    */
    
}
