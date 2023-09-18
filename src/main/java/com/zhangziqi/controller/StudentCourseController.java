package com.zhangziqi.controller;

import com.zhangziqi.entity.*;
import com.zhangziqi.service.CourseService;
import com.zhangziqi.service.StudentCourseService;
import com.zhangziqi.service.StudentService;
import com.zhangziqi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class StudentCourseController {
    @Autowired
    StudentCourseService studentCourseService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/MainStudentCourse")
    public String studentCourseMain(Model model) {
        List<StudentCourse> courses = studentCourseService.selectStudentAndTeacher();
        model.addAttribute("courses", courses);
        return "StudentCourseMain";
    }

    @RequestMapping("/studentCourseDelete/{sid}/{cid}/{tid}")
    public String delete(@PathVariable int sid, @PathVariable int cid, @PathVariable int tid) {
        studentCourseService.deleteByKey(new StudentCourseKey(sid, cid, tid));
        return "redirect:/MainStudentCourse";
    }

    @RequestMapping("/StudentCourseAdd")
    public String add(Model model) {
        List<CourseTeacher> courses = courseService.selectTeacherAndCourse();
        List<Student> students = studentService.selectAll();
        model.addAttribute("courses", courses);
        model.addAttribute("students", students);
        model.addAttribute("studentCourse", new StudentCourseKey());
        return "StudentCourseAdd";
    }

    @RequestMapping("/StudentCourseAddCheck")
    public String addCheck(@RequestParam("sid") String sid, @RequestParam("coursesId") String courseId,Model model) {
        String[] split = courseId.split(",");
        try {
            studentCourseService.insertByKey(new StudentCourseKey(Integer.parseInt(sid), Integer.parseInt(split[1]), Integer.parseInt(split[0])));
        }catch (Exception exception){
            model.addAttribute("msg","该数据已经存在,检查后重新填写");
            return "forward:/StudentCourseAdd";
        }
        return "redirect:/MainStudentCourse";
    }

    @RequestMapping("/Select")
    public String select(Model model) {
        List<Teacher> teachers = teacherService.selectAll();
        List<Student> students = studentService.selectAll();
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        return "Select";
    }

    @RequestMapping("/TeacherSelect")
    public String select(@RequestParam("sid") int sid, Model model) {
        List<StudentCourseKey> studentCourseKeys = studentCourseService.selectBySid(sid);
        HashSet<Integer> integers = new HashSet<>();
        for (StudentCourseKey studentCourseKey : studentCourseKeys) {
            integers.add(studentCourseKey.getTid());
        }
        LinkedList<Teacher> teachers = new LinkedList<>();
        for (Integer integer : integers) {
            teachers.add(teacherService.selectById(integer));
        }
        model.addAttribute("teachers", teachers);
        return "TeacherMain";
    }

    @RequestMapping("/StudentSelect")
    public String select2(@RequestParam("tid") int tid, Model model) {
        List<StudentCourseKey> studentCourseKeys = studentCourseService.selectByTid(tid);
        HashSet<Integer> integers = new HashSet<>();
        for (StudentCourseKey studentCourseKey : studentCourseKeys) {
            integers.add(studentCourseKey.getSid());
        }
        LinkedList<Student> students = new LinkedList<>();
        for (Integer integer : integers) {
            students.add(studentService.selectById(integer));
        }
        model.addAttribute("students",students);
        return "StudentMain";
    }

}
