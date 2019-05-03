package com.example.demo.controller;


import com.example.demo.Service.TextService;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.text.TextRequestDto;
import com.example.demo.dto.text.TextResponseDto;
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
}
