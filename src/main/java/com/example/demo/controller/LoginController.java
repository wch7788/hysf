package com.example.demo.controller;


import com.example.demo.Service.UserService;
import com.example.demo.bean.User;
import com.example.demo.security.AccountCredentials;
import com.example.demo.util.JSONResult;
import com.example.demo.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@Api(tags = "登录")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @ApiOperation(value = "用户登录")
    @PostMapping("/v1/auth/login")
    public Map<String, ?> checkLogin(@RequestBody AccountCredentials account, HttpSession session) {
        User user=userService.getUser(account);
        if (user == null) {
            return JSONResult.fillResult(Utils.ResultStatus.Fail, "", "用户不存在");
        }
        if ((!account.getUsername().equals(user.getUsername()))||!passwordEncoder.matches(account.getPassword(), user.getPassword())) {
            return JSONResult.fillResult(Utils.ResultStatus.Fail, "", "用户或密码错误");
        }else{
            session.setAttribute("user",user);
            return JSONResult.fillResult(Utils.ResultStatus.OK,user,"成功");
        }
    }



}
