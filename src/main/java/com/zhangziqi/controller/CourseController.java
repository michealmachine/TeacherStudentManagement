package com.zhangziqi.controller;

import com.zhangziqi.dao.CourseMapper;
import com.zhangziqi.entity.Course;
import com.zhangziqi.entity.CourseKey;
import com.zhangziqi.entity.CourseTeacher;
import com.zhangziqi.entity.Teacher;
import com.zhangziqi.service.CourseService;
import com.zhangziqi.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/MainCourse")
    public String courseMain(Model model) {
        List<CourseTeacher> courses = courseService.selectTeacherAndCourse();
        model.addAttribute("courses", courses);
        return "CourseMain";
    }

    @RequestMapping("/courseDelete/{cid}/{tid}")
    public String delete(@PathVariable int cid, @PathVariable int tid) {
        courseService.deleteByCourseKey(new CourseKey(cid, tid));
        return "redirect:/MainCourse";
    }

    @RequestMapping("/CourseAdd")
    public String add(Model model) {
        model.addAttribute("courses", new Course());
        List<Teacher> teachers = teacherService.selectAll();
        model.addAttribute("teachers", teachers);
        return "CourseAdd";
    }

    @RequestMapping("/CourseAddCheck")
    public String adds(Course course,Model model) {
        try {
            courseService.add(course);
        }catch (Exception exception){
            model.addAttribute("msg","该数据已经存在,检查后重新填写");
            return "forward:/CourseAdd";
        }
        return "redirect:/MainCourse";
    }

    @RequestMapping("/courseModify/{cid}/{tid}")
    public String modify(@PathVariable int cid, @PathVariable int tid, Model model) {
        Course course = courseService.selectByCourseKey(new CourseKey(cid, tid));
        model.addAttribute("courses", course);
        List<Teacher> teachers = teacherService.selectAll();
        model.addAttribute("teachers", teachers);
        return "CourseModify";
    }

    @RequestMapping("/courseModifyCheck")
    public String mofigys(Course course) {
        courseService.modify(course);
        return "redirect:/MainCourse";
    }
}
