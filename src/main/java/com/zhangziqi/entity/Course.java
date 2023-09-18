package com.zhangziqi.entity;

public class Course extends CourseKey {
    private String name;

    private String tname;

    public Course() {

    }

    public String getName() {
        return name;
    }

    public Course(String name, String tname) {
        this.name = name;
        this.tname = tname;
    }

    public Course(Integer cid, Integer tid, String name, String tname) {
        super(cid, tid);
        this.name = name;
        this.tname = tname;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", tname='" + tname + '\'' +
                 "cid"+ super.getCid()+"tid"+ super.getTid()+
                '}';
    }
}