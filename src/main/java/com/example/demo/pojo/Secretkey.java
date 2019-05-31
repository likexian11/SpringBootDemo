package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_secretkey")
public class Secretkey {
    /**
     * 收款商户id
     */
    @Id
    @Column(name = "business_id")
    private String businessId;

    /**
     * br接口名
     */
    private String command;

    /**
     * br接入商标识
     */
    private String app;

    /**
     * br收银员的id
     */
    @Column(name = "operator_id")
    private String operatorId;

    /**
     * 接口版本号
     */
    private String version;

    /**
     * 支付成功之后的跳转页面
     */
    @Column(name = "redirect_url")
    private String redirectUrl;

    /**
     * br校验key
     */
    private String key;

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
     * 获取br接口名
     *
     * @return command - br接口名
     */
    public String getCommand() {
        return command;
    }

    /**
     * 设置br接口名
     *
     * @param command br接口名
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * 获取br接入商标识
     *
     * @return app - br接入商标识
     */
    public String getApp() {
        return app;
    }

    /**
     * 设置br接入商标识
     *
     * @param app br接入商标识
     */
    public void setApp(String app) {
        this.app = app;
    }

    /**
     * 获取br收银员的id
     *
     * @return operator_id - br收银员的id
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置br收银员的id
     *
     * @param operatorId br收银员的id
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取接口版本号
     *
     * @return version - 接口版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置接口版本号
     *
     * @param version 接口版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取支付成功之后的跳转页面
     *
     * @return redirect_url - 支付成功之后的跳转页面
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * 设置支付成功之后的跳转页面
     *
     * @param redirectUrl 支付成功之后的跳转页面
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * 获取br校验key
     *
     * @return key - br校验key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置br校验key
     *
     * @param key br校验key
     */
    public void setKey(String key) {
        this.key = key;
    }
}