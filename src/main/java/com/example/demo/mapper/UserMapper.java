package com.example.demo.mapper;

import com.example.demo.bean.User;
import com.example.demo.security.AccountCredentials;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUser(AccountCredentials account);
}
