package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "登录页面")
public class IndexController {

    @ApiOperation(value = "登录页面")
    @GetMapping(value="/")
    public String login(){
        return "login";
    }

    @ApiOperation(value = "错误页面")
    @GetMapping(value="/error/404")
    public String errorPage(){
        return "404";
    }

    @ApiOperation(value = "错误页面")
    @GetMapping(value="/forWord/{function}")
    public String indexPage(@PathVariable("function") String function){
        return function;
    }

    @ApiOperation(value = "错误页面")
    @GetMapping(value="/index")
    public String index(){
        return "index";
    }

    @ApiOperation(value = "错误页面")
    @GetMapping(value="/test")
    @ResponseBody
    public String Test(){
        return "Success";
    }
}
