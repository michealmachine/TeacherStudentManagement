package com.zhangziqi.dao;

import com.zhangziqi.controller.TeacherController;
import com.zhangziqi.entity.Course;
import com.zhangziqi.entity.CourseKey;
import com.zhangziqi.entity.CourseTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(CourseKey key);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(CourseKey key);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    @Select("select * from course")
    List<Course> selectAll();
    List<CourseTeacher> selectTeacherAndCourse();
}