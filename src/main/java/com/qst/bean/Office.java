package com.qst.bean;

public class Office {

    //办公室名字
    private String officename;
    //办公室描述
    private String description;
    //医生数量
    private int doctornum;

    public Office() {
    }

    public Office(String officename, String description, int doctornum) {
        this.officename = officename;
        this.description = description;
        this.doctornum = doctornum;
    }

    public String getOfficename() {
        return officename;
    }

    public void setOfficename(String officename) {
        this.officename = officename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDoctornum() {
        return doctornum;
    }

    public void setDoctornum(int doctornum) {
        this.doctornum = doctornum;
    }
}
