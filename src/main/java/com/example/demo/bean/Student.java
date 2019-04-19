package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private String number;
	private int classId;
	private String sex;
	private String phone;
	private Date birthDay;

	public Student(int id, String name, String number, int classId, String sex, String phone, Date birthDay) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.classId = classId;
		this.sex = sex;
		this.phone = phone;
		this.birthDay = birthDay;
	}

	public Student() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
}
