package com.example.demo.mapper;

import com.example.demo.bean.Choice;
import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChoiceMapper {

    Page<ChoiceResponseDto> getChoiceList(ChoiceRequestDto choiceRequestDto);

    ChoiceResponseDto getChoiceById(int id);

    Boolean deleteById(int id);

    Boolean updateChoice(Choice choice);

    Boolean batchSaveChoiceList(List<Choice> choiceList);

}
