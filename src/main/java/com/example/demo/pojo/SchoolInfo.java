package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_school_info")
public class SchoolInfo {
    /**
     * 学校id
     */
    @Id
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 校区id
     */
    @Id
    @Column(name = "school_area_id")
    private Integer schoolAreaId;

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 校区名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取学校id
     *
     * @return school_id - 学校id
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校id
     *
     * @param schoolId 学校id
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取校区id
     *
     * @return school_area_id - 校区id
     */
    public Integer getSchoolAreaId() {
        return schoolAreaId;
    }

    /**
     * 设置校区id
     *
     * @param schoolAreaId 校区id
     */
    public void setSchoolAreaId(Integer schoolAreaId) {
        this.schoolAreaId = schoolAreaId;
    }

    /**
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称
     *
     * @param schoolName 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * 获取校区名称
     *
     * @return area_name - 校区名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置校区名称
     *
     * @param areaName 校区名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
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