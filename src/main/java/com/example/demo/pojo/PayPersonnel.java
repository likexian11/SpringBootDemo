package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "pay_personnel")
public class PayPersonnel {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 归属机构
     */
    private String organ_no;

    /**
     * 缴费号（唯一）
     */
    private String pay_no;

    /**
     * 缴费人员名称
     */
    private String per_name;

    /**
     * 缴费人员手机号
     */
    private String tel;

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
     * 获取归属机构
     *
     * @return organ_no - 归属机构
     */
    public String getOrgan_no() {
        return organ_no;
    }

    /**
     * 设置归属机构
     *
     * @param organ_no 归属机构
     */
    public void setOrgan_no(String organ_no) {
        this.organ_no = organ_no;
    }

    /**
     * 获取缴费号（唯一）
     *
     * @return pay_no - 缴费号（唯一）
     */
    public String getPay_no() {
        return pay_no;
    }

    /**
     * 设置缴费号（唯一）
     *
     * @param pay_no 缴费号（唯一）
     */
    public void setPay_no(String pay_no) {
        this.pay_no = pay_no;
    }

    /**
     * 获取缴费人员名称
     *
     * @return per_name - 缴费人员名称
     */
    public String getPer_name() {
        return per_name;
    }

    /**
     * 设置缴费人员名称
     *
     * @param per_name 缴费人员名称
     */
    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }

    /**
     * 获取缴费人员手机号
     *
     * @return tel - 缴费人员手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置缴费人员手机号
     *
     * @param tel 缴费人员手机号
     */
    public void setTel(String tel) {
        this.tel = tel;
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