package com.qst.dao;

import com.qst.bean.Admin;

import java.util.List;

public interface AdminDao {
    //插入记录
    public boolean insertAdmin(Admin admin);

    //得到记录
    public List<Admin> getAdmin(String account);

}
