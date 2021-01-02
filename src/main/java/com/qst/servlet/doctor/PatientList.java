package com.qst.servlet.doctor;

import com.qst.bean.Doctor;
import com.qst.dao.PatientDao;
import com.qst.dao.RecodeDao;
import com.qst.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns= "/patientList")
public class PatientList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = Util.nullToString(request.getParameter("action"));
        Doctor doctor = (Doctor) request.getSession().getAttribute("doctor");
        String rid = Util.nullToString(request.getParameter("rid"));
        String pid = Util.nullToString(request.getParameter("pid"));
        RecodeDao recodeDao = new RecodeDao();
//        IntegrityDao integrityDao = new IntegrityDao();
//        Integrity integrity;
        String set;
        switch (action){
            case "finish":
                set = "set state ='完成' where rid=?";
                recodeDao.update(set,new Object[]{rid});
//                integrity = new Integrity("", pid, doctor.getDname(), doctor.getOffice(), "", "完成预约", "10");
//                integrityDao.insert(integrity);
                break;
            case "sy":
                set = "set state ='爽约' where rid=?";
                recodeDao.update(set,new Object[]{rid});
//                integrity = new Integrity("", pid, doctor.getDname(), doctor.getOffice(), "", "爽约", "-10");
//                integrityDao.insert(integrity);
                break;
        }
        PatientDao patientDao = new PatientDao();

        ArrayList<HashMap<String, String>> list = patientDao.patientList(doctor.getDid());
        request.setAttribute("list",list);
        request.getRequestDispatcher("/doctor/patientList.jsp").forward(request,response);
    }
}
