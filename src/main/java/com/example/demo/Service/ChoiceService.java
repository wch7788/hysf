package com.example.demo.Service;

import com.example.demo.bean.Choice;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;

import java.util.List;

public interface ChoiceService {

    PageResponseDto<ChoiceResponseDto> getChoiceList(ChoiceRequestDto choiceRequestDto);

    ChoiceResponseDto getChoice(int id);

    Boolean deleteChoice(int id);

    Boolean updateChoice(Choice choice);

    Boolean addChoice(List<Choice> choiceList);

}
