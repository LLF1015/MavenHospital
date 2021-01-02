package com.qst.dao;

import com.qst.bean.NumSource;
import com.qst.bean.WorkDay;
import com.qst.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NumSourceDao {
    //插入一条记录
    public boolean order(String pid, String wid,String did, NumSource numSource){//病人id,号源id
        String sql ="insert into record values(null,?,?,?,?,?,?,now(),'成功')";
        Object[] o=new Object[]{pid,wid,did,
                numSource.getSerialnumber(),
                numSource.getVisitdate(),
                numSource.getVisittime()};
        //返回更新结果
        return DBUtil.executeUpdate(sql, o);

    }
    /*
    获取预约记录
     */
    public List<NumSource> query(String where, Object[] o){

        WorkDayDao workDayDao=new WorkDayDao();
        List<WorkDay> workDays = workDayDao.query(where, o);
        WorkDay workDay = workDays.get(0);
        int nsnum = Integer.valueOf(workDay.getNsnum());

        List<NumSource> list=new ArrayList<>();

        String sql="select id,wid,serialnumber,date_format(ordertime,'%H:%i'),state from recode  "+where;
        ResultSet rs=DBUtil.executeQuery(sql,o);
        try {
            while (rs.next()){
                list.add(new NumSource(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return list;
    }
    public boolean update(String where, Object[] o){
        String sql="update  record "+where ;
        return DBUtil.executeUpdate(sql,o);
    }
}
