package com.zhangziqi.service;

import com.zhangziqi.entity.StudentCourse;
import com.zhangziqi.entity.StudentCourseKey;

import java.util.List;

public interface StudentCourseService {
    boolean deleteByKey(StudentCourseKey studentCourseKey);
    boolean insertByKey(StudentCourseKey studentCourseKey);
    boolean updateByKey(StudentCourseKey studentCourseKey);
    StudentCourseKey selectByKey(StudentCourseKey studentCourseKey);
    List<StudentCourseKey> selectBySid(int sid);
    List<StudentCourseKey> selectByTid(int tid);
    List<StudentCourseKey> selectAll();
    List<StudentCourse> selectStudentAndTeacher();
}
