package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "fkr_paycost_detail")
public class PaycostDetail {
    /**
     * 缴费号
     */
    private String paycost_num;

    /**
     * 学校id
     */
    private Integer school_id;

    /**
     * 校区id
     */
    private Integer school_area_id;

    /**
     * 学校名称
     */
    private String school_name;

    /**
     * 学院id
     */
    private Integer academy_id;

    /**
     * 学院名称
     */
    private String academy_name;

    /**
     * 专业id
     */
    private Integer professional_id;

    /**
     * 专业名称
     */
    private String prf_name;

    /**
     * 班级
     */
    private String class_num;

    /**
     * 缴费金额
     */
    private Double money;

    /**
     * 缴费id
     */
    private Integer cost_id;

    /**
     * 缴费项目名字
     */
    private String cost_name;

    /**
     * 学生名字
     */
    private String student_name;

    /**
     * 导入批号
     */
    private String batch_num;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否缴费 1:是/0:否/2:部分缴费
     */
    private Integer is_pay;

    /**
     * 缴费时间
     */
    private Date pay_time;

    /**
     * 是否有效 1:是0：否
     */
    private Integer status;

    /**
     * 获取缴费号
     *
     * @return paycost_num - 缴费号
     */
    public String getPaycost_num() {
        return paycost_num;
    }

    /**
     * 设置缴费号
     *
     * @param paycost_num 缴费号
     */
    public void setPaycost_num(String paycost_num) {
        this.paycost_num = paycost_num;
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
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchool_name() {
        return school_name;
    }

    /**
     * 设置学校名称
     *
     * @param school_name 学校名称
     */
    public void setSchool_name(String school_name) {
        this.school_name = school_name;
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
     * 获取学院名称
     *
     * @return academy_name - 学院名称
     */
    public String getAcademy_name() {
        return academy_name;
    }

    /**
     * 设置学院名称
     *
     * @param academy_name 学院名称
     */
    public void setAcademy_name(String academy_name) {
        this.academy_name = academy_name;
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
     * 获取专业名称
     *
     * @return prf_name - 专业名称
     */
    public String getPrf_name() {
        return prf_name;
    }

    /**
     * 设置专业名称
     *
     * @param prf_name 专业名称
     */
    public void setPrf_name(String prf_name) {
        this.prf_name = prf_name;
    }

    /**
     * 获取班级
     *
     * @return class_num - 班级
     */
    public String getClass_num() {
        return class_num;
    }

    /**
     * 设置班级
     *
     * @param class_num 班级
     */
    public void setClass_num(String class_num) {
        this.class_num = class_num;
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
     * 获取缴费项目名字
     *
     * @return cost_name - 缴费项目名字
     */
    public String getCost_name() {
        return cost_name;
    }

    /**
     * 设置缴费项目名字
     *
     * @param cost_name 缴费项目名字
     */
    public void setCost_name(String cost_name) {
        this.cost_name = cost_name;
    }

    /**
     * 获取学生名字
     *
     * @return student_name - 学生名字
     */
    public String getStudent_name() {
        return student_name;
    }

    /**
     * 设置学生名字
     *
     * @param student_name 学生名字
     */
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    /**
     * 获取导入批号
     *
     * @return batch_num - 导入批号
     */
    public String getBatch_num() {
        return batch_num;
    }

    /**
     * 设置导入批号
     *
     * @param batch_num 导入批号
     */
    public void setBatch_num(String batch_num) {
        this.batch_num = batch_num;
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

    /**
     * 获取是否缴费 1:是/0:否/2:部分缴费
     *
     * @return is_pay - 是否缴费 1:是/0:否/2:部分缴费
     */
    public Integer getIs_pay() {
        return is_pay;
    }

    /**
     * 设置是否缴费 1:是/0:否/2:部分缴费
     *
     * @param is_pay 是否缴费 1:是/0:否/2:部分缴费
     */
    public void setIs_pay(Integer is_pay) {
        this.is_pay = is_pay;
    }

    /**
     * 获取缴费时间
     *
     * @return pay_time - 缴费时间
     */
    public Date getPay_time() {
        return pay_time;
    }

    /**
     * 设置缴费时间
     *
     * @param pay_time 缴费时间
     */
    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    /**
     * 获取是否有效 1:是0：否
     *
     * @return status - 是否有效 1:是0：否
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否有效 1:是0：否
     *
     * @param status 是否有效 1:是0：否
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}