<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/26
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">

<html>
<head>
    <title>首页--预约挂号系统</title>
</head>
<body>

<jsp:include page="include/top.jsp"/>
<!--轮播开始-->
<div class="wrap">
    <div class="home-hero">
        <ul id="imags">
            <li>
                <a href="javascript:"><img src="images/p-1.1.1.png" width="800px"></a>
            </li>
            <li>
                <a href="javascript:"><img src="images/pc端.png" width="800px"></a>
            </li>
            <li>
                <a href="javascript:"><img src="images/p-1.1.1.png" width="800px"></a>
            </li>

        </ul>
        <ul id="icons">
            <li></li>
            <li></li>
        </ul>
    </div>
</div>
<!-- 轮播图结束-->
<!-- 内容开始-->
<div class="service-box-goods">
    <h2> 科室介绍</h2>
    <div class="wrap1">
    <div class="box-hd">
        <div>
            <img src="images/检验科.jpg" width="180px" height="180px"/>
            <p class="goods-title">检验科</p>
        </div>
        <div>
            <img src="images/急诊科.jpg" width="180px" height="180px"/>
            <p class="goods-title">急诊科</p>
        </div>
        <div>
            <img src="images/中医科.png" width="180px" height="180px"/>
            <p class="goods-title">中医科</p>
        </div>
        <div class="right">
            <img src="images/不孕不育科.png" width="180px" height="180px"/>
            <p class="goods-title">不孕不育科</p>
        </div>
        <div>
            <img src="images/口腔科.png" width="180px" height="180px"/>
            <p class="goods-title">口腔科</p>
        </div>
        <div>
            <img src="images/皮肤科.jpg" width="180px" height="180px"/>
            <p class="goods-title">皮肤科</p>
        </div>
        <div>
            <img src="images/眼科.png" width="180px" height="180px"/>
            <p class="goods-title">眼科</p>
        </div>
        <div>
            <img src="images/外科.jpg" width="180px" height="180px"/>
            <p class="goods-title">外科</p>
        </div>
    </div>
</div>
</div>

<!-- 内容结束-->
<!-- 尾部开始-->
<div class="home-footer ">
    <div class="site-footer">
        <div class="wrap1">

    <div class="site-info">
        <div class="wrap1">
            <div class="info-text">
                <p class="sites">
                    <a href="javascript:">营业执照|</a>
                    <a href="javascript:">增值电信|</a>
                    <a href="javascript:">业务经营许可证|</a>
                    <a href="javascript:">米聊|</a>
                    <a href="javascript:">多看|</a>
                    <a href="javascript:">政企服务|</a>
                    <a href="javascript:">小米天猫店|</a>
                    <a href="javascript:">小米集团隐私政策|</a>
                    <a href="javascript:">问题反馈|</a>
                    <a href="javascript:">Select Location</a>
                </p>
                <p>
                    <a href="javascript:">&copy;mi.com</a>
                    <a href="javascript:">京ICP备1004644号</a>
                    <a href="javascript:">京ICP证110507号</a>
                    <a href="javascript:">京公网安备11010802020134号</a>
                    <a href="javascript:">京网文[2020]0276-042号</a>
                    <br>
                    <a href="javascript:">增值电信业务许可证</a>
                    <a href="javascript:">网络食品经营备案</a>
                    <a href="javascript:">京食药网备202010048</a>
                    <a href="javascript:">食品经营许可证许可证</a>

                </p>
            </div>
        </div>
    </div>
    </div>
    </div>
</div>

    <!--尾部结束-->

    <script src="<%=request.getContextPath()%>/js/home-hero.js" type="text/javascript"></script>
</body>
</html>
