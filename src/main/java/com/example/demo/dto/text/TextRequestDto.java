package com.example.demo.dto.text;

import com.example.demo.dto.PageCondition;

public class TextRequestDto implements PageCondition {

    private int pageNum;
    private int pageSize;

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
}
