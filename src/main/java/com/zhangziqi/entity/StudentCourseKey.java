package com.zhangziqi.entity;

public class StudentCourseKey {
    private Integer sid;

    private Integer cid;

    private Integer tid;

    public StudentCourseKey() {
    }
    public StudentCourseKey(Integer sid, Integer tid) {
        this.sid = sid;
        this.cid = null;
        this.tid = tid;
    }

    public StudentCourseKey(Integer sid, Integer cid, Integer tid) {
        this.sid = sid;
        this.cid = cid;
        this.tid = tid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    @Override
    public String toString() {
        return "StudentCourseKey{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", tid=" + tid +
                '}';
    }
}