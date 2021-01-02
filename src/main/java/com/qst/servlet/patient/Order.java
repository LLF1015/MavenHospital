package com.qst.servlet.patient;

import com.qst.bean.*;
import com.qst.dao.DoctorDao;
import com.qst.dao.NumSourceDao;
import com.qst.dao.RecodeDao;
import com.qst.dao.WorkDayDao;
import com.qst.util.DBUtil;
import com.qst.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

//<tr><td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td><td>${sessionScope.patient.name}</td></tr>
//<tr><td>预约医生：</td><td>${doctor.dname}</td></tr>
//<tr><td>预约科室：</td><td>${doctor.office}&nbsp</td></tr>
//<tr><td>就诊时间：</td><td>${numSource.visitdate} ${numSource.visittime}第${numSource.serialnumber}号</td></tr>
//<tr><td>诊&nbsp;&nbsp;查&nbsp;&nbsp;费：</td><td>${doctor.fee}.00元</td></tr>
//<tr><td>你的邮箱：</td><td>${sessionScope.patient.email}
//<tr><td colspan="2"  class="confirm">确定</td></tr>
@WebServlet(urlPatterns = "/order")
public class Order extends HttpServlet {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private RecodeDao recodeDao = new RecodeDao();
    private NumSourceDao numSourceDao = new NumSourceDao();
    Patient patient;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.req = request;
        this.resp = response;
        patient = (Patient) req.getSession().getAttribute("patient");
        String wid = req.getParameter("wid");//工作日id
        String did = req.getParameter("did");//工作日id
        String action = req.getParameter("action");
      //  String checkcode = Util.nullToString(req.getParameter("checkcode"));
        String rid = req.getParameter("rid");//记录的id
        String data = Util.nullToString(req.getParameter("data"));//就诊序号
        String[] strings = data.split(",");
        String where = "where wid=? and visitdate=? and visittime=? and state='成功'";
        RecodeDao recodeDao = new RecodeDao();
        switch (action) {
            case "order"://准备预约
                NumSource numSource = new NumSource(strings[0], strings[1], strings[2], strings[3], wid);
                //HashMap<String, String> hashMap = recodeDao.confirm(id);
                DoctorDao doctorDao = new DoctorDao();
                List<Doctor> doctors = doctorDao.query(" where did=?", new Object[]{did});
                req.getSession().setAttribute("numSource", numSource);
                req.setAttribute("doctor", doctors.get(0));
                req.getRequestDispatcher("confirmOrder.jsp").forward(req, resp);
                break;
            case "confirm"://完成预约
                NumSource numSources = (NumSource) request.getSession().getAttribute("numSource");
                Recode recode=new Recode();
                recode.setPid(patient.getId());
                recode.setDid(did);
                recode.setWid(wid);
                recode.setSerialnumber(numSources.getSerialnumber());
                recode.setRid(null);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             //   String OderTime = sdf.format(LocalDateTime.now());
                SimpleDateFormat sdf1= new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat sdf2= new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
                Date d=new Date();
                Timestamp tm=new Timestamp(d.getTime());
                    recode.setOrdertime(tm);
                try {
                    recode.setVisitdate(sdf.parse(numSources.getVisitdate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                recode.setVisittime(numSources.getVisittime());
                recode.setState("成功");
                String where1 = "where wid=? and visitdate=? and visittime=? and state='成功'";

                System.out.println(numSources.getState());
                System.out.println(wid);
                List<Recode> list = recodeDao.query(where1, new Object[]{numSources.getState(),numSources.getVisitdate(),numSources.getVisittime()});
                if (list.size() == 0) {
                    //new Recode("",patient.getId(),numSource.getState(),did,numSource)
                    if (recodeDao.order(recode)) {
                        WorkDayDao workDayDao=new WorkDayDao();
                        String where2 =" where wid=? ";
                        List<WorkDay> workDay= workDayDao.query(where2,new Object[]{wid});
                        String where3="set nsnum=? where wid=?";
                        String where4="set nsnum=? and state=? where wid=?";
                        int num=workDay.get(0).getNsnum()-1;
                        if(num!=0)
                        {
                            workDayDao.update(where3,new Object[]{num,wid});
                        }
                        else
                        {
                            workDayDao.update(where4,new Object[]{num,"停诊",wid});
                        }
                        request.getSession().setAttribute("message", "预约成功！");
                        request.getRequestDispatcher("orderList").forward(request, response);
                    } else {
                        req.getSession().setAttribute("message", "预约失败！");
                        req.getRequestDispatcher("ShowWorkday?did=" + did).forward(req, resp);
                    }
                } else {
                    req.getSession().setAttribute("message", "号源已被预约！");
                    req.getRequestDispatcher("ShowWorkday?did=" + did).forward(req, resp);
                }
                break;
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
