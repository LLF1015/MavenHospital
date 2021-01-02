package com.qst.bean;

public class WorkDay {

    private String wid;//id
    private String did;//医生id
    private String worktime;//工作时间
    private String ampm;//上下午
    private int nsnum;//数量
    private String state;//状态

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public int getNsnum() {
        return nsnum;
    }

    public void setNsnum(int nsnum) {
        this.nsnum = nsnum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public WorkDay(String wid, String did, String worktime, String ampm, int nsnum, String state) {
        this.wid = wid;
        this.did = did;
        this.worktime = worktime;
        this.ampm = ampm;
        this.nsnum = nsnum;
        this.state = state;
    }

    public WorkDay() {
    }
}
