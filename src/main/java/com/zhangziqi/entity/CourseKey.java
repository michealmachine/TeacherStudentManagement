package com.zhangziqi.entity;

public class CourseKey {
    private Integer cid;

    private Integer tid;

    public CourseKey() {
    }

    public CourseKey(Integer cid, Integer tid) {
        this.cid = cid;
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}