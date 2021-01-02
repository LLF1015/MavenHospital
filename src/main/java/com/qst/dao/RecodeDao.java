package com.qst.dao;

import com.qst.bean.NumSource;
import com.qst.bean.Recode;
import com.qst.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecodeDao {
    public boolean order(Recode recode ){//病人id,号源id
        String sql ="insert into record(rid,pid,wid,did,serialnumber,visitdate,visittime,ordertime,state)"+" values(?,?,?,?,?,?,?,?,?)";
        Object[] o=new Object[]{
                recode.getRid(),
                recode.getPid(),
                recode.getWid(),
                recode.getDid(),
                recode.getSerialnumber(),
                recode.getVisitdate(),
                recode.getVisittime(),
                recode.getOrdertime(),
                recode.getState()
        };
        return DBUtil.executeUpdate(sql, o);

    }
    public HashMap<String, String> confirm(String id){
        HashMap<String, String> hashMap = new HashMap<>();
        String sql="call myproc(?)";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{id});
        try { //id | serialnumber | nstime | state  | ampm | worktime       | fee  | name   | phonenum | office | room
            if(rs.next()){
                hashMap.put("id",rs.getString("id"));
                hashMap.put("did",rs.getString("did"));
                hashMap.put("serialnumber",rs.getString("serialnumber"));
                hashMap.put("nstime",rs.getString("nstime"));
                hashMap.put("state",rs.getString("state"));
                hashMap.put("ampm",rs.getString("ampm"));
                hashMap.put("worktime",rs.getString("worktime"));
                hashMap.put("fee",rs.getString("fee"));
                hashMap.put("name",rs.getString("name"));
                hashMap.put("office",rs.getString("office"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return hashMap;
    }
    public List<HashMap<String, String>> orderList(String patientid){
        List<HashMap<String, String>> list=new ArrayList<>();
        String sql="call orderList(?)";
        return   DBUtil.getHashmap(sql, new Object[]{patientid});
    }
    public List<HashMap<String,String>> orderList1(String patiendid) throws SQLException {
        List<HashMap<String, String>> list=new ArrayList<>();
        String sql="select record.rid,record.ordertime,record.visitdate," +
                "record.visittime,record.serialnumber,record.state,doctor.dname," +
                "doctor.office,doctor.fee,doctor.picpath " +
                "from record,doctor where record.did=doctor.did&&record.pid=?";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{patiendid});
        while(rs.next())
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("rid",rs.getString(1));
            hashMap.put("ordertime",rs.getString(2));
            hashMap.put("visitdate",rs.getString(3));
            hashMap.put("visittime",rs.getString(4));
            hashMap.put("serialnumber",rs.getString(5));
            hashMap.put("state",rs.getString(6));
            hashMap.put("dname",rs.getString(7));
            hashMap.put("office",rs.getString(8));
            hashMap.put("fee",rs.getString(9));
            hashMap.put("picpath",rs.getString(10));

            list.add(hashMap);
        }
        return list;
    }
    public boolean update(String set, Object[] o){
        String sql="update record "+set;
        return DBUtil.executeUpdate(sql,o);
    }
    public List<Recode> query (String where, Object[] o) {
        String sql ="select * from record "+where;
        ResultSet rs = DBUtil.executeQuery(sql, o);
        List<Recode> list=new ArrayList<>();
        try {
            while (rs.next()){
                list.add(new Recode(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getTimestamp(8),
                        rs.getString(9)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return list;
    }
}
