package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Grade {

    private int id;
    private String courseId;
    private String studentId;
    private BigDecimal grade;
    private Date date;

    public Grade() {
    }

    public Grade(int id, String courseId, String studentId, BigDecimal grade, Date date) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
