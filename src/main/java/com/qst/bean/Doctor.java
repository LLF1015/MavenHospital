package com.qst.bean;

public class Doctor {
    //医生id
    private String did;
    //账号
    private String account;
    //密码
    private String password;
    //医生名字
    private String dname;
    //出诊费用
    private String fee;
    //性别
    private String gender;
    //年龄
    private String age;
    //科室
    private String office;
    //职称
    private String career;
    //描述
    private String description;
    //文件路径
    private String picpath;

    public Doctor() {
    }

    public Doctor(String did, String account, String password, String dname, String fee, String gender, String age, String office,String career, String description, String picpath) {
        this.did = did;
        this.account = account;
        this.password = password;
        this.dname = dname;
        this.fee = fee;
        this.gender = gender;
        this.age = age;
        this.office = office;
        this.career = career;
        this.description = description;
        this.picpath = picpath;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }
}
