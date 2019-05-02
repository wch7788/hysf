package com.example.demo.dto.grade;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.math.BigDecimal;
import java.sql.Date;

public class GradeResponse {

    @Excel(name="学号",width=20)
    private String studentId;
    @Excel(name="姓名",width=10)
    private String studentName;
    @Excel(name="科目",width=10)
    private String courseName;
    @Excel(name="成绩")
    private BigDecimal grade;
    @Excel(name="考试日期",width=20)
    private Date date;

    public GradeResponse() {
    }

    public GradeResponse(String studentId, String studentName, String courseName, BigDecimal grade, Date date) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.grade = grade;
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
