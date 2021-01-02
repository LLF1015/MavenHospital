package com.qst.servlet;

import com.qst.dao.PatientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegisterSevlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       response.setContentType("textml;charset=UTF-8");

        //获取前台的email
        String account=request.getParameter("account");

        //判断数据库是否有相同的email
        Integer count=new PatientDao().Count("account",account);

        String msg = null;
        if(count>0){
            msg=new String("账号存在");
        }
        response.getWriter().write(msg);
    }
}
