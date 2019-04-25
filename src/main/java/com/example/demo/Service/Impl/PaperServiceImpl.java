package com.example.demo.Service.Impl;

import com.example.demo.Service.PaperService;
import com.example.demo.bean.Student;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;
import com.example.demo.mapper.PaperMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;

    @Override
    public PageResponseDto<PaperResponseDto> getPaperList(PaperRequestDto paperRequestDto) {
        PageHelper.startPage(paperRequestDto.getPageNum(),paperRequestDto.getPageSize());
        Page<PaperResponseDto> paperPage=paperMapper.getPaperList(paperRequestDto);
        return new PageResponseDto<>(paperPage);

    }
}
