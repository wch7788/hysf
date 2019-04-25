package com.example.demo.controller;

import com.example.demo.Service.JudgeService;
import com.example.demo.bean.Judge;
import com.example.demo.bean.Student;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.judge.JudgeRequestDto;
import com.example.demo.dto.judge.JudgeResponseDto;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "判断题模块")
@RequestMapping("/v1/judge")
public class JudgeController {

    @Autowired
    JudgeService judgeService;


    @ApiOperation(value = "按条件获取判断题数据")
    @PostMapping("/list")
    public Map<String, ?> listJudge(@RequestBody JudgeRequestDto judgeRequestDto) {
        PageResponseDto<JudgeResponseDto> judgeResult=judgeService.getJudgeList(judgeRequestDto);
        return JSONResult.fillResult(Utils.ResultStatus.OK,judgeResult.getResultMap(),"成功");
    }

    @ApiOperation(value = "获取指定ID判断题数据")
    @GetMapping("/getJudge/{id}")
    public Map<String, ?> getJudge(@PathVariable("id") int id) {
        JudgeResponseDto judge=judgeService.getJudge(id);
        return JSONResult.fillResult(Utils.ResultStatus.OK,judge,"成功");
    }

    @ApiOperation(value = "更新判断题数据")
    @PostMapping("/updateJudge")
    public Map<String, ?> updateJudge(@RequestBody Judge judge) {
        Boolean result =judgeService.updateJudge(judge);
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

    @ApiOperation(value = "新增判断题数据")
    @PostMapping("/addJudge")
    public Map<String, ?> addJudge(@RequestBody List<Judge> judgeList) {
        Boolean result=judgeService.addJudgeList(judgeList);
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

    @ApiOperation(value = "获取题型难度")
    @GetMapping("/getQuestionType/{type}")
    public Map<String, ?> getQuestionType(@PathVariable("type") String type) {
        List<Map<String,Object>> result=judgeService.getQuestionList(type);
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }


}
