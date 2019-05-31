package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_school_info")
public class SchoolInfo {
    /**
     * 学校id
     */
    @Id
    private Integer school_id;

    /**
     * 校区id
     */
    @Id
    private Integer school_area_id;

    /**
     * 学校名称
     */
    private String school_name;

    /**
     * 校区名称
     */
    private String area_name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取学校id
     *
     * @return school_id - 学校id
     */
    public Integer getSchool_id() {
        return school_id;
    }

    /**
     * 设置学校id
     *
     * @param school_id 学校id
     */
    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    /**
     * 获取校区id
     *
     * @return school_area_id - 校区id
     */
    public Integer getSchool_area_id() {
        return school_area_id;
    }

    /**
     * 设置校区id
     *
     * @param school_area_id 校区id
     */
    public void setSchool_area_id(Integer school_area_id) {
        this.school_area_id = school_area_id;
    }

    /**
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchool_name() {
        return school_name;
    }

    /**
     * 设置学校名称
     *
     * @param school_name 学校名称
     */
    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    /**
     * 获取校区名称
     *
     * @return area_name - 校区名称
     */
    public String getArea_name() {
        return area_name;
    }

    /**
     * 设置校区名称
     *
     * @param area_name 校区名称
     */
    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}