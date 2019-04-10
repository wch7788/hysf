package com.example.demo.dto.student;

import com.example.demo.dto.PageCondition;

public class StudentRequestDto implements PageCondition {

    private int pageNum;
    private int pageSize;
    private String name;

    @Override
    public int getPageNum() {
        return pageNum;
    }

    @Override
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
