package com.example.demo.controller;


import com.example.demo.Service.TextService;
import com.example.demo.bean.Judge;
import com.example.demo.bean.Text;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.judge.JudgeResponseDto;
import com.example.demo.dto.text.TextRequestDto;
import com.example.demo.dto.text.TextResponseDto;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "主观题模块")
@RequestMapping("/v1/text")
public class TextController {

    @Autowired
    TextService textService;

    @ApiOperation(value = "按条件获取主观题数据")
    @PostMapping("/list")
    public Map<String, ?> listText(@RequestBody TextRequestDto textRequestDto) {
        PageResponseDto<TextResponseDto> textResult=textService.getTextList(textRequestDto);
        return JSONResult.fillResult(Utils.ResultStatus.OK,textResult.getResultMap(),"成功");
    }

    @ApiOperation(value = "获取指定ID主观题数据")
    @GetMapping("/getText/{id}")
    public Map<String, ?> getText(@PathVariable("id") int id) {
        TextResponseDto text=textService.getText(id);
        return JSONResult.fillResult(Utils.ResultStatus.OK,text,"成功");
    }

    @ApiOperation(value = "更新主观题数据")
    @PostMapping("/updateText")
    public Map<String, ?> updateText(@RequestBody Text text) {
        Boolean result =textService.updateText(text);
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

    @ApiOperation(value = "新增主观题数据")
    @PostMapping("/addText")
    public Map<String, ?> addText(@RequestBody List<Text> textList) {
        Boolean result=textService.addTextList(textList);
        return JSONResult.fillResult(Utils.ResultStatus.OK,result,"成功");
    }

    @ApiOperation(value = "根据Id删除试题")
    @GetMapping("/deleteText/{id}")
    public Map<String, ?> deleteJudge(@PathVariable("id") int id) {
        Boolean bool=textService.deleteById(id);
        return JSONResult.fillResult(Utils.ResultStatus.OK,bool,"成功");
    }
}
