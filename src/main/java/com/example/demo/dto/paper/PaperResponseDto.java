package com.example.demo.dto.paper;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PaperResponseDto {

    private int id;
    private String courseName;
    private String teacherName;
    private Date createDate;
    private String info;

    public PaperResponseDto() {
    }

    public PaperResponseDto(int id, String courseName, String teacherName, Date createDate, String info) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.createDate = createDate;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
