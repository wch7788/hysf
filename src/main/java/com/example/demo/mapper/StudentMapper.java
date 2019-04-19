package com.example.demo.mapper;

import com.example.demo.bean.Student;
import com.example.demo.dto.student.StudentRequestDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    Page<Student> getStudentList(StudentRequestDto studentRequestDto);

    Student getStudentById(int id);

    Boolean saveStudent(Student student);

}
