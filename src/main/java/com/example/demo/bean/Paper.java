package com.example.demo.bean;

import java.util.Date;

public class Paper {

    private int id;
    private String courseId;
    private Date createDate;
    private String teacherId;
    private String info;

    public Paper() {
    }

    public Paper(int id, String courseId, Date createDate, String teacherId, String info) {
        this.id = id;
        this.courseId = courseId;
        this.createDate = createDate;
        this.teacherId = teacherId;
        this.info = info;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
