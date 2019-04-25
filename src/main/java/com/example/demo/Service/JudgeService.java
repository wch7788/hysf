package com.example.demo.Service;

import com.example.demo.bean.Judge;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.judge.JudgeRequestDto;
import com.example.demo.dto.judge.JudgeResponseDto;

import java.util.List;
import java.util.Map;

public interface JudgeService {

    PageResponseDto<JudgeResponseDto> getJudgeList(JudgeRequestDto judgeRequestDto);

    JudgeResponseDto getJudge(int id);

    Boolean updateJudge(Judge judge);

    Boolean addJudgeList(List<Judge> judgeList);

    List<Map<String, Object>> getQuestionList(String type);

}
