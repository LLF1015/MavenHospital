package com.qst.servlet.admin;

import com.qst.bean.Doctor;
import com.qst.bean.Office;
import com.qst.bean.Pages;
import com.qst.dao.DoctorDao;
import com.qst.dao.OfficeDao;
import com.qst.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/doctorManage")
public class DoctorManage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String office = Util.nullToString(request.getParameter("office"));
        String name = Util.nullToString(request.getParameter("doctor"));
        String action = Util.nullToString(request.getParameter("action"));
        if("add".equals(action)){
            String message="增加医生失败！";
            DoctorDao doctorDao = new DoctorDao();
            System.out.println(request.getParameter("account"));
            List<Doctor> doctors = doctorDao.query("where account=? ",new Object[]{Util.nullToString(request.getParameter("account"))});
            if(doctors.size()==0){
                Doctor doctor=new Doctor();
                doctor.setAccount(request.getParameter("account"));
                doctor.setPassword(request.getParameter("password"));
                doctor.setDname(request.getParameter("name"));
                doctor.setFee(request.getParameter("fee"));
                doctor.setGender(request.getParameter("gender"));
                doctor.setAge(request.getParameter("age"));
                doctor.setOffice(request.getParameter("office1"));
             //  doctor.setRoom(req.getParameter("room"));
                doctor.setCareer(request.getParameter("career"));
                doctor.setDescription(request.getParameter("description"));
                doctor.setPicpath(request.getContextPath()+"/images/docpic/default.jpg");
                if(doctorDao.insert(doctor)){
                    //添加医生
                    message="添加"+request.getParameter("name")+"医生成功!";
                    //科室中的医生数量加1
                    String where="set doctornum=? where officename=?";
                    OfficeDao officeDao=new OfficeDao();
                    String where1="where officename=?";
                    Office office1 =officeDao.get(where1,new Object[]{doctor.getOffice()});
             //       Office office1 = (Office) officeDao.query("officename", "","");
                    int num=office1.getDoctornum()+1;
                    officeDao.update(where,new Object[]{num,office1.getOfficename()});
                }
            }else {
                message=request.getParameter("account")+"账号已存在！";
            }
            request.setAttribute("message",message);
        }
        int start = Util.nullToZero(request.getParameter("start"));
        DoctorDao doctorDao=new DoctorDao();
        String where="where office like ? and dname like ? ";
        int total=doctorDao.getDoctorCount(where,new Object[]{Util.toLike(office),Util.toLike(name)});
        Pages pages = new Pages(start , total, 6);
        where+="limit "+((pages.getCurrentPage()-1)*6)+",6";
        List<Doctor> doctors = doctorDao.query(where, new Object[]{Util.toLike(office),Util.toLike(name)});
        request.setAttribute("doctors",doctors);
        request.setAttribute("pages",pages);
        request.setAttribute("doctor",name);
        //OfficeDao officeDao=new OfficeDao();
        //List<Office> offices = officeDao.query("officename", office, "");
        request.setAttribute("office",office);
        request.getRequestDispatcher("/admin/doctorManage.jsp").forward(request,response);
    }
}
