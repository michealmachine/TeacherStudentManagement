package com.zhangziqi.service.impl;

import com.zhangziqi.dao.CourseMapper;
import com.zhangziqi.entity.Course;
import com.zhangziqi.entity.CourseKey;
import com.zhangziqi.entity.CourseTeacher;
import com.zhangziqi.service.CourseService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Course selectByCourseKey(CourseKey courseKey) {
        return courseMapper.selectByPrimaryKey(courseKey);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public boolean deleteByCourseKey(CourseKey courseKey) {
        return courseMapper.deleteByPrimaryKey(courseKey) > 0;
    }

    @Override
    public boolean modify(Course course) {
        return courseMapper.updateByPrimaryKey(course) > 0;
    }

    @Override
    public boolean add(Course course) {
        return courseMapper.insert(course) > 0;
    }

    @Override
    public List<CourseTeacher> selectTeacherAndCourse() {
        return courseMapper.selectTeacherAndCourse();
    }
}
