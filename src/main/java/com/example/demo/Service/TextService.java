package com.example.demo.Service;

import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.text.TextRequestDto;
import com.example.demo.dto.text.TextResponseDto;

public interface TextService {

    PageResponseDto<TextResponseDto> getTextList(TextRequestDto textRequestDto);
}
