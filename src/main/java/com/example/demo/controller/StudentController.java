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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "学生模块")
@RequestMapping("/v1/student")
public class StudentController {

     @Autowired
    StudentService studentService;

    @ApiOperation(value = "按条件获取学生数据")
    @PostMapping("/list")
    public Map<String, ?> listStudent(@RequestBody StudentRequestDto studentRequestDto) {
        PageResponseDto<Student> studentResult=studentService.getStudentList(studentRequestDto);
        return JSONResult.fillResult(Utils.ResultStatus.OK,studentResult.getResultMap(),"成功");
    }

    @ApiOperation(value = "获取指定ID学生数据")
    @GetMapping("/getStudent/{id}")
    public Map<String, ?> getStudent(@PathVariable("id") int id) {
        Student student=studentService.getStudentById(id);
        return JSONResult.fillResult(Utils.ResultStatus.OK,student,"成功");
    }

    @ApiOperation(value = "保存学生信息")
    @PostMapping("/saveStudent")
    public Map<String, ?> saveStudent(@RequestBody  Student student) {
        Boolean result=studentService.saveStudent(student);
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

}
