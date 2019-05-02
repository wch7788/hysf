package com.example.demo.controller;

import com.example.demo.Service.PaperService;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.dto.paper.NewPaperRequest;
import com.example.demo.dto.paper.PaperRequestDto;
import com.example.demo.dto.paper.PaperResponseDto;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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

    @ApiOperation(value = "根据ID获取试卷详情")
    @GetMapping("/info/{id}")
    public Map<String, ?> listPaper(@PathVariable("id") int id) {
        Map<String,Object> paperInfo=paperService.getPaperInfo(id);
        return JSONResult.fillResult(Utils.ResultStatus.OK,paperInfo,"成功");
    }

    @ApiOperation(value = "新增试卷")
    @PostMapping("/addPaper")
    public Map<String, ?> addPaper(@RequestBody NewPaperRequest newPaperRequest) {
        boolean bool=paperService.addPaper(newPaperRequest);
        return JSONResult.fillResult(Utils.ResultStatus.OK,bool,"成功");
    }

   /* @ApiOperation(value="导出成绩结果",produces="application/octet-stream")
    @GetMapping(value="/export")
    public void exportSingleVMERateResult(HttpServletResponse response) {
        Workbook wb=new XSSFWorkbook();
        try {
            response.setContentType("application/octet-stream;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + "Result.xlsx");
            wb.write(response.getOutputStream());
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

}
