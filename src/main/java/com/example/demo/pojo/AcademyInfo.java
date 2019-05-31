package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_academy_info")
public class AcademyInfo {
    /**
     * 学院id
     */
    @Column(name = "academy_id")
    private Integer academyId;

    /**
     * 学校id
     */
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 校区id
     */
    @Column(name = "school_area_id")
    private Integer schoolAreaId;

    /**
     * 学院名称
     */
    @Column(name = "academy_name")
    private String academyName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取学院id
     *
     * @return academy_id - 学院id
     */
    public Integer getAcademyId() {
        return academyId;
    }

    /**
     * 设置学院id
     *
     * @param academyId 学院id
     */
    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

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
     * 获取学院名称
     *
     * @return academy_name - 学院名称
     */
    public String getAcademyName() {
        return academyName;
    }

    /**
     * 设置学院名称
     *
     * @param academyName 学院名称
     */
    public void setAcademyName(String academyName) {
        this.academyName = academyName;
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