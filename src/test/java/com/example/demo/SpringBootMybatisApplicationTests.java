package com.example.demo;

import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest


public class SpringBootMybatisApplicationTests {
  @Autowired
   AddressMapper addressmapper;
  @Autowired
  ClassMapper classmapper;
  @Autowired
  StudentMapper studentmapper;
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void Test() {
		this.test();
	}
	
  
   
   public void test(){
       String password=bCryptPasswordEncoder.encode("abcdefg");
       System.out.println(password);
   }
}
