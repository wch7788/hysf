package com.example.demo.bean;

import java.util.List;

public class Class {
	private int id;
	private String name;
	private List<Student> students;
	public Class(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Class() {
		super();
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

}
