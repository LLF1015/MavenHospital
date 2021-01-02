package com.qst.servlet.patient;

import com.qst.bean.Office;
import com.qst.bean.Pages;
import com.qst.dao.OfficeDao;
import com.qst.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ="/OfficeSearch")
public class OfficeSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String office= Util.nullToString(request.getParameter("office"));
        int start=Util.nullToZero(request.getParameter("start"));
        OfficeDao officeDao=new OfficeDao();

        Pages p = new Pages(start , officeDao.getOfficeCount("officename", office),10);
        String limit="limit "+((p.getCurrentPage()-1)*10)+",10";
        List<Office> offices = officeDao.query("officename", office,limit);
        request.setAttribute("offices",offices);
        request.setAttribute("office",office);
        request.setAttribute("pages",p);
        request.getRequestDispatcher("orderOffice.jsp").forward(request,response);
    }
}
