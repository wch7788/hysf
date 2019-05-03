package com.example.demo.mapper;

import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChoiceMapper {

    Page<ChoiceResponseDto> getChoiceList(ChoiceRequestDto choiceRequestDto);
}
