package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(tags = "登录页面")
public class IndexController {

    @ApiOperation(value = "登录页面")
    @GetMapping(value="/")
    public String login(){
        return "login";
    }
}
