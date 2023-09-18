package com.zhangziqi.service;

import com.zhangziqi.entity.Course;
import com.zhangziqi.entity.CourseKey;
import com.zhangziqi.entity.CourseTeacher;

import java.util.List;

public interface CourseService {
    Course selectByCourseKey(CourseKey courseKey);
    List<Course> selectAll();
    boolean deleteByCourseKey(CourseKey courseKey);
    boolean modify(Course course);
    boolean add(Course course);
    List<CourseTeacher> selectTeacherAndCourse();

}
