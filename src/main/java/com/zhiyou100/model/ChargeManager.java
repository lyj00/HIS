package com.zhiyou100.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ChargeManager {
	private PayItems payItems;
	private RegistrationInfor registrationInfor;
    private Integer id;

    private String medical_record;

    private Integer pay_items_id;

    private Double charge_money;
	
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date charge_time;

	public Integer getId() {
		return id;
	}

	public RegistrationInfor getRegistrationInfor() {
		return registrationInfor;
	}

	public void setRegistrationInfor(RegistrationInfor registrationInfor) {
		this.registrationInfor = registrationInfor;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

	public Integer getPay_items_id() {
		return pay_items_id;
	}

	public void setPay_items_id(Integer pay_items_id) {
		this.pay_items_id = pay_items_id;
	}

	public Double getCharge_money() {
		return charge_money;
	}

	public void setCharge_money(Double charge_money) {
		this.charge_money = charge_money;
	}


	public PayItems getPayItems() {
		return payItems;
	}

	public void setPayItems(PayItems payItems) {
		this.payItems = payItems;
	}

	public Date getCharge_time() {
		return charge_time;
	}

	public void setCharge_time(Date charge_time) {
		this.charge_time = charge_time;
	}

	@Override
	public String toString() {
		return "ChargeManager [payItems=" + payItems + ", registrationInfor=" + registrationInfor + ", id=" + id
				+ ", medical_record=" + medical_record + ", pay_items_id=" + pay_items_id + ", charge_money="
				+ charge_money + ", charge_time=" + charge_time + "]";
	}
    
    
    
    
    
}