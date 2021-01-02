package com.qst.servlet;

import com.qst.bean.Patient;
import com.qst.dao.PatientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String message="";
        //得到密码
            String password = request.getParameter("password");
            String passwordCof = request.getParameter("passwordCof");
            //判断两次密码是否相等
            if(password!=null&&password.equals(passwordCof)){
                //得到账号
                String account=request.getParameter("account");
                //判断账号是否为空
                if(account!=null){
                    PatientDao patientDao=new PatientDao();
                    //从数据库中查找相同的账号记录
                    List<Patient> patients = patientDao.query("account", account);
                    //判断是否有相同的账号
                    if(patients.size()==0){
                        //得到姓名，邮箱
                        String name = request.getParameter("name");
                        String email = request.getParameter("email");
                        //存入新记录
                        Patient patient=new Patient(null,account,email,password,name,"100");
                        if(patientDao.insert(patient)){
                            message="注册成功，请登录！";
                            request.getSession().setAttribute("message",message);
                         //   request.getSession().removeAttribute("checkCode");
                            response.sendRedirect("login.jsp");
                            return;
                        }else {
                            message="注册失败，请稍后再试！";
                        }
                    }else {
                        message="该账号已存在！";
                    }
                }else {
                    message="请输入账号！";
                }
            }else {
                message="两次密码不正确！";
            }

        request.setAttribute("message",message);
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
}
