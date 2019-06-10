package com.example.demo.pojo;

public class Custom {
    /**
     * 缴费号
     */
    private String pay_no;

    /**
     * 缴费所属组织id
     */
    private String organ_no;

    /**
     * 缴费人
     */
    private String per_name;
    
    /**
     * 缴费编号
     */
    private String pay_project_id;
    
    /**
     	* 订单编号
     */
    private String id;

    /**
     * 缴费项目名称
     */
    private String project_name;

    /**
     * 已缴费金额
     */
    private double already_pay;
    
    /**
     * 所需缴费金额
     */
    private double pay_money;
    
    /**
     * 剩余需缴费金额
     */
    private double money;

	public String getPay_no() {
		return pay_no;
	}

	public void setPay_no(String pay_no) {
		this.pay_no = pay_no;
	}

	public String getOrgan_no() {
		return organ_no;
	}

	public void setOrgan_no(String organ_no) {
		this.organ_no = organ_no;
	}

	public String getPay_project_id() {
		return pay_project_id;
	}

	public void setPay_project_id(String pay_project_id) {
		this.pay_project_id = pay_project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public double getAlready_pay() {
		return already_pay;
	}

	public void setAlready_pay(double already_pay) {
		this.already_pay = already_pay;
	}

	public double getPay_money() {
		return pay_money;
	}

	public void setPay_money(double pay_money) {
		this.pay_money = pay_money;
	}

	public String getPer_name() {
		return per_name;
	}

	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}