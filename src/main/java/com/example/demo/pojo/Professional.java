package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_professional")
public class Professional {
    /**
     * 专业id
     */
    private Integer professional_id;

    /**
     * 专业名称
     */
    private String prf_name;

    /**
     * 学校id
     */
    private Integer school_id;

    /**
     * 校区id
     */
    private Integer school_area_id;

    /**
     * 学院id
     */
    private Integer academy_id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取专业id
     *
     * @return professional_id - 专业id
     */
    public Integer getProfessional_id() {
        return professional_id;
    }

    /**
     * 设置专业id
     *
     * @param professional_id 专业id
     */
    public void setProfessional_id(Integer professional_id) {
        this.professional_id = professional_id;
    }

    /**
     * 获取专业名称
     *
     * @return prf_name - 专业名称
     */
    public String getPrf_name() {
        return prf_name;
    }

    /**
     * 设置专业名称
     *
     * @param prf_name 专业名称
     */
    public void setPrf_name(String prf_name) {
        this.prf_name = prf_name;
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