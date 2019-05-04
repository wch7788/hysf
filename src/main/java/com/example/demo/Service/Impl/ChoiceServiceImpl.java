package com.example.demo.Service.Impl;

import com.example.demo.Service.ChoiceService;
import com.example.demo.bean.Choice;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;
import com.example.demo.mapper.ChoiceMapper;
import com.example.demo.mapper.PaperMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {

    @Autowired
    ChoiceMapper choiceMapper;
    @Autowired
    PaperMapper paperMapper;

    @Override
    public PageResponseDto<ChoiceResponseDto> getChoiceList(ChoiceRequestDto choiceRequestDto) {
        PageHelper.startPage(choiceRequestDto.getPageNum(),choiceRequestDto.getPageSize());
        Page<ChoiceResponseDto> choicePage=choiceMapper.getChoiceList(choiceRequestDto);
        return new PageResponseDto<>(choicePage);
    }

    @Override
    public ChoiceResponseDto getChoice(int id) {
        return choiceMapper.getChoiceById(id);
    }

    @Override
    public Boolean deleteChoice(int id) {
        return choiceMapper.deleteById(id)&&paperMapper.deletePaperQuestion(id,"2");
    }

    @Override
    public Boolean updateChoice(Choice choice) {
        return choiceMapper.updateChoice(choice);
    }

    @Override
    public Boolean addChoice(List<Choice> choiceList) {
        return choiceMapper.batchSaveChoiceList(choiceList);
    }
}
