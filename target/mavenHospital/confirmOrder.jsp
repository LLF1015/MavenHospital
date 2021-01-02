<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/28
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<script rel="script" type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
<html>
<head>
    <title>确定预约--在线预约挂号系统</title>
</head>
<body>
<jsp:include page="include/top.jsp"/>
<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">
        <c:if test="${numSource != null}">
            <div class="container1">
                <style>
                    .container1 .title{color: #00E8D7;margin:20px auto;display: table;}
                    .container1 .left{float: left;width: 30%;}
                    .container1 .left .send{background-color: #009F95;color:#fff;border-radius: 5px;border: #009F95;cursor: pointer;}
                    .container1 .left .confirm{text-align: center;background-color: #009F95;color:#fff;border-radius: 10px;height:30px;cursor:pointer;}
                </style>
                <h2 class="title">预约信息核对</h2>
                <div class="left">
                    <form autocomplete="off" method="post" action="order">
                        <input hidden name="wid" value="${numSource.state}">
                        <input hidden name="did" value="${doctor.did}">
                        <input hidden name="action" value="confirm">
                        <table>
                            <tr><td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td><td>${sessionScope.patient.name}</td></tr>
                            <tr><td>预约医生：</td><td>${doctor.dname}</td></tr>
                            <tr><td>预约科室：</td><td>${doctor.office}&nbsp</td></tr>
                            <tr><td>就诊时间：</td><td>${numSource.visitdate} ${numSource.visittime}第${numSource.serialnumber}号</td></tr>
                            <tr><td>诊&nbsp;&nbsp;查&nbsp;&nbsp;费：</td><td>${doctor.fee}.00元</td></tr>
                            <tr><td>你的邮箱：</td><td>${sessionScope.patient.email}
                            <tr><td colspan="2"  class="confirm"> <button type="submit" class="btn" wid="btn">确定</button></td></tr>

                        </table>

                    </form>

                </div>

            </div>
        </c:if>

    </div>
</div>
</body>
</html>
