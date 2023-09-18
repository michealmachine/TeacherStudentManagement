package com.zhangziqi.service.impl;

import com.zhangziqi.dao.TeacherMapper;
import com.zhangziqi.entity.Teacher;
import com.zhangziqi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public boolean add(Teacher teacher) {
        return teacherMapper.insert(teacher) > 0;
    }

    @Override
    public boolean modify(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher) > 0;
    }

    @Override
    public boolean delete(int id) {
        return teacherMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Teacher selectById(int id) {
        return teacherMapper.selectByPrimaryKey(id);
    }
}
