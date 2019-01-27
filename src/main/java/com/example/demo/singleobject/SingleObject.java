package com.example.demo.singleobject;
//饿汉
public class SingleObject {

	private static SingleObject singleobject=new SingleObject();
	
	private SingleObject(){} //私有构造
	
	//静态方法
	public static SingleObject getInstance() {
		return singleobject;
	}

	
	
	
}
