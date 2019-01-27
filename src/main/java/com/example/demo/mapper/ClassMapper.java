package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Class;

@Mapper
public interface ClassMapper {
	
	public void add(Class classroom);
	public void delete(int id);
	public void update(Class classroom);
	public Class Findbyid(int id);
	public Class getStudents(int id);
	
}
