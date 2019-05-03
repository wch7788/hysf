package com.example.demo.Service;

import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;

public interface ChoiceService {

    PageResponseDto<ChoiceResponseDto> getChoiceList(ChoiceRequestDto choiceRequestDto);

}
