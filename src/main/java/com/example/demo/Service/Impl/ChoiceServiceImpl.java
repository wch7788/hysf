package com.example.demo.Service.Impl;

import com.example.demo.Service.ChoiceService;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;
import com.example.demo.mapper.ChoiceMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceServiceImpl implements ChoiceService {

    @Autowired
    ChoiceMapper choiceMapper;

    @Override
    public PageResponseDto<ChoiceResponseDto> getChoiceList(ChoiceRequestDto choiceRequestDto) {
        PageHelper.startPage(choiceRequestDto.getPageNum(),choiceRequestDto.getPageSize());
        Page<ChoiceResponseDto> choicePage=choiceMapper.getChoiceList(choiceRequestDto);
        return new PageResponseDto<>(choicePage);
    }
}
