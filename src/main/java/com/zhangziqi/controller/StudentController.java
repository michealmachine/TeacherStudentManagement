package com.zhangziqi.controller;

import com.zhangziqi.dao.StudentMapper;
import com.zhangziqi.entity.Student;
import com.zhangziqi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/MainStudent")
    public String studentMain(Model model){
        model.addAttribute("students",studentService.selectAll());
        return "StudentMain";
    }
    @RequestMapping("/studentDelete/{id}")
    public String modify(@PathVariable int id){
        studentService.deleteById(id);
        return "redirect:/MainStudent";
    }
    @RequestMapping("/StudentAdd")
    public String add(Model model){
        model.addAttribute("Student",new Student());
        return "StudentAdd";
    }
    @RequestMapping("/StudentAddCheck")
    public String adds(Student student,Model model){
        try {
            studentService.insert(student);
        }catch (Exception sqlException){
            model.addAttribute("msg","该数据已经存在,检查后重新填写");
            return "forward:/StudentAdd";
        }
        return "redirect:/MainStudent";
    }
    @RequestMapping("/studentModify/{id}")
    public String modify(@PathVariable int id,Model model){
        Student student = studentService.selectById(id);
        model.addAttribute("Student",student);
        return "StudentModify";
    }
    @RequestMapping("/studentModifyCheck")
    public String mofidys(Student student){
        studentService.update(student);
        return "redirect:/MainStudent";
    }

}
