package com.example.demo.mapper;

import com.example.demo.dto.text.TextRequestDto;
import com.example.demo.dto.text.TextResponseDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TextMapper {

    Page<TextResponseDto> getTextList(TextRequestDto textRequestDto);
}
