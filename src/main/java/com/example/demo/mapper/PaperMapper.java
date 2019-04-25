package com.example.demo.mapper;

import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper {

    Page<PaperResponseDto> getPaperList(PaperRequestDto paperRequestDto);
}
