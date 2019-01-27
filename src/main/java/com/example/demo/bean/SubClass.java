package com.example.demo.bean;

public class SubClass extends SuperClass{
	private int n;

	  
	  SubClass(){
		  
	    super(300);
	    System.out.println("SubClass");
	  }  
	  
	  public SubClass(int n){
		this();
	    System.out.println("SubClass(int n):"+n);
	    this.n = n;
	  }

}
