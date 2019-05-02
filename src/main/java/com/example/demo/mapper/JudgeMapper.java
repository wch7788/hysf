package com.example.demo.mapper;

import com.example.demo.bean.Judge;
import com.example.demo.dto.judge.JudgeRequestDto;
import com.example.demo.dto.judge.JudgeResponseDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JudgeMapper {

    Page<JudgeResponseDto> getJudgeList(JudgeRequestDto judgeRequestDto);

    JudgeResponseDto getJudgeById(int id);

    Boolean updateJudge(Judge judge);

    Boolean addJudgeList(List<Judge> judgeList);

    List<Map<String, Object>> getQuestionType(String type);

    Boolean deleteById(int id);

    boolean deletePaperQuestion(int id);

}
