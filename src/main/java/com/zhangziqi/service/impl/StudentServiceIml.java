package com.zhangziqi.service.impl;

import com.zhangziqi.dao.StudentMapper;
import com.zhangziqi.entity.Student;
import com.zhangziqi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIml implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public boolean deleteById(int id) {
        return studentMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0;
    }

    @Override
    public Student selectById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Student student) {
        return studentMapper.updateByPrimaryKey(student) > 0;
    }
}
