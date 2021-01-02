package com.qst.servlet.patient;

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

@WebServlet(urlPatterns = "/DoctorSearch")
public class DoctorSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //从前端得到数据
        String office = Util.nullToString(request.getParameter("office"));
        String name = Util.nullToString(request.getParameter("doctor"));
        int start = Util.nullToZero(request.getParameter("start"));
        DoctorDao doctorDao=new DoctorDao();
        //数据库查询语句
        String where="where office like ? and dname like ? ";
        //获取结果数量
        int total=doctorDao.getDoctorCount(where,new Object[]{Util.toLike(office),Util.toLike(name)});
        //页数
        Pages pages = new Pages(start , total, 6);
        where+=" limit "+((pages.getCurrentPage()-1)*6)+",6";
        //根据页号显示结果
        List<Doctor> doctors = doctorDao.query(where, new Object[]{Util.toLike(office),Util.toLike(name)});
        //为前端页面设置值
        request.setAttribute("doctors",doctors);
        request.setAttribute("pages",pages);
        request.setAttribute("doctor",name);
        OfficeDao officeDao=new OfficeDao();
        //获取科室
        List<Office> offices = officeDao.query("officename", office, "");
        request.setAttribute("office",offices.get(0));
        String order = request.getParameter("order");
//        if("doctor".equals(order)){
//            request.getRequestDispatcher("/orderDoctor.jsp").forward(request,response);
//        }else
        //重定向
            request.getRequestDispatcher("/officeInfo.jsp").forward(request,response);
    }
}
