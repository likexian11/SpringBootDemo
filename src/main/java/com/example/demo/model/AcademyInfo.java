package com.example.demo.model;

public class AcademyInfo {

	public int academy_id;
	public int school_id;
	public String school_area_id;
	public String academy_name;
	public String remark;
	
	public int getAcademy_id() {
		return academy_id;
	}
	public void setAcademy_id(int academy_id) {
		this.academy_id = academy_id;
	}
	public int getSchool_id() {
		return school_id;
	}
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	public String getSchool_area_id() {
		return school_area_id;
	}
	public void setSchool_area_id(String school_area_id) {
		this.school_area_id = school_area_id;
	}
	public String getAcademy_name() {
		return academy_name;
	}
	public void setAcademy_name(String academy_name) {
		this.academy_name = academy_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
