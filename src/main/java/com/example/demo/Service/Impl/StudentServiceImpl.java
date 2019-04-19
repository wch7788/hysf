package com.example.demo.Service.Impl;

import com.example.demo.Service.StudentService;
import com.example.demo.bean.Student;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.student.StudentRequestDto;
import com.example.demo.mapper.StudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public PageResponseDto<Student> getStudentList(StudentRequestDto studentRequestDto) {
        PageHelper.startPage(studentRequestDto.getPageNum(),studentRequestDto.getPageSize());
        Page<Student> studentPage=studentMapper.getStudentList(studentRequestDto);
        return new PageResponseDto<>(studentPage);

    }

    @Override
    public Student getStudentById(int id) {
           return studentMapper.getStudentById(id);
    }

    @Override
    public Boolean saveStudent(Student student) {
           return studentMapper.saveStudent(student);
    }
}
