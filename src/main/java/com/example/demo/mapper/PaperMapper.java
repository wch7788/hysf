package com.example.demo.mapper;

import com.example.demo.bean.*;
import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {

    Page<PaperResponseDto> getPaperList(PaperRequestDto paperRequestDto);

    List<Judge> getJudgeList(int id);

    List<Choice> getChoiceList(int id);

    List<Text> getTextList(int id);

    Boolean addPaper(Paper paper);

    boolean addPaperQuestion(List<PaperQuestion> list);

}
