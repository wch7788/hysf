package com.example.demo.bean;

public class Student {
	private int id;
	private String name;
	private String number;
	private int classId;

	public Student(int id, String name, String number, int classId) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.classId = classId;
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
}
