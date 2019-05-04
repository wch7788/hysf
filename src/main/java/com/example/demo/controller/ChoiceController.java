package com.example.demo.controller;

import com.example.demo.Service.ChoiceService;
import com.example.demo.bean.Choice;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "选择题模块")
@RequestMapping("/v1/choice")
public class ChoiceController {

    @Autowired
    ChoiceService choiceService;

    @ApiOperation(value = "按条件获取选择题数据")
    @PostMapping("/list")
    public Map<String, ?> listChoice(@RequestBody ChoiceRequestDto choiceRequestDto) {
        PageResponseDto<ChoiceResponseDto> choiceResult=choiceService.getChoiceList(choiceRequestDto);
        return JSONResult.fillResult(Utils.ResultStatus.OK,choiceResult.getResultMap(),"成功");
    }

    @ApiOperation(value = "获取指定ID选择题数据")
    @GetMapping("/getChoice/{id}")
    public Map<String, ?> getChoice(@PathVariable("id") int id) {
        ChoiceResponseDto choice=choiceService.getChoice(id);
        return JSONResult.fillResult(Utils.ResultStatus.OK,choice,"成功");
    }

    @ApiOperation(value = "删除指定ID选择题数据")
    @GetMapping("/deleteChoice/{id}")
    public Map<String, ?> deleteChoice(@PathVariable("id") int id) {
        Boolean bool=choiceService.deleteChoice(id);
        return JSONResult.fillResult(Utils.ResultStatus.OK,bool,"成功");
    }

    @ApiOperation(value = "修改选择题信息")
    @PostMapping("/updateChoice")
    public Map<String, ?> updateChoice(@RequestBody Choice choice) {
        Boolean bool=choiceService.updateChoice(choice);
        return JSONResult.fillResult(Utils.ResultStatus.OK,bool,"成功");
    }

    @ApiOperation(value = "新增选择题信息")
    @PostMapping("/addChoice")
    public Map<String, ?> addChoice(@RequestBody List<Choice> choiceList) {
        Boolean bool=choiceService.addChoice(choiceList);
        return JSONResult.fillResult(Utils.ResultStatus.OK,bool,"成功");
    }
}
