package com.example.demo.Service.Impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.Service.GradeService;
import com.example.demo.dto.grade.GradeResponse;
import com.example.demo.mapper.GradeMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeMapper gradeMapper;


    @Override
    public Workbook export(String courseId, Date date) {
        List<GradeResponse> list=gradeMapper.getGradeList(courseId,date);
        System.out.println(list.get(0).getDate());
        ExportParams params=new ExportParams();
        Workbook workbook= ExcelExportUtil.exportBigExcel(params,GradeResponse.class, list);
        ExcelExportUtil.closeExportBigExcel();
        return workbook;

    }

    @Override
    public List<Map<String, Object>> getCourseList() {
        return gradeMapper.getCourseList();
    }

    @Override
    public List<Map<String, Object>> getTeacherList() {
        return gradeMapper.getTeacherList();
    }

    @Override
    public List<Map<String, Object>> getGradeCourse() {
        return gradeMapper.getGradeCourse();
    }

    @Override
    public List<Date> getGradeDate(String courseId) {
        if("0".equals(courseId)){
            return null;
        }
        return gradeMapper.getGradeDate(courseId);
    }
}
