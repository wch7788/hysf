package com.example.demo.controller;

import com.example.demo.Service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

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
}
