package com.example.demo.mapper;

import com.example.demo.bean.Text;
import com.example.demo.dto.text.TextRequestDto;
import com.example.demo.dto.text.TextResponseDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TextMapper {

    Page<TextResponseDto> getTextList(TextRequestDto textRequestDto);

    TextResponseDto getText(int id);

    Boolean updateText(Text text);

    Boolean batchSaveTextList(List<Text> textList);

    Boolean deleteById(int id);

}
