package com.zhiyou100.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HospitalInfor {
	
	private int id;
	
	private int doctor_id;
	
	private int section_id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date time;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	private Section section;
	
	private Doctor doctor;
	
    private String medical_record;

    private String caregiver;

    private String bed_id;

    private Double pay_the_deposit;

    private String state_illness;

    
    
	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

	public String getCaregiver() {
		return caregiver;
	}

	public void setCaregiver(String caregiver) {
		this.caregiver = caregiver;
	}

	public String getBed_id() {
		return bed_id;
	}

	public void setBed_id(String bed_id) {
		this.bed_id = bed_id;
	}

	public Double getPay_the_deposit() {
		return pay_the_deposit;
	}

	public void setPay_the_deposit(Double pay_the_deposit) {
		this.pay_the_deposit = pay_the_deposit;
	}

	public String getState_illness() {
		return state_illness;
	}

	public void setState_illness(String state_illness) {
		this.state_illness = state_illness;
	}

	@Override
	public String toString() {
		return "HospitalInfor [id=" + id + ", doctor_id=" + doctor_id + ", section_id=" + section_id + ", time=" + time
				+ ", section=" + section + ", doctor=" + doctor + ", medical_record=" + medical_record + ", caregiver="
				+ caregiver + ", bed_id=" + bed_id + ", pay_the_deposit=" + pay_the_deposit + ", state_illness="
				+ state_illness + "]";
	}

    
}