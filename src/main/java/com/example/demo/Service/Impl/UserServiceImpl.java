package com.example.demo.Service.Impl;

import com.example.demo.Service.UserService;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.security.AccountCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(AccountCredentials account) {

        return userMapper.getUser(account);
    }
}
