package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Student;

@Mapper
public interface StudentMapper {
	public void add(Student student);
	public void delete(int id);
	public void update(Student student);
	public void updateAll(Student student);
	public void FindById(int id);
	public Student FindOneStudentById(int id);
	public Student FindStudent(int id);
	public List<Student> FindStudentByCid(int id);
	public List<Student> FindAllStudent();
	
	//根据年龄或者姓名查找学生
	public List<Student> FindStudentByAgeOrName(Student student);
	public String getmessage();
	public String findpasswordByName(String username);
    
}
