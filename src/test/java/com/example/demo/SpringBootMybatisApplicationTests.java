package com.example.demo;

import java.util.ArrayList;
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
		//this.addAddress();
		//this.deleteAddress();
		/*this.updateAddress();*/
		/*this.FindAddress();*/
		//this.addClass();
		//this.deleteClass();
      	//this.updateClass();
     	//this.FindClass();
		//this.addStudent();
		//this.deleteStudent();
		//this.updateStudent();
		//this.FindStudent();
		
		//this.getAddressBystudent();
		//this.getStudentsByclass();
		
		this.getAddressandClass();//根据姓名年龄查找
		//this.DeleteSomeAddress();//批量删除
	}
	
   public void addAddress(){
	   Address address=new Address();
	   address.setId(17);
	   address.setAddress("xxxx");
	   addressmapper.add(address);
   }	
   
   public void addClass(){
	   
	   Class classroom=new Class();
	   classroom.setId(1234);
	   classroom.setName("1234班");
	   classmapper.add(classroom);
   }
   
   public void addStudent(){
	   Student student=new Student();
	   student.setId(153);
	   student.setAge(66);
	   student.setName("王二");
	  
	   studentmapper.add(student);
	   
	   
   }
   
   public void deleteAddress(){
	   addressmapper.delete(1);
	   
   }
   public void deleteClass(){
	   classmapper.delete(1234);
   }
   public void deleteStudent(){
	   studentmapper.delete(153);
   }
   
   public void updateAddress(){
	   Address address=new Address();
	   address.setId(97);
	   address.setAddress("97号");
	  addressmapper.update(address); 
	 }
   
   public void updateClass(){
	   Class classroom=new Class();
	   classroom.setId(103);
	   classroom.setName("103班");
	   classmapper.update(classroom);
   }
   
   public void updateStudent(){
	   
	   Student student=new Student();
	   student.setId(123);
	   student.setAge(66);
	   student.setName("刘三");
	   studentmapper.update(student);
	   
   }
   
   public void FindAddress(){
	   addressmapper.Findbyid(1);
	   
   }
   
   public void FindClass(){
	   classmapper.Findbyid(103);
	   
   }
   
   public void FindStudent(){
	   studentmapper.FindById(2);
   }
   
   //一对一 查出学生及地址
   public void getAddressBystudent(){
	   studentmapper.FindStudent(2);
   }
  
   //一对多查出班级下的学生以及其地址
 public void getStudentsByclass(){
	   classmapper.getStudents(102);
   }
 
   public void getAddressandClass(){
	   Student student=new Student();
	   student.setAge(66);
	   
	   studentmapper.FindStudentByAgeOrName(student);
	   
   }
   
   public void DeleteSomeAddress(){
	   List<Address> list=new ArrayList<Address>();
	   Address a1=new Address();
	   Address a2=new Address();
	   a1.setId(100);
	   a2.setId(101);
	   list.add(a1);
	   list.add(a2);
	  addressmapper.DeleteAllById(list);
	   
   }
}
