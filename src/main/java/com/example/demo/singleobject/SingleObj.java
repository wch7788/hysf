package com.example.demo.singleobject;
//懒汉模式
public class SingleObj {
	 private static SingleObj singleobj;//实例
	 
	 public SingleObj() {}//私有构造
	 //实例化
	 static{
		 singleobj = new SingleObj();
		 
	 }
	 //静态工厂
	 public synchronized static SingleObj getInstance(){
		 if(singleobj == null){
			 singleobj = new SingleObj();
		 }
		 return singleobj;
	 }
	 
	 

}
