package com.zhangziqi.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object currentUser = request.getSession().getAttribute("currentName");
        if(currentUser==null){
            request.setAttribute("msgs",true);
            request.getRequestDispatcher("/Login").forward(request,response);
            return false;
        } else return true;
    }
}
