package com.zhangziqi.dao;

import com.zhangziqi.entity.StudentCourse;
import com.zhangziqi.entity.StudentCourseKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentCourseMapper {
    int deleteByPrimaryKey(StudentCourseKey key);

    int insert(StudentCourseKey record);

    int insertSelective(StudentCourseKey record);

    @Select("select sid from studentcourse")
    List<StudentCourseKey> selectAll();

    StudentCourseKey selectByStudentCourseKey(StudentCourseKey studentCourseKey);

    @Select("select * from studentcourse where sid = #{sid}")
    List<StudentCourseKey> selectBySid(int sid);

    @Select("select * from studentcourse where tid =#{tid}")
    List<StudentCourseKey> selectByTid(int tid);

    int updateByKey(StudentCourseKey studentCourseKey);
    List<StudentCourse> selectStudentAndTeacher();

}