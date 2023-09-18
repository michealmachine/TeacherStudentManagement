package com.zhangziqi.controller;

import com.zhangziqi.dao.TeacherMapper;
import com.zhangziqi.entity.Teacher;
import com.zhangziqi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @RequestMapping("/MainTeacher")
    public String TeacherMain(Model model){
        model.addAttribute("teachers",teacherService.selectAll());
        return "TeacherMain";
    }
    @RequestMapping("/teacherDelete/{id}")
    public String modify(@PathVariable int id){
        teacherService.delete(id);
        return "redirect:/MainTeacher";
    }
    @RequestMapping("/TeacherAdd")
    public String add(Model model){
        model.addAttribute("Teacher",new Teacher());
        return "TeacherAdd";
    }
    @RequestMapping("/TeacherAddCheck")
    public String adds(Teacher teacher,Model model){
        try {
            teacherService.add(teacher);
        }catch (Exception exception){
            model.addAttribute("msg","该数据已经存在,检查后重新填写");
            return "forward:/TeacherAdd";
        }
        return "redirect:/MainTeacher";
    }
    @RequestMapping("/teacherModify/{id}")
    public String modify(@PathVariable int id,Model model){
        Teacher teacher = teacherService.selectById(id);
        model.addAttribute("Teacher",teacher);
        return "TeacherModify";
    }
    @RequestMapping("/TeacherModifyCheck")
    public String modifys(Teacher teacher){
        teacherService.modify(teacher);
        return "redirect:/MainTeacher";
    }
}
