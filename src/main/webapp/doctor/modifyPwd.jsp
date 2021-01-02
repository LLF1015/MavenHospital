<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/30
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页--在线预约挂号系统</title>
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
            <div class="h3 alert-info ">修改密码</div>
            <div class="col-lg-8">
                <form class=" form-horizontal" action="<%=request.getContextPath()%>/modifyPwd"  method="post">
                    <div class="h3 alert-danger ">${message}</div>
                    <input hidden name="action" value="doctor">
                    <div class="form-group">
                        <label for="jmm" class="col-sm-2 control-label">旧密码</label>
                        <div class="col-sm-10">
                            <input name="jmm"  type="password" class="form-control" id="jmm" placeholder="旧密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xmm" class="col-sm-2 control-label">新密码</label>
                        <div class="col-sm-10">
                            <input name="xmm"  type="password" class="form-control" id="xmm" placeholder="新密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="qdmm" class="col-sm-2 control-label">确定密码</label>
                        <div class="col-sm-10">
                            <input name="qdmm"  type="password" class="form-control" id="qdmm" placeholder="确定密码">
                        </div>
                    </div>
                    <div class="row">
                        <button type="submit" class="btn btn-primary  center-block" style="width: 150px" data-toggle="modal" data-target="#myModal">确定</button>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>
</body>
</html>
