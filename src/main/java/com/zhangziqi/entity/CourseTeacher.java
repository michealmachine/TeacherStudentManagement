package com.zhangziqi.entity;

public class CourseTeacher extends Course {
    private String teacherName;

    public CourseTeacher() {
        super();
    }

    public CourseTeacher(String name, String tname, String teacherName) {
        super(name, tname);
        this.teacherName = teacherName;
    }

    public CourseTeacher(Integer cid, Integer tid, String name, String tname, String teacherName) {
        super(cid, tid, name, tname);
        this.teacherName = teacherName;
    }

    public CourseTeacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return super.toString()+"CourseTeacher{" +
                "teacherName='" + teacherName + '\'' +
                '}';
    }
}
