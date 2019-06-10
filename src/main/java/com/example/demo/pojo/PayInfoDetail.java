package com.example.demo.pojo;

import java.util.Date;

import javax.persistence.*;

@Table(name = "pay_info_detail")
public class PayInfoDetail {
    /**
     * 订单号
     */
    @Id
    private String app_order_no;

    /**
     * 缴费信息编号（外键作用）
     */
    private String pay_info_id;

    /**
     * 慧商通的订单号
     */
    private String cb_order_no;

    /**
     * 支付宝或者微信产生的订单号
     */
    private String out_order_no;

    /**
     * 订单状态（参考慧商通接口文档）
     */
    private String order_status;

    /**
     * 订单总额
     */
    private Double total_amount;

    /**
     * 实收总额
     */
    private Double receive_amount;

    /**
     * 支付渠道, 详情参照：支付渠道详解
     */
    private String payment_channel;

    /**
     * 优惠金额
     */
    private Double discount_amount;

    /**
     * 支付方式，详情参照：支付方式详解
     */
    private String payment_way;

    /**
     * 支付时间，数字格式，值为距离1970.1.1日的毫秒数
     */
    private Date pay_time;

    /**
     * 订单简介
     */
    private String subject;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取订单号
     *
     * @return app_order_no - 订单号
     */
    public String getApp_order_no() {
        return app_order_no;
    }

    /**
     * 设置订单号
     *
     * @param app_order_no 订单号
     */
    public void setApp_order_no(String app_order_no) {
        this.app_order_no = app_order_no;
    }

    /**
     * 获取缴费信息编号（外键作用）
     *
     * @return pay_info_id - 缴费信息编号（外键作用）
     */
    public String getPay_info_id() {
        return pay_info_id;
    }

    /**
     * 设置缴费信息编号（外键作用）
     *
     * @param pay_info_id 缴费信息编号（外键作用）
     */
    public void setPay_info_id(String pay_info_id) {
        this.pay_info_id = pay_info_id;
    }

    /**
     * 获取慧商通的订单号
     *
     * @return cb_order_no - 慧商通的订单号
     */
    public String getCb_order_no() {
        return cb_order_no;
    }

    /**
     * 设置慧商通的订单号
     *
     * @param cb_order_no 慧商通的订单号
     */
    public void setCb_order_no(String cb_order_no) {
        this.cb_order_no = cb_order_no;
    }

    /**
     * 获取支付宝或者微信产生的订单号
     *
     * @return out_order_no - 支付宝或者微信产生的订单号
     */
    public String getOut_order_no() {
        return out_order_no;
    }

    /**
     * 设置支付宝或者微信产生的订单号
     *
     * @param out_order_no 支付宝或者微信产生的订单号
     */
    public void setOut_order_no(String out_order_no) {
        this.out_order_no = out_order_no;
    }

    /**
     * 获取订单状态（参考慧商通接口文档）
     *
     * @return order_status - 订单状态（参考慧商通接口文档）
     */
    public String getOrder_status() {
        return order_status;
    }

    /**
     * 设置订单状态（参考慧商通接口文档）
     *
     * @param order_status 订单状态（参考慧商通接口文档）
     */
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    /**
     * 获取订单总额
     *
     * @return total_amount - 订单总额
     */
    public Double getTotal_amount() {
        return total_amount;
    }

    /**
     * 设置订单总额
     *
     * @param total_amount 订单总额
     */
    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * 获取实收总额
     *
     * @return receive_amount - 实收总额
     */
    public Double getReceive_amount() {
        return receive_amount;
    }

    /**
     * 设置实收总额
     *
     * @param receive_amount 实收总额
     */
    public void setReceive_amount(Double receive_amount) {
        this.receive_amount = receive_amount;
    }

    /**
     * 获取支付渠道, 详情参照：支付渠道详解
     *
     * @return payment_channel - 支付渠道, 详情参照：支付渠道详解
     */
    public String getPayment_channel() {
        return payment_channel;
    }

    /**
     * 设置支付渠道, 详情参照：支付渠道详解
     *
     * @param payment_channel 支付渠道, 详情参照：支付渠道详解
     */
    public void setPayment_channel(String payment_channel) {
        this.payment_channel = payment_channel;
    }

    /**
     * 获取优惠金额
     *
     * @return discount_amount - 优惠金额
     */
    public Double getDiscount_amount() {
        return discount_amount;
    }

    /**
     * 设置优惠金额
     *
     * @param discount_amount 优惠金额
     */
    public void setDiscount_amount(Double discount_amount) {
        this.discount_amount = discount_amount;
    }

    /**
     * 获取支付方式，详情参照：支付方式详解
     *
     * @return payment_way - 支付方式，详情参照：支付方式详解
     */
    public String getPayment_way() {
        return payment_way;
    }

    /**
     * 设置支付方式，详情参照：支付方式详解
     *
     * @param payment_way 支付方式，详情参照：支付方式详解
     */
    public void setPayment_way(String payment_way) {
        this.payment_way = payment_way;
    }

    /**
     * 获取支付时间，数字格式，值为距离1970.1.1日的毫秒数
     *
     * @return pay_time - 支付时间，数字格式，值为距离1970.1.1日的毫秒数
     */
    public Date getPay_time() {
        return pay_time;
    }

    /**
     * 设置支付时间，数字格式，值为距离1970.1.1日的毫秒数
     *
     * @param pay_time 支付时间，数字格式，值为距离1970.1.1日的毫秒数
     */
    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    /**
     * 获取订单简介
     *
     * @return subject - 订单简介
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置订单简介
     *
     * @param subject 订单简介
     */
    public void setSubject(String subject) {
        this.subject = subject;
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