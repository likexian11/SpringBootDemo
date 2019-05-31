package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_cost_list")
public class CostList {
    /**
     * 缴费id
     */
    @Id
    private Integer cost_id;

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
     * 专业id
     */
    private Integer professional_id;

    /**
     * 缴费类型
     */
    private String cost_name;

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
    public Integer getCost_id() {
        return cost_id;
    }

    /**
     * 设置缴费id
     *
     * @param cost_id 缴费id
     */
    public void setCost_id(Integer cost_id) {
        this.cost_id = cost_id;
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
     * 获取缴费类型
     *
     * @return cost_name - 缴费类型
     */
    public String getCost_name() {
        return cost_name;
    }

    /**
     * 设置缴费类型
     *
     * @param cost_name 缴费类型
     */
    public void setCost_name(String cost_name) {
        this.cost_name = cost_name;
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