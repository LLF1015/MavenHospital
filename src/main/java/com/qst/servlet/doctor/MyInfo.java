package com.qst.servlet.doctor;

import com.qst.bean.Doctor;
import com.qst.dao.DoctorDao;
import com.qst.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(urlPatterns = "/doctor/myInfo")
public class MyInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        com.jspsmart.upload.SmartUpload su = new  com.jspsmart.upload.SmartUpload();
//        su.initialize(pageContext);
//        su.service(request, response);
//        su.setTotalMaxFileSize(100000000);
//        su.setAllowedFilesList("zip,rar");
//        su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
//        su.upload();

        DoctorDao doctorDao=new DoctorDao();
        Doctor doctor = (Doctor) request.getSession().getAttribute("doctor");
        String action = Util.nullToString(request.getParameter("action"));

        String name1 = request.getParameter("name");
        String age1 = request.getParameter("age");
        System.out.println("name"+name1);
        System.out.println("age"+age1);

        System.out.println("action"+action);
        if("alter".equals(action)){
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String description = request.getParameter("description");
            doctor.setDname(name);
            doctor.setAge(age);
            doctor.setDescription(description);
            Part part;
            part = request.getPart("pic");
            if(part.getSize()>0&&part.getSize()<1024*1024){
                System.out.println(part.getSubmittedFileName());
                String fileName = part.getSubmittedFileName();
                String jpg=fileName.substring(fileName.lastIndexOf("."));
              System.out.println(jpg);
                InputStream is=part.getInputStream();
                String realPath = this.getServletContext().getRealPath("images/docpic");
                System.out.println(realPath);
                FileOutputStream fos = new FileOutputStream(realPath+"/"+doctor.getDid()+jpg);
                byte[] bytes=new byte[1024];
                int i=0;
                while ((i=is.read(bytes))!=-1){
                    fos.write(bytes,0,i);
                }
                fos.close();
                is.close();
                doctor.setPicpath("/mavenHospital/images/docpic/"+doctor.getDid()+jpg);
                System.out.println(doctor.getPicpath());
            }
            Object[] o=new Object[]{
                    doctor.getDname(),
                    doctor.getAge(),
                    doctor.getDescription(),
                    doctor.getPicpath(),
                    doctor.getDid()};
            String set="set dname=?,age=?,description=?,picpath=? where did=?";
            doctorDao.update(set,o);
        }
        request.getRequestDispatcher("/doctor/myInfo.jsp").forward(request,response);
    }

}
