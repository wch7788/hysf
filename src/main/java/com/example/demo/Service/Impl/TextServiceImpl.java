package com.example.demo.Service.Impl;

import com.example.demo.Service.TextService;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.choice.ChoiceResponseDto;
import com.example.demo.dto.text.TextRequestDto;
import com.example.demo.dto.text.TextResponseDto;
import com.example.demo.mapper.TextMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {

    @Autowired
    TextMapper textMapper;

    @Override
    public PageResponseDto<TextResponseDto> getTextList(TextRequestDto textRequestDto) {
        PageHelper.startPage(textRequestDto.getPageNum(),textRequestDto.getPageSize());
        Page<TextResponseDto> textPage=textMapper.getTextList(textRequestDto);
        return new PageResponseDto<>(textPage);    }
}
