package com.example.demo.Service;

import org.apache.poi.ss.usermodel.Workbook;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface GradeService {

    Workbook export(String courseId, Date date);

    List<Map<String, Object>> getCourseList();

    List<Map<String, Object>> getTeacherList();

    List<Map<String, Object>> getGradeCourse();

    List<Date> getGradeDate(String courseId);

}
