package com.zhangziqi.service;

import com.zhangziqi.entity.Login;

public interface LoginService {
    Login selectByUsername(String username);

}
