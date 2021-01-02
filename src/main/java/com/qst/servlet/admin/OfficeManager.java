package com.qst.servlet.admin;

import com.qst.bean.Pages;
import com.qst.dao.OfficeDao;
import com.qst.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/office")
public class OfficeManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = Util.nullToString(request.getParameter("action"));
        String message="";
        OfficeDao officeDao=new OfficeDao();
        List<com.qst.bean.Office> offices;
        switch (action){
            case "add":
                String officename = request.getParameter("officename");
                String description = request.getParameter("description");
                offices= officeDao.query("officename", officename,"");
                if(offices.size()==0){
                    com.qst.bean.Office office = new com.qst.bean.Office(officename, description, 0);
                    if(officeDao.insert(office)){
                        message=officename+"添加成功！";
                    }else {
                        message=officename+"添加失败！";
                    }
                }else {
                    message=officename+"已存在！";
                }
                request.setAttribute("message",message);
                //req.getRequestDispatcher("admin/office.jsp").forward(req,resp);
                break;
            case "query":
                offices = officeDao.query("officename", "","");
                JSONArray array=new JSONArray();
                for(com.qst.bean.Office office:offices){
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("officename",office.getOfficename());
                    jsonObject.put("description",office.getDescription());
                    jsonObject.put("doctornum",office.getDoctornum());
                    array.add(jsonObject);
                }
               response.setContentType("application/json; charset=utf-8");
                response.getWriter().write(array.toString());
                return;
        }

        String office= Util.nullToString(request.getParameter("office"));
        int start=Util.nullToZero(request.getParameter("start"));
        Pages p = new Pages(start , officeDao.getOfficeCount("officename", office),10);
        String limit="limit "+((p.getCurrentPage()-1)*10)+",10";
        offices = officeDao.query("officename", office,limit);
        request.setAttribute("offices",offices);
        request.setAttribute("office",office);
        request.setAttribute("pages",p);
        request.getRequestDispatcher("office.jsp").forward(request,response);
    }
}
