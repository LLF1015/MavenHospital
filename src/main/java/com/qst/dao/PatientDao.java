package com.qst.dao;

import com.qst.bean.Patient;
import com.qst.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientDao {
    /**
     * 修改病人记录
     * @param set
     * @param o
     * @return
     */
    public boolean update(String set, Object[] o){

        String sql="update patient "+set;
        return DBUtil.executeUpdate(sql,o);

    }

    /**
     * 插入一条病人记录
     * @param patient
     * @return
     */
    public boolean insert(Patient patient){
        String sql="insert into patient values(null,?,?,?,?,?)";
        return DBUtil.executeUpdate(sql,new Object[]{patient.getAccount(),
                patient.getEmail(),
                patient.getPassword(),
                patient.getName(),
                patient.getIntegrity()});
    }

    /**
     * 得到记录
     * @param clounm
     * @param where
     * @return
     */
    public List<Patient> query(String clounm, String where){
        List<Patient> lists=new ArrayList<>();
        String sql="select * from patient where "+clounm+"=?";
        ResultSet rs=DBUtil.executeQuery(sql,new Object[]{where});
        try {
            while (rs.next()){
                lists.add(new Patient(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return lists;
    }
    public Integer Count(String clounm,String where)
    {
        String sql="select count(*) from patient where "+clounm+" like ? ";
        return DBUtil.getCount(sql,new Object[]{"%"+where+"%"});
    }
    public Integer Count1(String where)
    {
        String sql="select count(*) from patient where account=? ";
        return DBUtil.getCount(sql,new Object[]{where});
    }
    public ArrayList<HashMap<String, String>> patientList(String did){
         /*serialnumber int comment '就诊序号',
                visitdate  date comment '就诊日期',
                visitnoon  char(4) comment '就诊上午或下午',
                visittime  time comment '就诊时间',*/
        String sql="select patient.pid, patient.name as pname,record.ordertime,record.state, record.rid,record.visitdate,record.visittime "+
        "from record,patient where "+
        "record.did=? and record.pid=patient.pid "+
        "order by ordertime desc";
        ArrayList<HashMap<String, String>> list = DBUtil.getHashmap(sql, new Object[]{did});
        return list;
    }
}
