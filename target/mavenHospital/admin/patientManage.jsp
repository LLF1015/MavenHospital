<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/30
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>患者队列--在线预约挂号系统</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script rel="script" type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
</head>
<body>
<jsp:include page="top.jsp"/>
<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">
        <div class="container">
            <div class="h3 alert-info info">患者信息</div>

            <%--显示患者信息--%>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <td>序号</td>
                    <td>患者账号</td>
                    <td>患者姓名</td>
                    <td>患者邮箱</td>
                 <!--   <td>诚信度</td> -->
                </tr>
                </thead>
                <c:forEach var="item" items="${hashmap}" varStatus="statu">
                    <tr>
                        <td>${statu.index+1}</td>
                        <td>${item.account}</td>
                        <td>${item.name}</td>
                        <td>${item.email}</td>
<%--                        <td>${item.integrity}</td>--%>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

</body>
</html>
