package com.qst.servlet.patient;

import com.qst.bean.Doctor;
import com.qst.bean.Patient;
import com.qst.bean.Recode;
import com.qst.dao.DoctorDao;
import com.qst.dao.PatientDao;
import com.qst.dao.RecodeDao;

import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = "/orderList")
public class OrderList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Patient patient= (Patient) request.getSession().getAttribute("patient");
//        RecodeDao recodeDao = new RecodeDao();
//        DoctorDao doctorDao=new DoctorDao();
//        String where="where pid=? order by ordertime desc";
//        String where1="where pid=? order by ordertime desc";
//        List<Recode> Recodelist = recodeDao.query(where, new Object[]{patient.getId()});
//        List<Doctor> DoctorList= doctorDao.query(where,)
//       // List<HashMap<String, String>> list = recodeDao.orderList(patient.getId());
//        request.setAttribute("list",list);

        RecodeDao recodeDao=new RecodeDao();
        List<HashMap<String, String>> list = null;
        try {
            list = recodeDao.orderList1(patient.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        request.getRequestDispatcher("orderList.jsp").forward(request,response);

    }
}
