package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_info")
public class PayInfo {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 缴费号
     */
    private String pay_no;

    /**
     * 缴费项目
     */
    private String pay_project_id;

    /**
     * 缴费金额
     */
    private Double pay_money;

    /**
     * 已缴费金额
     */
    private Double already_pay;

    /**
     * 是否缴费完成
     */
    private String is_pay_over;

    /**
     * 缴费完成时间
     */
    private Date pay_over_time;

    /**
     * 费用说明
     */
    private String pay_content;

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
     * 获取缴费号
     *
     * @return pay_no - 缴费号
     */
    public String getPay_no() {
        return pay_no;
    }

    /**
     * 设置缴费号
     *
     * @param pay_no 缴费号
     */
    public void setPay_no(String pay_no) {
        this.pay_no = pay_no;
    }

    /**
     * 获取缴费项目
     *
     * @return pay_project_id - 缴费项目
     */
    public String getPay_project_id() {
        return pay_project_id;
    }

    /**
     * 设置缴费项目
     *
     * @param pay_project_id 缴费项目
     */
    public void setPay_project_id(String pay_project_id) {
        this.pay_project_id = pay_project_id;
    }

    /**
     * 获取缴费金额
     *
     * @return pay_money - 缴费金额
     */
    public Double getPay_money() {
        return pay_money;
    }

    /**
     * 设置缴费金额
     *
     * @param pay_money 缴费金额
     */
    public void setPay_money(Double pay_money) {
        this.pay_money = pay_money;
    }

    /**
     * 获取已缴费金额
     *
     * @return already_pay - 已缴费金额
     */
    public Double getAlready_pay() {
        return already_pay;
    }

    /**
     * 设置已缴费金额
     *
     * @param already_pay 已缴费金额
     */
    public void setAlready_pay(Double already_pay) {
        this.already_pay = already_pay;
    }

    /**
     * 获取是否缴费完成
     *
     * @return is_pay_over - 是否缴费完成
     */
    public String getIs_pay_over() {
        return is_pay_over;
    }

    /**
     * 设置是否缴费完成
     *
     * @param is_pay_over 是否缴费完成
     */
    public void setIs_pay_over(String is_pay_over) {
        this.is_pay_over = is_pay_over;
    }

    /**
     * 获取缴费完成时间
     *
     * @return pay_over_time - 缴费完成时间
     */
    public Date getPay_over_time() {
        return pay_over_time;
    }

    /**
     * 设置缴费完成时间
     *
     * @param pay_over_time 缴费完成时间
     */
    public void setPay_over_time(Date pay_over_time) {
        this.pay_over_time = pay_over_time;
    }

    /**
     * 获取费用说明
     *
     * @return pay_content - 费用说明
     */
    public String getPay_content() {
        return pay_content;
    }

    /**
     * 设置费用说明
     *
     * @param pay_content 费用说明
     */
    public void setPay_content(String pay_content) {
        this.pay_content = pay_content;
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