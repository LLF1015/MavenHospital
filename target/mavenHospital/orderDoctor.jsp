<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: ASUS--%>
<%--  Date: 2020/12/28--%>
<%--  Time: 10:34--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">--%>
<%--<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title> <title>找医生--在线预约挂号系统</title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="include/top.jsp"/>--%>
<%--<div style="margin-top: 100px;margin-left: 150px">--%>
<%--    <div id="page-inner">--%>
<%--        <div class="search">--%>
<%--            <h1>按医生挂号</h1>--%>
<%--            <form id="doctor" action="DoctorSearch" method="post">--%>
<%--                <input  value="${doctor}" name="doctor"  autocomplete="off" class="" placeholder="查找医生">--%>
<%--                <input id="start" hidden value="1" name="start">--%>
<%--                <input id="order" hidden value="doctor" name="order">--%>
<%--                <button type="submit">查找医生</button>--%>
<%--            </form>--%>
<%--            <style>--%>
<%--                .search{--%>
<%--                    height:150px;--%>
<%--                    border-bottom: 2px #2e2e2e solid;--%>
<%--                }--%>
<%--                .search input{--%>
<%--                    height: 40px;--%>
<%--                    width: 200px;--%>
<%--                    color: #2e2e2e;--%>
<%--                    padding: 0 20px;--%>
<%--                    border-radius: 4px;--%>
<%--                }--%>
<%--                .search button{--%>
<%--                    height: 40px;--%>
<%--                    color: #2e2e2e;--%>
<%--                    padding: 0 20px;--%>
<%--                    border-radius: 2px;--%>
<%--                    cursor: pointer;--%>
<%--                }--%>
<%--                .search button:hover{--%>
<%--                    color: #0065AF;--%>
<%--                }--%>
<%--            </style>--%>
<%--        </div>--%>


<%--        <div class="doctors">--%>
<%--            <c:forEach items="${doctors}" var="item">--%>
<%--                <div class="ysjs">--%>
<%--                    <div class="title">--%>
<%--                        <div class="t">--%>
<%--                            <span><a href="ShowWorkday?did=${item.did}">${item.dname}</a></span>--%>
<%--                            <span class="gender">${item.gender}</span>--%>
<%--                            <span class="career">${item.career}</span>--%>
<%--                            <span class="career">${item.age}岁</span>--%>
<%--                        </div>--%>
<%--                        <img src="${item.picpath}">--%>
<%--                    </div>--%>
<%--                    <div class="content">--%>
<%--                        <div >--%>
<%--                            <div>介绍：</div>--%>
<%--                            <div>${item.description}</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>

<%--            <style>--%>
<%--                .doctors:after{--%>
<%--                    content: "";--%>
<%--                    clear: both;--%>
<%--                    display: block;--%>
<%--                }--%>
<%--                .ysjs{--%>
<%--                    float: left;--%>
<%--                    margin: 20px;--%>
<%--                    height: 300px;--%>
<%--                    border-radius: 8px;--%>
<%--                    width: 680px;--%>
<%--                    border: 1px #000 solid;--%>
<%--                }--%>
<%--                .ysjs .title{--%>
<%--                    margin: 20px;--%>
<%--                    position: relative;--%>
<%--                }--%>
<%--                .ysjs .title:after{--%>
<%--                    visibility: hidden;--%>
<%--                    display: block;--%>
<%--                    font-size: 0;--%>
<%--                    content: "";--%>
<%--                    clear: both;--%>
<%--                    height: 0;--%>
<%--                }--%>
<%--                .ysjs .title .t span{--%>
<%--                    margin: 20px;--%>
<%--                    color: rgb(43,43,43);--%>
<%--                    font-size: 30px;--%>
<%--                    line-height: 30px;--%>
<%--                }--%>
<%--                .ysjs .title img{--%>
<%--                    position: absolute;--%>
<%--                    top: 100px;--%>
<%--                    left: 480px;--%>
<%--                    width: 100px;--%>
<%--                    height: 125px;--%>
<%--                }--%>
<%--                .ysjs .title .t .gender{--%>
<%--                    color:rgb(95, 156, 236);--%>
<%--                }--%>
<%--                .ysjs .title .t .career{--%>
<%--                    font-size: 17px;--%>
<%--                    margin-left: 30px;--%>
<%--                    color:rgb(61,175,167);--%>
<%--                }--%>
<%--                .ysjs .content {--%>
<%--                    border-top: 1px solid rgb(219, 219, 219);--%>
<%--                    margin: 30px;--%>
<%--                    text-align: left;--%>
<%--                    width: 640px;--%>
<%--                }--%>
<%--                .ysjs .content div{--%>
<%--                    padding-top: 10px;--%>
<%--                }--%>
<%--            </style>--%>
<%--        </div>--%>
<%--        &lt;%&ndash;分页&ndash;%&gt;--%>
<%--        <c:if test="${pages.totalPage > 0}">--%>
<%--            <form id="pagination">--%>

<%--                <ul class="pagination">--%>
<%--                    <li <c:if test="${pages.currentPage < 1}">class="disabled"</c:if>><a--%>
<%--                            onclick="jump('${pages.prePage }')">&laquo;</a></li>--%>
<%--                    <c:forEach begin="${pages.pageNumStart }" end="${pages.pageNumEnd }"--%>
<%--                               varStatus="status">--%>
<%--                        <li>--%>
<%--                            <a <c:if test="${status.index == pages.currentPage }">class="disabled"</c:if>--%>
<%--                               onclick="jump('${status.index }')">--%>
<%--                                    ${status.index } </a>--%>
<%--                        </li>--%>
<%--                    </c:forEach>--%>
<%--                    <li--%>
<%--                            <c:if test="${pages.currentPage> pages.totalPage}">class="disabled"</c:if>>--%>
<%--                        <a onclick="jump('${pages.nextPage }')">&raquo;</a>--%>
<%--                    </li>--%>
<%--                    <li><input class="text-input" id="index"></li>--%>
<%--                    <li><a onclick="jumpInput()">Go</a></li>--%>
<%--                    <li><a class="disabled">共${pages.totalPage}页${pages.totalRecord}条记录</a>--%>

<%--                        <script>--%>
<%--                            function jump(index) {--%>
<%--                                $("#start").val(index);--%>
<%--                                $("#doctor").submit();--%>
<%--                            }--%>
<%--                            function jumpInput() {--%>
<%--                                var index=$("#index").val();--%>
<%--                                var match = /^[1-9][0-9]*[0-9]*$/;--%>
<%--                                if(match.test(index)){--%>
<%--                                    jump(index);--%>
<%--                                }else {--%>
<%--                                    alert("请输入数字！")--%>
<%--                                }--%>
<%--                            }--%>
<%--                        </script>--%>
<%--                        <style>--%>
<%--                            #pagination{--%>
<%--                                width: 90%;--%>
<%--                                text-align: center;--%>
<%--                            }--%>
<%--                            .pagination {--%>
<%--                                display: inline-block;--%>
<%--                                padding-left: 0;--%>
<%--                                margin: 21px 0;--%>
<%--                                border-radius: 4px;--%>
<%--                            }.pagination li{--%>
<%--                                 display: inline;--%>
<%--                             }--%>

<%--                            .pagination a{--%>
<%--                                border-radius: 6px;--%>
<%--                                color: #eb6864;--%>
<%--                                cursor: pointer;--%>
<%--                                padding: 14px 16px;--%>
<%--                                font-size: 19px;--%>
<%--                                line-height: 1.3333333;--%>
<%--                                border: 1px solid #dddddd;--%>
<%--                                margin-left: -1px;--%>
<%--                            }--%>
<%--                            .pagination a:hover{--%>
<%--                                background-color: #eeeeee;--%>
<%--                            }--%>
<%--                            .pagination input{--%>
<%--                                border: 1px solid #dddddd;--%>
<%--                                width: 60px;--%>
<%--                                padding: 8px 12px;--%>
<%--                                font-size: 15px;--%>
<%--                                line-height: 1.5;--%>
<%--                                color: #777777;--%>
<%--                            }--%>
<%--                            .pagination .disabled{--%>
<%--                                cursor: not-allowed;--%>
<%--                            }--%>
<%--                        </style>--%>
<%--                </ul>--%>
<%--            </form>--%>
<%--        </c:if>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
