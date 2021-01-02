package com.qst.servlet;

import com.qst.dao.PatientDao;
import com.qst.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegUserinfoAction")
public class RegUserinfoAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PatientDao patientDao=new PatientDao();
//        public Integer Count(String clounm,String where)
//        {
//            String sql="select count(*) from patient where "+clounm+" like ? ";
//            return DBUtil.getCount(sql,new Object[]{"%"+where+"%"});
//        }
        String account=request.getParameter("account");
        //判断数据库是否有相同的email
        Integer count=new PatientDao().Count1(account);
        if (account != "") {
            if (count > 0) {
                PrintWriter writer = response.getWriter();
                writer.write("true");
//			out.println("<script>window.location.href='login.jsp'</script>");
                writer.flush();
                writer.close();
            } else {
                PrintWriter writer = response.getWriter();
                writer.write("false");
                writer.flush();
                writer.close();
            }
        }

    }
}
