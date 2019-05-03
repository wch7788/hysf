package com.example.demo.controller;

import com.example.demo.Service.ChoiceService;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.choice.ChoiceRequestDto;
import com.example.demo.dto.choice.ChoiceResponseDto;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
