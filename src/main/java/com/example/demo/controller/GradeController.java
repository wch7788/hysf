package com.example.demo.controller;

import com.example.demo.Service.GradeService;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "成绩模块")
@RequestMapping("/v1/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @ApiOperation(value="导出成绩结果",produces="application/octet-stream")
    @GetMapping(value="/export")
    public void exportSingleVMERateResult(HttpServletResponse response, @RequestParam(value="courseId",required = false)String courseId, @RequestParam(value="date",required = false)Date date) {
        Workbook wb=gradeService.export(courseId,date);
        try {
            response.setContentType("application/octet-stream;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + "Result.xlsx");
            wb.write(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @ApiOperation(value = "获取课程名")
    @GetMapping("/getCourseList")
    public Map<String, ?> getCourseList() {
        List<Map<String,Object>> result=gradeService.getCourseList();
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

    @ApiOperation(value = "获取教师名")
    @GetMapping("/getTeacherList")
    public Map<String, ?> getTeacherList() {
        List<Map<String,Object>> result=gradeService.getTeacherList();
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

    @ApiOperation(value = "获取考试成绩科目")
    @GetMapping("/getGradeCourse")
    public Map<String, ?> getGradeCourse() {
        List<Map<String,Object>> result=gradeService.getGradeCourse();
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

    @ApiOperation(value = "获取考试成绩时间")
    @GetMapping("/getGradeDate/{courseId}")
    public Map<String, ?> getGradeDate(@PathVariable("courseId") String courseId) {
        List<Date> result=gradeService.getGradeDate(courseId);
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }
}
