package com.qst.dao.impl;

import com.qst.bean.Admin;
import com.qst.dao.AdminDao;
import com.qst.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IAdminimpl implements AdminDao {
    @Override
    public boolean insertAdmin(Admin admin) {
        //插入数据到数据库
        String sql="insert into admin valuse(?,?,?,?)";
        Object[] object=new Object[]{admin.getAccount(),admin.getPassword(),admin.getName()};
        return DBUtil.executeUpdate(sql,object);
    }

    public boolean updateAdmin(String where,Object[] o)
    {
        //更新数据
        String sql="update admin "+where;
        return DBUtil.executeUpdate(sql,o);
    }
    @Override
    public List<Admin> getAdmin(String account) {
        //从数据库中得到值
        List<Admin> admins=new ArrayList<>();
        String sql="select * from admin where account=?";
        Object[] object=new Object[]{account};
        ResultSet rs=DBUtil.executeQuery(sql,object);
        try {
            while (rs.next()){
                admins.add(new Admin(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return admins;
    }

}
