<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/28
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<div class="black_nav">
    <div class="wrap">
        <ul class="nav_enter">
            <c:if test="${sessionScope.patient==null}">
                <li><a href="login.jsp">登录</a><span>|</span></li>
                <li><a href="register.jsp">注册</a><span>|</span></li>
            </c:if>

            <c:if test="${sessionScope.patient!=null}">
                <li><a>欢迎您,${sessionScope.patient.name }</a><span>|</span></li>
                <li><a href="logout"><strong>注销</strong></a><span>|</span></li>
                <li><a href="<%=request.getContextPath()%>/modifyPwd.jsp"><strong>修改个人密码</strong></a><span>|</span></li>
             </c:if>
            <li><a href="doctor/login.jsp">医生登录</a><span>|</span></li>
            <li><a href="admin/login.jsp">管理员登录</a><span>|</span></li>

<%--<c:if test="${sessionScope.patient == null}">--%>
<%--    <a class="navbar-brand1" style="font-size: 12px;"--%>
<%--       href="login.jsp"><strong>登录</strong></a>--%>
<%--    <a class="navbar-brand1" style="font-size: 12px;"--%>
<%--       href="register.jsp"><strong>注册</strong></a>--%>
<%--</c:if>--%>
<%--<c:if test="${sessionScope.patient != null}">--%>
<%--    <a class="navbar-brand1" style="font-size: 12px;" href=""><strong><font color="#fff">欢迎您,${sessionScope.patient.name }</font></strong></a>--%>
<%--    <a class="navbar-brand1" style="font-size: 12px;"--%>
<%--    href="logout"><strong>注销</strong></a>--%>
        </ul>
    </div>
</div>
<div class="white_nav">
    <div class="wrap">
        <img src="images/logo.png" alt="" class="logo"/>
    </div>
    <ul class="white_nav_ul">
        <li><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
        <li><a href="<%=request.getContextPath()%>/OfficeSearch">挂号</a></li>
        <li><a href="<%=request.getContextPath()%>/orderList">我的预约</a></li>
    </ul>
</div>

