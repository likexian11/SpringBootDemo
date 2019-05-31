package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_academy_info")
public class AcademyInfo {
    /**
     * 学院id
     */
    private Integer academy_id;

    /**
     * 学校id
     */
    private Integer school_id;

    /**
     * 校区id
     */
    private Integer school_area_id;

    /**
     * 学院名称
     */
    private String academy_name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取学院id
     *
     * @return academy_id - 学院id
     */
    public Integer getAcademy_id() {
        return academy_id;
    }

    /**
     * 设置学院id
     *
     * @param academy_id 学院id
     */
    public void setAcademy_id(Integer academy_id) {
        this.academy_id = academy_id;
    }

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
     * 获取学院名称
     *
     * @return academy_name - 学院名称
     */
    public String getAcademy_name() {
        return academy_name;
    }

    /**
     * 设置学院名称
     *
     * @param academy_name 学院名称
     */
    public void setAcademy_name(String academy_name) {
        this.academy_name = academy_name;
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