package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "fkr_pay")
public class Pay {
    /**
     * 交易流水号
     */
    private String sid;

    /**
     * 收款商户id
     */
    @Column(name = "business_id")
    private String businessId;

    /**
     * 缴费金额
     */
    private Double money;

    /**
     * 交易完成时间
     */
    private Date time;

    /**
     * 1:收款 2:退款
     */
    private Integer status;

    /**
     * 获取交易流水号
     *
     * @return sid - 交易流水号
     */
    public String getSid() {
        return sid;
    }

    /**
     * 设置交易流水号
     *
     * @param sid 交易流水号
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * 获取收款商户id
     *
     * @return business_id - 收款商户id
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * 设置收款商户id
     *
     * @param businessId 收款商户id
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取缴费金额
     *
     * @return money - 缴费金额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置缴费金额
     *
     * @param money 缴费金额
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取交易完成时间
     *
     * @return time - 交易完成时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置交易完成时间
     *
     * @param time 交易完成时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取1:收款 2:退款
     *
     * @return status - 1:收款 2:退款
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1:收款 2:退款
     *
     * @param status 1:收款 2:退款
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}