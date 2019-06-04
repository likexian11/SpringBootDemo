package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "pay_secretkey_info")
public class PaySecretkeyInfo {
    @Id
    private String id;

    /**
     * 归属机构
     */
    private String business_id;

    private String command;

    /**
     * 接入商标识
     */
    private String app;

    /**
     * 收银员的id，用于标识收款账户
     */
    private String operator_id;

    /**
     * 调用的接口版本，固定为：2.0
     */
    private String version;

    /**
     * 支付成功之后的跳转页面
     */
    private String redirect_url;

    /**
     * 商户对应的key
     */
    private String app_key;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取归属机构
     *
     * @return business_id - 归属机构
     */
    public String getBusiness_id() {
        return business_id;
    }

    /**
     * 设置归属机构
     *
     * @param business_id 归属机构
     */
    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    /**
     * @return command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * 获取接入商标识
     *
     * @return app - 接入商标识
     */
    public String getApp() {
        return app;
    }

    /**
     * 设置接入商标识
     *
     * @param app 接入商标识
     */
    public void setApp(String app) {
        this.app = app;
    }

    /**
     * 获取收银员的id，用于标识收款账户
     *
     * @return operator_id - 收银员的id，用于标识收款账户
     */
    public String getOperator_id() {
        return operator_id;
    }

    /**
     * 设置收银员的id，用于标识收款账户
     *
     * @param operator_id 收银员的id，用于标识收款账户
     */
    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    /**
     * 获取调用的接口版本，固定为：2.0
     *
     * @return version - 调用的接口版本，固定为：2.0
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置调用的接口版本，固定为：2.0
     *
     * @param version 调用的接口版本，固定为：2.0
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
     * 获取商户对应的key
     *
     * @return app_key - 商户对应的key
     */
    public String getApp_key() {
        return app_key;
    }

    /**
     * 设置商户对应的key
     *
     * @param app_key 商户对应的key
     */
    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }
}