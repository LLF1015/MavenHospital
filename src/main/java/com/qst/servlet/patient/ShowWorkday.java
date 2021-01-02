package com.qst.servlet.patient;

import com.qst.bean.Doctor;
import com.qst.bean.WorkDay;
import com.qst.dao.DoctorDao;
import com.qst.dao.WorkDayDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ShowWorkday")
public class ShowWorkday extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

            String doctorid = request.getParameter("did");
            if (doctorid==null){
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else {
                DoctorDao doctorDao = new DoctorDao();
                List<Doctor> doctors = doctorDao.query("where did=? ", new Object[]{doctorid});
                if(doctors.size()>0){
                    WorkDayDao workDayDao=new WorkDayDao();
                    String where =" where did=?";
                    List<WorkDay> workDays= workDayDao.query(where,new Object[]{doctorid});
                    request.setAttribute("workDays",workDays);
                    request.setAttribute("doctor",doctors.get(0));
                    request.getRequestDispatcher("doctorInfo.jsp").forward(request,response);
                }else {
                    response.getWriter().write("没有这个医生");
                }
            }
        }
}
