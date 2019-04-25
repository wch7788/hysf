package com.example.demo.controller;

import com.example.demo.Service.PaperService;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;
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
@Api(tags = "试卷模块")
@RequestMapping("/v1/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @ApiOperation(value = "按条件获取试卷数据")
    @PostMapping("/list")
    public Map<String, ?> listPaper(@RequestBody PaperRequestDto paperRequestDto) {
        PageResponseDto<PaperResponseDto> paperResult=paperService.getPaperList(paperRequestDto);
        return JSONResult.fillResult(Utils.ResultStatus.OK,paperResult.getResultMap(),"成功");
    }

}
