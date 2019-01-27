package com.example.demo.bean;

public class Address {
 private int id;
 private String address;
public Address(int id, String address) {
	super();
	this.id = id;
	this.address = address;
}
public Address() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

 
}
