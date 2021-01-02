package com.qst.servlet;

import com.qst.bean.Admin;
import com.qst.bean.Doctor;
import com.qst.bean.Patient;
import com.qst.dao.AdminDao;
import com.qst.dao.DoctorDao;
import com.qst.dao.PatientDao;
import com.qst.dao.impl.IAdminimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String accounttype = request.getParameter("accounttype");
        request.getSession().removeAttribute("message");
      //  request.getSession().setAttribute("message","");
//        System.out.println(url);
        switch (accounttype){
            case "管理员":
                AdminDao adminDao=new IAdminimpl();
                List<Admin> admins = adminDao.getAdmin(account);
                if(admins.size()>0){
                    Admin admin = admins.get(0);
                    //用户账号密码正确
                    System.out.println(admin.getPassword());
                    System.out.println(password);
                    if(admin.getPassword().equals(password)){
                        request.getSession().setAttribute("admin",admin);
                        response.sendRedirect("admin/index.jsp");
                    }
                }
                break;
            case "医生":
                DoctorDao doctorDao=new DoctorDao();
                String where="where account =?";
                List<Doctor> doctors = doctorDao.query(where, new Object[]{account});
                if(doctors.size()>0){
                    Doctor doctor = doctors.get(0);
                    //医生账号密码正确
                    if(doctor.getPassword().equals(password)){
                        request.getSession().setAttribute("doctor",doctor);
                        response.sendRedirect("doctor/index.jsp");
                        return;
                    }
                }
                //用户密码错误
                request.getSession().setAttribute("message","用户名或密码错误！！");
                request.getRequestDispatcher("doctor/login.jsp").forward(request,response);
                break;
            case "患者":
                PatientDao patientDao=new PatientDao();
                List<Patient> patients = patientDao.query("account",account);
                if(patients.size()>0){
                    Patient patient = patients.get(0);
                    //判断密码是否相同
                    if(patient.getPassword().equals(password)){
                        request.getSession().setAttribute("patient",patient);
                        String url= (String) request.getSession().getAttribute("url");
                        if(url==null)
                            url="index.jsp";
                        request.getSession().setAttribute("message","登录成功！！");
                        response.sendRedirect(url);
                        return;
                    }
                }
                request.getSession().setAttribute("message","用户名或密码错误！！");
                response.sendRedirect("login.jsp");
                break;
        }

    }
}

