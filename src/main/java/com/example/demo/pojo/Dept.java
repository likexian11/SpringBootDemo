package com.example.demo.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_dept")
public class Dept {
    /**
     * 部门id
     */
    @Id
    private Integer dept_id;

    /**
     * 父部门id
     */
    private Integer parent_id;

    /**
     * 部门名称
     */
    private String dept_name;

    /**
     * 显示顺序
     */
    private Integer order_num;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门状态:0正常,1停用
     */
    private Integer status;

    /**
     * 创建者
     */
    private String create_by;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新者
     */
    private String update_by;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public Integer getDept_id() {
        return dept_id;
    }

    /**
     * 设置部门id
     *
     * @param dept_id 部门id
     */
    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    /**
     * 获取父部门id
     *
     * @return parent_id - 父部门id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置父部门id
     *
     * @param parent_id 父部门id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDept_name() {
        return dept_name;
    }

    /**
     * 设置部门名称
     *
     * @param dept_name 部门名称
     */
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    /**
     * 获取显示顺序
     *
     * @return order_num - 显示顺序
     */
    public Integer getOrder_num() {
        return order_num;
    }

    /**
     * 设置显示顺序
     *
     * @param order_num 显示顺序
     */
    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    /**
     * 获取负责人
     *
     * @return leader - 负责人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 设置负责人
     *
     * @param leader 负责人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取部门状态:0正常,1停用
     *
     * @return status - 部门状态:0正常,1停用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置部门状态:0正常,1停用
     *
     * @param status 部门状态:0正常,1停用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreate_by() {
        return create_by;
    }

    /**
     * 设置创建者
     *
     * @param create_by 创建者
     */
    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * 设置创建时间
     *
     * @param create_time 创建时间
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdate_by() {
        return update_by;
    }

    /**
     * 设置更新者
     *
     * @param update_by 更新者
     */
    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * 设置更新时间
     *
     * @param update_time 更新时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}