package com.qst.bean;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Recode {
    private String rid;//预约id
    private String pid;//病人id
    private String wid;//workdayid
    private String did;//医生id
    private String serialnumber;//序列号


    //   private String serialnumber;
    private Date visitdate;
 //   private String visitnoon;
    private String visittime;
    private Timestamp ordertime;
    private String state;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

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



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }


    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public Recode(String rid, String pid, String wid, String did, String serialnumber, Date visitdate, String visittime, Timestamp ordertime, String state) {
        this.rid = rid;
        this.pid = pid;
        this.wid = wid;
        this.did = did;
        this.serialnumber = serialnumber;
        this.visitdate = visitdate;
        this.visittime = visittime;
        this.ordertime = ordertime;
        this.state = state;
    }

    public Recode() {
    }
}
