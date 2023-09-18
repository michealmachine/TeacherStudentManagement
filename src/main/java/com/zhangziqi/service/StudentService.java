package com.zhangziqi.service;

import com.zhangziqi.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();
    boolean deleteById(int id);
    boolean insert(Student student);
    Student selectById(int id);
    boolean update(Student student);

}
