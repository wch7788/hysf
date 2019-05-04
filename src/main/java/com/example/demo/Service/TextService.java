package com.example.demo.Service;

import com.example.demo.bean.Text;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.text.TextRequestDto;
import com.example.demo.dto.text.TextResponseDto;

import java.util.List;

public interface TextService {

    PageResponseDto<TextResponseDto> getTextList(TextRequestDto textRequestDto);

    TextResponseDto getText(int id);

    Boolean updateText(Text text);

    Boolean addTextList(List<Text> textList);

    Boolean deleteById(int id);

}
