package com.zhangziqi.service.impl;

import com.zhangziqi.dao.StudentCourseMapper;
import com.zhangziqi.entity.StudentCourse;
import com.zhangziqi.entity.StudentCourseKey;
import com.zhangziqi.service.StudentCourseService;
import com.zhangziqi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Override
    public boolean deleteByKey(StudentCourseKey studentCourseKey) {
        return studentCourseMapper.deleteByPrimaryKey(studentCourseKey) > 0;
    }

    @Override
    public boolean insertByKey(StudentCourseKey studentCourseKey) {
        return studentCourseMapper.insert(studentCourseKey) > 0;
    }

    @Override
    public boolean updateByKey(StudentCourseKey studentCourseKey) {
        return studentCourseMapper.updateByKey(studentCourseKey) > 0;
    }

    @Override
    public StudentCourseKey selectByKey(StudentCourseKey studentCourseKey) {
        return studentCourseMapper.selectByStudentCourseKey(studentCourseKey);
    }

    @Override
    public List<StudentCourseKey> selectBySid(int sid) {
        return studentCourseMapper.selectBySid(sid);
    }

    @Override
    public List<StudentCourseKey> selectByTid(int tid) {
        return studentCourseMapper.selectByTid(tid);
    }

    @Override
    public List<StudentCourseKey> selectAll() {
        return studentCourseMapper.selectAll();
    }

    @Override
    public List<StudentCourse> selectStudentAndTeacher() {
        return studentCourseMapper.selectStudentAndTeacher();
    }
}
