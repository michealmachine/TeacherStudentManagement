package com.zhangziqi.service;

import com.zhangziqi.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> selectAll();

    boolean add(Teacher teacher);

    boolean modify(Teacher teacher);

    boolean delete(int id);
    Teacher selectById(int id);
}
