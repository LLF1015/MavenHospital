package com.qst.bean;

public class Patient {
    private String id;//id
    private String account;//账号
    private String email;//邮箱
    private String password;//密码
    private String name;//姓名
    private String integrity;//信用值

    public Patient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntegrity() {
        return integrity;
    }

    public void setIntegrity(String integrity) {
        this.integrity = integrity;
    }

    public Patient(String id, String account, String email, String password, String name, String integrity) {
        this.id = id;
        this.account = account;
        this.email = email;
        this.password = password;
        this.name = name;
        this.integrity = integrity;
    }
}
