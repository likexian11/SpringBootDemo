package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "pay_page")
public class PayPage {
    @Id
    private Integer id;

    /**
     * 商户id
     */
    private String bid;

    /**
     * 链接名称
     */
    private String url_name;

    /**
     * 链接
     */
    private String url;

    /**
     * 1:图片  2:显示列表
     */
    private Integer type;

    /**
     * 1:显示 0：隐藏
     */
    private Integer is_show;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商户id
     *
     * @return bid - 商户id
     */
    public String getBid() {
        return bid;
    }

    /**
     * 设置商户id
     *
     * @param bid 商户id
     */
    public void setBid(String bid) {
        this.bid = bid;
    }

    /**
     * 获取链接名称
     *
     * @return url_name - 链接名称
     */
    public String getUrl_name() {
        return url_name;
    }

    /**
     * 设置链接名称
     *
     * @param url_name 链接名称
     */
    public void setUrl_name(String url_name) {
        this.url_name = url_name;
    }

    /**
     * 获取链接
     *
     * @return url - 链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接
     *
     * @param url 链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取1:图片  2:显示列表
     *
     * @return type - 1:图片  2:显示列表
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1:图片  2:显示列表
     *
     * @param type 1:图片  2:显示列表
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取1:显示 0：隐藏
     *
     * @return is_show - 1:显示 0：隐藏
     */
    public Integer getIs_show() {
        return is_show;
    }

    /**
     * 设置1:显示 0：隐藏
     *
     * @param is_show 1:显示 0：隐藏
     */
    public void setIs_show(Integer is_show) {
        this.is_show = is_show;
    }
}