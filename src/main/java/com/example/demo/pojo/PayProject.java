package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_project")
public class PayProject {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 归属缴费机构
     */
    private String organ_id;

    /**
     * 缴费名称
     */
    private String name;

    /**
     * 缴费单价金额
     */
    private Double pay_single_money;

    /**
     * 缴费数量（默认1）
     */
    private Integer amount;

    /**
     * 缴费总额
     */
    private Double pay_total_money;

    /**
     * 缴费状态（1正常/2结束）
     */
    private String pay_statues;

    /**
     * 是否临时缴费项目（1是/0否）
     */
    private String is_temporary_pro;

    /**
     * 缴费开始时间
     */
    private Date start_time;

    /**
     * 缴费结束时间
     */
    private Date end_time;

    /**
     * 缴费年度
     */
    private String pay_years;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取归属缴费机构
     *
     * @return organ_id - 归属缴费机构
     */
    public String getOrgan_id() {
        return organ_id;
    }

    /**
     * 设置归属缴费机构
     *
     * @param organ_id 归属缴费机构
     */
    public void setOrgan_id(String organ_id) {
        this.organ_id = organ_id;
    }

    /**
     * 获取缴费名称
     *
     * @return name - 缴费名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置缴费名称
     *
     * @param name 缴费名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取缴费单价金额
     *
     * @return pay_single_money - 缴费单价金额
     */
    public Double getPay_single_money() {
        return pay_single_money;
    }

    /**
     * 设置缴费单价金额
     *
     * @param pay_single_money 缴费单价金额
     */
    public void setPay_single_money(Double pay_single_money) {
        this.pay_single_money = pay_single_money;
    }

    /**
     * 获取缴费数量（默认1）
     *
     * @return amount - 缴费数量（默认1）
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置缴费数量（默认1）
     *
     * @param amount 缴费数量（默认1）
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取缴费总额
     *
     * @return pay_total_money - 缴费总额
     */
    public Double getPay_total_money() {
        return pay_total_money;
    }

    /**
     * 设置缴费总额
     *
     * @param pay_total_money 缴费总额
     */
    public void setPay_total_money(Double pay_total_money) {
        this.pay_total_money = pay_total_money;
    }

    /**
     * 获取缴费状态（1正常/2结束）
     *
     * @return pay_statues - 缴费状态（1正常/2结束）
     */
    public String getPay_statues() {
        return pay_statues;
    }

    /**
     * 设置缴费状态（1正常/2结束）
     *
     * @param pay_statues 缴费状态（1正常/2结束）
     */
    public void setPay_statues(String pay_statues) {
        this.pay_statues = pay_statues;
    }

    /**
     * 获取是否临时缴费项目（1是/0否）
     *
     * @return is_temporary_pro - 是否临时缴费项目（1是/0否）
     */
    public String getIs_temporary_pro() {
        return is_temporary_pro;
    }

    /**
     * 设置是否临时缴费项目（1是/0否）
     *
     * @param is_temporary_pro 是否临时缴费项目（1是/0否）
     */
    public void setIs_temporary_pro(String is_temporary_pro) {
        this.is_temporary_pro = is_temporary_pro;
    }

    /**
     * 获取缴费开始时间
     *
     * @return start_time - 缴费开始时间
     */
    public Date getStart_time() {
        return start_time;
    }

    /**
     * 设置缴费开始时间
     *
     * @param start_time 缴费开始时间
     */
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    /**
     * 获取缴费结束时间
     *
     * @return end_time - 缴费结束时间
     */
    public Date getEnd_time() {
        return end_time;
    }

    /**
     * 设置缴费结束时间
     *
     * @param end_time 缴费结束时间
     */
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    /**
     * 获取缴费年度
     *
     * @return pay_years - 缴费年度
     */
    public String getPay_years() {
        return pay_years;
    }

    /**
     * 设置缴费年度
     *
     * @param pay_years 缴费年度
     */
    public void setPay_years(String pay_years) {
        this.pay_years = pay_years;
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