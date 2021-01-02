package com.qst.servlet;

import com.qst.bean.Admin;
import com.qst.bean.Doctor;
import com.qst.bean.Patient;
import com.qst.dao.DoctorDao;
import com.qst.dao.PatientDao;
import com.qst.dao.impl.IAdminimpl;
import com.qst.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns= "/modifyPwd")
public class ModifyPwd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = Util.nullToString(request.getParameter("action"));
        String jmm = Util.nullToString(request.getParameter("jmm"));
        String xmm = Util.nullToString(request.getParameter("xmm"));
        String qdmm = Util.nullToString(request.getParameter("qdmm"));
        String message="";
        switch (action){
            case "doctor":
                Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
                if(doctor.getPassword().equals(jmm)){
                    if(xmm.equals(qdmm)){
                        DoctorDao doctorDao=new DoctorDao();
                        String set ="set password=? where did=?";
                        if(doctorDao.update(set,new Object[]{xmm,doctor.getDid()})){
                            message="修改成功";


                        }else {
                            message="修改失败";
                        }
                    }else {
                        message="两次密码不一样";
                    }
                }else {
                    message="密码错误";
                }
                request.setAttribute("message",message);
                request.getRequestDispatcher("logout").forward(request,response);
               // request.getRequestDispatcher("/doctor/modifyPwd.jsp").forward(request,response);
                break;
            case "patient":
                Patient patient= (Patient) request.getSession().getAttribute("patient");
                if(patient.getPassword().equals(jmm)){
                    if(xmm.equals(qdmm)){
                        PatientDao patientDao=new PatientDao();
                        String set ="set password=? where pid=?";
                        if(patientDao.update(set,new Object[]{xmm,patient.getId()})){
                            message="修改成功";
                        }else {
                            message="修改失败";
                        }
                    }else {
                        message="两次密码不一样";
                    }
                }else {
                    message="密码错误";
                }
                request.setAttribute("message",message);
                request.getRequestDispatcher("logout").forward(request,response);
               // request.getRequestDispatcher("modifyPwd.jsp").forward(request,response);
                break;
            case "admin":
                Admin admin= (Admin) request.getSession().getAttribute("admin");
                if(admin.getPassword().equals(jmm)){
                    if(xmm.equals(qdmm)){
                        IAdminimpl adminDao=new IAdminimpl() ;
                        String set ="set password=? where account=?";
                        if(adminDao.updateAdmin(set,new Object[]{xmm,admin.getAccount()})){
                            message="修改成功";
                        }else {
                            message="修改失败";
                        }
                    }else {
                        message="两次密码不一样";
                    }
                }else {
                    message="密码错误";
                }
                request.setAttribute("message",message);
                request.getRequestDispatcher("/admin/modifyPwd.jsp").forward(request,response);
                break;
        }
    }


}
