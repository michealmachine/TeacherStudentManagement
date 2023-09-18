package com.zhangziqi.service.impl;

import com.zhangziqi.dao.LoginMapper;
import com.zhangziqi.entity.Login;
import com.zhangziqi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public Login selectByUsername(String username) {
        return loginMapper.selectByUsername(username);
    }
}
