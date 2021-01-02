<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/30
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
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
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<script rel="script" type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<div class="black_nav">
    <div class="wrap">
        <ul class="nav_enter">

            <c:if test="${sessionScope.admin!=null}">
                <li><a>欢迎您,${sessionScope.admin.name }</a><span>|</span></li>
            </c:if>

        </ul>
    </div>
</div>
<div class="white_nav">
    <div class="wrap">
        <img src="<%=request.getContextPath()%>/images/logo.png" alt="" class="logo"/>
    </div>
    <ul class="white_nav_ul">
        <li><a href="<%=request.getContextPath()%>/admin/index.jsp">基本信息</a></li>
        <li><a href="<%=request.getContextPath()%>/doctorManage">医生信息管理</a></li>
        <li><a href="<%=request.getContextPath()%>/patientManage">患者信息</a></li>
        <li><a href="<%=request.getContextPath()%>/admin/modifyPwd.jsp">修改个人密码</a></li>
        <li><a href="<%=request.getContextPath()%>/logout">安全退出</a></li>

    </ul>
</div>

