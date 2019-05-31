package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "fkr_paycost_detail")
public class PaycostDetail {
    /**
     * 缴费号
     */
    @Column(name = "paycost_num")
    private String paycostNum;

    /**
     * 学校id
     */
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 校区id
     */
    @Column(name = "school_area_id")
    private Integer schoolAreaId;

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 学院id
     */
    @Column(name = "academy_id")
    private Integer academyId;

    /**
     * 学院名称
     */
    @Column(name = "academy_name")
    private String academyName;

    /**
     * 专业id
     */
    @Column(name = "professional_id")
    private Integer professionalId;

    /**
     * 专业名称
     */
    @Column(name = "prf_name")
    private String prfName;

    /**
     * 班级
     */
    @Column(name = "class_num")
    private String classNum;

    /**
     * 缴费金额
     */
    private Double money;

    /**
     * 缴费id
     */
    @Column(name = "cost_id")
    private Integer costId;

    /**
     * 缴费项目名字
     */
    @Column(name = "cost_name")
    private String costName;

    /**
     * 学生名字
     */
    @Column(name = "student_name")
    private String studentName;

    /**
     * 导入批号
     */
    @Column(name = "batch_num")
    private String batchNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否缴费 1:是/0:否/2:部分缴费
     */
    @Column(name = "is_pay")
    private Integer isPay;

    /**
     * 缴费时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 是否有效 1:是0：否
     */
    private Integer status;

    /**
     * 获取缴费号
     *
     * @return paycost_num - 缴费号
     */
    public String getPaycostNum() {
        return paycostNum;
    }

    /**
     * 设置缴费号
     *
     * @param paycostNum 缴费号
     */
    public void setPaycostNum(String paycostNum) {
        this.paycostNum = paycostNum;
    }

    /**
     * 获取学校id
     *
     * @return school_id - 学校id
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校id
     *
     * @param schoolId 学校id
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取校区id
     *
     * @return school_area_id - 校区id
     */
    public Integer getSchoolAreaId() {
        return schoolAreaId;
    }

    /**
     * 设置校区id
     *
     * @param schoolAreaId 校区id
     */
    public void setSchoolAreaId(Integer schoolAreaId) {
        this.schoolAreaId = schoolAreaId;
    }

    /**
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称
     *
     * @param schoolName 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * 获取学院id
     *
     * @return academy_id - 学院id
     */
    public Integer getAcademyId() {
        return academyId;
    }

    /**
     * 设置学院id
     *
     * @param academyId 学院id
     */
    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    /**
     * 获取学院名称
     *
     * @return academy_name - 学院名称
     */
    public String getAcademyName() {
        return academyName;
    }

    /**
     * 设置学院名称
     *
     * @param academyName 学院名称
     */
    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    /**
     * 获取专业id
     *
     * @return professional_id - 专业id
     */
    public Integer getProfessionalId() {
        return professionalId;
    }

    /**
     * 设置专业id
     *
     * @param professionalId 专业id
     */
    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * 获取专业名称
     *
     * @return prf_name - 专业名称
     */
    public String getPrfName() {
        return prfName;
    }

    /**
     * 设置专业名称
     *
     * @param prfName 专业名称
     */
    public void setPrfName(String prfName) {
        this.prfName = prfName;
    }

    /**
     * 获取班级
     *
     * @return class_num - 班级
     */
    public String getClassNum() {
        return classNum;
    }

    /**
     * 设置班级
     *
     * @param classNum 班级
     */
    public void setClassNum(String classNum) {
        this.classNum = classNum;
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
    public Integer getCostId() {
        return costId;
    }

    /**
     * 设置缴费id
     *
     * @param costId 缴费id
     */
    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    /**
     * 获取缴费项目名字
     *
     * @return cost_name - 缴费项目名字
     */
    public String getCostName() {
        return costName;
    }

    /**
     * 设置缴费项目名字
     *
     * @param costName 缴费项目名字
     */
    public void setCostName(String costName) {
        this.costName = costName;
    }

    /**
     * 获取学生名字
     *
     * @return student_name - 学生名字
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置学生名字
     *
     * @param studentName 学生名字
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取导入批号
     *
     * @return batch_num - 导入批号
     */
    public String getBatchNum() {
        return batchNum;
    }

    /**
     * 设置导入批号
     *
     * @param batchNum 导入批号
     */
    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
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
    public Integer getIsPay() {
        return isPay;
    }

    /**
     * 设置是否缴费 1:是/0:否/2:部分缴费
     *
     * @param isPay 是否缴费 1:是/0:否/2:部分缴费
     */
    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    /**
     * 获取缴费时间
     *
     * @return pay_time - 缴费时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置缴费时间
     *
     * @param payTime 缴费时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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