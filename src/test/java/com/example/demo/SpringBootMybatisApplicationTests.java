package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Address;
import com.example.demo.bean.Class;
import com.example.demo.bean.Student;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest


public class SpringBootMybatisApplicationTests {
  @Autowired
   AddressMapper addressmapper;
  @Autowired
  ClassMapper classmapper;
  @Autowired
  StudentMapper studentmapper;
  
     

	
	
	@Test
	public void Test() {
		this.test();
	}
	
  
   
   public void test(){
	 Date date=new Date();
	 SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	 System.out.println(df.format(date)+"----"+date);
	   
   }
}
