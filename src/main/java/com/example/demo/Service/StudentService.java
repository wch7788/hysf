package com.example.demo.Service;

import com.example.demo.bean.Student;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.student.StudentRequestDto;

public interface StudentService {

    PageResponseDto<Student> getStudentList(StudentRequestDto studentRequestDto);
}
