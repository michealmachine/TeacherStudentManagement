package com.zhangziqi.entity;

public class StudentCourse extends StudentCourseKey{
    private String studentName;
    private String courseName;

    public StudentCourse() {
    }

    public StudentCourse(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public StudentCourse(Integer sid, Integer cid, Integer tid, String studentName, String courseName) {
        super(sid, cid, tid);
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return super.toString()+"StudentCourse{" +
                "studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
