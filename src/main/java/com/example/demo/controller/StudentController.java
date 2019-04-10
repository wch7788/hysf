package com.example.demo.controller;

import com.example.demo.Service.StudentService;
import com.example.demo.bean.Student;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.student.StudentRequestDto;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(tags = "学生模块")
@RequestMapping("/v1/student")
public class StudentController {

     @Autowired
    StudentService studentService;

    @ApiOperation(value = "获取数据")
    @PostMapping("/list")
    public Map<String, ?> list(@RequestBody StudentRequestDto studentRequestDto) {
        PageResponseDto<Student> studentResult=studentService.getStudentList(studentRequestDto);
        return JSONResult.fillResult(Utils.ResultStatus.OK,studentResult.getResultMap(),"成功");
    }
}
