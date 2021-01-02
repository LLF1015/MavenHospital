package com.qst.servlet;

import com.qst.util.DBUtil;
import com.qst.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/count")
public class Count extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = Util.nullToString(request.getParameter("action"));
        JSONArray array=new JSONArray();
        ResultSet rs;
        String sql;
        response.setContentType("application/json; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        try {
            switch (action){
                case "1":
                    rs = DBUtil.executeQuery("select count(*) from office", null);
                    rs.next();
                    array.add(rs.getInt(1));
//                    rs= DBUtil.executeQuery("select count(*) from room", null);
//                    rs.next();
//                    array.add(rs.getInt(1));
                    rs=DBUtil.executeQuery("select count(*) from doctor", null);
                    rs.next();
                    array.add(rs.getInt(1));

                    rs=DBUtil.executeQuery("select count(*) from patient", null);
                    rs.next();
                    array.add(rs.getInt(1));

                    break;
                case "2":
                    sql="select doctor.office,count(doctor.did) as did from record,doctor where record.did=doctor.did group by doctor.office ";
                    rs=DBUtil.executeQuery(sql,null);
                    JSONArray data = new JSONArray();
                    JSONArray data1 = new JSONArray();
                    while (rs.next()){
                        data.add(rs.getString(1));
                        data1.add(rs.getString(2));
                    }
                    JSONObject object=new JSONObject();
                    object.put("data",data);
                    object.put("data1",data1);
                   response.getWriter().write(object.toString());
                    return;
                case "3":
                    sql="select workday.worktime,count(record.did) from record,workday where workday.wid=record.wid group by workday.worktime order by workday.worktime";
                    rs=DBUtil.executeQuery(sql,null);
                    while (rs.next()){
                        array.add(rs.getInt(2));
                    }
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().write(array.toString());
    }
}
