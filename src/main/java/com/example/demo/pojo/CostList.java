package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_cost_list")
public class CostList {
    /**
     * 缴费id
     */
    @Id
    @Column(name = "cost_id")
    private Integer costId;

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
     * 学院id
     */
    @Column(name = "academy_id")
    private Integer academyId;

    /**
     * 专业id
     */
    @Column(name = "professional_id")
    private Integer professionalId;

    /**
     * 缴费类型
     */
    @Column(name = "cost_name")
    private String costName;

    /**
     * 需缴费金额
     */
    private Double money;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取缴费id
     *
     * @return cost_id - 缴费id
     */
    public Integer getCostId() {
        return costId;
    }

    /**
     * 设置缴费id
     *
     * @param costId 缴费id
     */
    public void setCostId(Integer costId) {
        this.costId = costId;
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
     * 获取专业id
     *
     * @return professional_id - 专业id
     */
    public Integer getProfessionalId() {
        return professionalId;
    }

    /**
     * 设置专业id
     *
     * @param professionalId 专业id
     */
    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * 获取缴费类型
     *
     * @return cost_name - 缴费类型
     */
    public String getCostName() {
        return costName;
    }

    /**
     * 设置缴费类型
     *
     * @param costName 缴费类型
     */
    public void setCostName(String costName) {
        this.costName = costName;
    }

    /**
     * 获取需缴费金额
     *
     * @return money - 需缴费金额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置需缴费金额
     *
     * @param money 需缴费金额
     */
    public void setMoney(Double money) {
        this.money = money;
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