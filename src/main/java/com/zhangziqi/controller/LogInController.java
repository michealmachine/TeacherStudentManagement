package com.zhangziqi.controller;

import com.zhangziqi.entity.Login;
import com.zhangziqi.service.CourseService;
import com.zhangziqi.service.LoginService;
import com.zhangziqi.service.StudentService;
import com.zhangziqi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes(value = {"currentName"})
public class LogInController {
    @Autowired
    LoginService loginService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/Login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("msgs",request.getAttribute("msgs"));
        model.addAttribute("Login", new Login());
        return "Login";
    }

    @PostMapping("/CheckLogin")
    public String loginCheck(Login login, Model model) {
        Login login1 = loginService.selectByUsername(login.getUsername());
        if (login1 == null || !login1.getPassword().equals(login.getPassword())) {
            model.addAttribute("msg",true);
            model.addAttribute("Login",new Login());
            return "Login";
        }
        model.addAttribute("currentName", login.getUsername());
        return "redirect:Index";
    }
    @RequestMapping("/Logout")
    public String logout(SessionStatus status){
        status.setComplete();
        return "redirect:/Login";
    }
    @RequestMapping("/Index")
    public String index(Model model){
        model.addAttribute("studentNum",studentService.selectAll().size());
        model.addAttribute("TeacherNum",teacherService.selectAll().size());
        model.addAttribute("CourseNum",courseService.selectAll().size());
        return "Index";
    }
}
