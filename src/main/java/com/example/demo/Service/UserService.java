package com.example.demo.Service;

import com.example.demo.bean.User;
import com.example.demo.security.AccountCredentials;

public interface UserService {

    User getUser(AccountCredentials account);
}
