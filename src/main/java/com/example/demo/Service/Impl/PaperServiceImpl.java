package com.example.demo.Service.Impl;

import com.example.demo.Service.PaperService;
import com.example.demo.bean.*;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.paper.NewPaperRequest;
import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;
import com.example.demo.mapper.PaperMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;

    @Override
    public PageResponseDto<PaperResponseDto> getPaperList(PaperRequestDto paperRequestDto) {
        PageHelper.startPage(paperRequestDto.getPageNum(),paperRequestDto.getPageSize());
        Page<PaperResponseDto> paperPage=paperMapper.getPaperList(paperRequestDto);
        return new PageResponseDto<>(paperPage);

    }

    @Override
    public Map<String, Object> getPaperInfo(int id) {
        Map<String, Object> map=new HashMap<>();
        List<Judge> judgeList=paperMapper.getJudgeList(id);
        List<Choice> choiceList=paperMapper.getChoiceList(id);
        List<Text> textList=paperMapper.getTextList(id);
        map.put("judgeList",judgeList);
        map.put("choiceList",choiceList);
        map.put("textList",textList);
        return map;
    }

    @Override
    @Transactional
    public boolean addPaper(NewPaperRequest newPaperRequest) {
        List<PaperQuestion> list=new ArrayList<>();
        String info=newPaperRequest.getInfo();
        String teacherId=newPaperRequest.getTeacherId();
        String courseId=newPaperRequest.getCourseId();
        int[] judgeId=newPaperRequest.getJudgeList();
        int[] choiceId=newPaperRequest.getChoiceList();
        int[] textId=newPaperRequest.getTextList();
        Paper paper=new Paper();
        paper.setInfo(info);
        paper.setCourseId(courseId);
        paper.setTeacherId(teacherId);
        Boolean bool=paperMapper.addPaper(paper);
        int paperId=paper.getId();
        if(judgeId!=null){
            for(int i=0;i<judgeId.length;i++){
                PaperQuestion pq=new PaperQuestion();
                pq.setPaperId(paperId);
                pq.setQuestionId(judgeId[i]);
                pq.setType("1");
                list.add(pq);
            }
        }
        if(choiceId!=null){
            for(int i=0;i<choiceId.length;i++){
                PaperQuestion pq=new PaperQuestion();
                pq.setPaperId(paperId);
                pq.setQuestionId(choiceId[i]);
                pq.setType("2");
                list.add(pq);
            }
        }
        if(textId!=null){
            for(int i=0;i<textId.length;i++){
                PaperQuestion pq=new PaperQuestion();
                pq.setPaperId(paperId);
                pq.setQuestionId(textId[i]);
                pq.setType("3");
                list.add(pq);
            }
        }

        if(list.size()>0){
            return paperMapper.addPaperQuestion(list)&&bool;

        }else{
            return bool;
        }

    }
}
