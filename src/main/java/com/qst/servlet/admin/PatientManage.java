package com.qst.servlet.admin;

import com.qst.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns = "/patientManage")
public class PatientManage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql ="select * from patient";
        ArrayList<HashMap<String, String>> hashmap = DBUtil.getHashmap(sql, null);
        request.setAttribute("hashmap",hashmap);
        request.getRequestDispatcher("/admin/patientManage.jsp").forward(request,response);
    }
}
