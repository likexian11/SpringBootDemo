package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "fkr_secretkey")
public class Secretkey {
    /**
     * 收款商户id
     */
    @Id
    private String business_id;

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
    private String operator_id;

    /**
     * 接口版本号
     */
    private String version;

    /**
     * 支付成功之后的跳转页面
     */
    private String redirect_url;

    /**
     * br校验key
     */
    private String key;

    /**
     * 获取收款商户id
     *
     * @return business_id - 收款商户id
     */
    public String getBusiness_id() {
        return business_id;
    }

    /**
     * 设置收款商户id
     *
     * @param business_id 收款商户id
     */
    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
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
    public String getOperator_id() {
        return operator_id;
    }

    /**
     * 设置br收银员的id
     *
     * @param operator_id br收银员的id
     */
    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
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
    public String getRedirect_url() {
        return redirect_url;
    }

    /**
     * 设置支付成功之后的跳转页面
     *
     * @param redirect_url 支付成功之后的跳转页面
     */
    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
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