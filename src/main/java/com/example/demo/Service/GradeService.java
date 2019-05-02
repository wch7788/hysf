package com.example.demo.Service;

import org.apache.poi.ss.usermodel.Workbook;

import java.sql.Date;

public interface GradeService {

    Workbook export(String courseId, Date date);
}
