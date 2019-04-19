package com.example.demo.Service.Impl;

import com.example.demo.Service.JudgeService;
import com.example.demo.bean.Judge;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.judge.JudgeRequestDto;
import com.example.demo.dto.judge.JudgeResponseDto;
import com.example.demo.mapper.JudgeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeServiceImpl implements JudgeService {

    @Autowired
    JudgeMapper judgeMapper;

    @Override
    public PageResponseDto<JudgeResponseDto> getJudgeList(JudgeRequestDto judgeRequestDto) {
        PageHelper.startPage(judgeRequestDto.getPageNum(),judgeRequestDto.getPageSize());
        Page<JudgeResponseDto> judgePage=judgeMapper.getJudgeList(judgeRequestDto);
        return new PageResponseDto<>(judgePage);
    }

    @Override
    public JudgeResponseDto getJudge(int id) {
        return judgeMapper.getJudgeById(id);
    }

    @Override
    public Boolean updateJudge(Judge judge) {
        return judgeMapper.updateJudge(judge);
    }

    @Override
    public Boolean addJudgeList(List<Judge> judgeList) {
        return judgeMapper.addJudgeList(judgeList);
    }
}
