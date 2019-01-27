package com.example.demo.bean;

public class Student {
	private int id;
	private String name;
	private int age;
	private Address address;
	private Class classroom;
	
	public Student(int id, String name, int age, Address address, Class classroom) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.classroom = classroom;
	}

	public Student() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public Class getClassroom() {
		return classroom;
	}

	public void setClassroom(Class classroom) {
		this.classroom = classroom;
	}
	
	
	

}
