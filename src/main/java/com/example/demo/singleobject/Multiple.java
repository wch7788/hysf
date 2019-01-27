package com.example.demo.singleobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//多例模式
public class Multiple {
	
	private static List<Multiple> objs=new ArrayList<Multiple>();
	
	private static int index;
	
	private Multiple() {};
	
	
	//实例化
	static{
		for(int i=index ; i < 5;i++){
			objs.add(new Multiple());
		}
	}
	
	public static Multiple getInstance(){
		Random r=new Random();
		index = r.nextInt(5);
		return objs.get(index);
	}

}
