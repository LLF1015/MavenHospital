<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/27
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册--在线预约挂号系统</title>
    <style>
        body{
            background-image: url("images/bg2.jpg");
            background-size: 100%;
            text-align: center;
        }
        .form-box{
            margin: 0 auto;
            width: 550px;
            color: #fff;
        }
        .form-box a{
            color: #de615e;
            text-decoration: none;
        }
        .form-top {
            overflow: hidden;
            padding: 0 25px 15px 25px;
            background: #444;
            background: rgba(0, 0, 0, 0.35);
            -moz-border-radius: 4px 4px 0 0;
            -webkit-border-radius: 4px 4px 0 0;
            border-radius: 4px 4px 0 0;
            text-align: left;
        }
        .form-bottom {
            padding: 25px 25px 30px 25px;
            background: #444;
            background: rgba(0, 0, 0, 0.3);
            -moz-border-radius: 0 0 4px 4px;
            -webkit-border-radius: 0 0 4px 4px;
            border-radius: 0 0 4px 4px;
            text-align: left;
        }
        .form-top-left {
            float: left;
            width: 75%;
            padding-top: 25px;
        }
        .form-top-left h3 {
            margin-top: 0;
            color: #969696;
        }
        .form-top-left p {
            opacity: 0.8;
            color: #fff;
        }

        .text-danger {
            color: #b94a48;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .col-xs-12 {
            width: 100%;
            float: left;
            position: relative;
            min-height: 1px;
            padding-left: 15px;
            padding-right: 15px;
        }
        .sr-only {
            position: absolute;
            width: 1px;
            height: 1px;
            margin: -1px;
            padding: 0;
            overflow: hidden;
            clip: rect(0, 0, 0, 0);
            border: 0;
        }
        input[type="text"], input[type="password"], textarea, textarea.form-control {
            display: block;
            width: 90%;
            height: 50px;
            margin: 0;
            padding: 0 20px;
            vertical-align: middle;
            background: #fff;
            border: 1px solid #cccccc;
            font-family: 'Roboto', sans-serif;
            font-size: 16px;
            font-weight: 300;
            line-height: 50px;
            color: #888;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            -moz-box-shadow: none;
            -webkit-box-shadow: none;
            box-shadow: none;
            -o-transition: all .3s;
            -moz-transition: all .3s;
            -webkit-transition: all .3s;
            transition: all .3s;
        }
        .btn {
            width: 90%;
            display: inline-block;
            height: 50px;
            margin: 0;
            padding: 0 20px;
            vertical-align: middle;
            background: #de615e;
            border: 0;
            font-family: 'Roboto', sans-serif;
            font-size: 16px;
            font-weight: 300;
            line-height: 50px;
            color: #fff;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            text-shadow: none;
            -moz-box-shadow: none;
            -webkit-box-shadow: none;
            box-shadow: none;
            -o-transition: all .3s;
            -moz-transition: all .3s;
            -webkit-transition: all .3s;
            transition: all .3s;
        }
        .pull-right{
            float: right;
        }
    </style>
</head>
<body>
<div class="form-box">
    <div class="form-top">
        <div class="form-top-left">
            <h3 style="color: #969696;">用户注册</h3>
            <p>请输入注册信息</p>
        </div>
        <div class="pull-right-bottom">
            <p class="text-danger"
               id="errorTip">${message}</p>
        </div>

    </div>
    <div class="form-bottom">
        <form role="form" action="register" method="post" class="login-form">
            <div class="form-group col-xs-12">
                <label class="sr-only" for="userEmail">account</label>账号(*):<input
                    style="font-weight: bold" type="text" name="account"
                    id="account" class="form-control input-control clearfix"
                    required  /><span id="accountTip"></span>
            </div>
            <div class="form-group col-xs-12">
                <label class="sr-only" for="userEmail">userEmail</label>邮箱(*):<input
                    style="font-weight: bold" type="text" name="email"
                    id="userEmail" class="form-control input-control clearfix"
                    required  onkeyup="isCheckEmail()" /><span id="emailTip"></span>
            </div>
            <div class="form-group col-xs-12">
                <label class="sr-only" for="userName">name</label>姓名(*):<input
                    style="font-weight: bold" type="text" name="name"
                    id="userName" class="form-username form-control" required />
            </div>
            <div class="form-group col-xs-12">
                <label class="sr-only" >password</label>密码(*):<input
                    style="font-weight: bold" type="password" name="password"
                    class="form-password form-control" id="pwd1" required />
            </div>
            <div class="form-group col-xs-12">
                <label class="sr-only" >passwordCof</label>确认密码(*):<input
                    style="font-weight: bold" type="password"
                    name="passwordCof" class="form-password form-control "
                    id="pwd2" required onkeyup="isCheckPwd()" /> <span id="pwdTip"></span>
            </div>

            <div class="form-group col-xs-12">
                <button type="submit" class="btn" id="btn">立即注册</button>
            </div>
        </form>
        <span><a href="#">找回密码</a></span> <span><a
            href="login.jsp" class="pull-right">用户登录</a></span>
    </div>

    <script>

        function isCheckEmail() {
            var email = document.getElementById("userEmail").value;
            document.getElementById("errorTip").innerHTML = "";
            if (email != "") {
                var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                isok = reg.test(email);
                if (isok) {
                    document.getElementById("emailTip").innerHTML = "邮箱格式正确";
                    document.getElementById("btn").disabled = false;
                    return true;
                } else {
                    document.getElementById("btn").disabled = true;
                    document.getElementById("emailTip").innerHTML = "邮箱格式不正确";
                    return false;
                }
            } else {
                document.getElementById("emailTip").innerHTML = "";
                return false;
            }
        }
        $("#account").blur(function(){
            var account = document.getElementById("account").value;

            console.log(account);
            $.ajax({
                type: "POST",//写一下重复密码
                url: "<%=request.getContextPath()%>/RegUserinfoAction",
                data: {account: account},
                dataType: 'json',
                success: function (data) {
                    if(data==true){
                        alert("抱歉，该用户名已经被注册");
                    }else{
                        alert("恭喜，该用户名还没有注册");
                    }
                }
            });
        });
        function isCheckPwd() {
            var pwd1 = document.getElementById("pwd1").value;
            var pwd2 = document.getElementById("pwd2").value;
            document.getElementById("errorTip").innerHTML = "";
            if (pwd1 == pwd2) {
                document.getElementById("pwdTip").innerHTML = "两次密码相同";
                document.getElementById("btn").disabled = false;
            } else {
                document.getElementById("pwdTip").innerHTML = "两次密码不相同";
                document.getElementById("btn").disabled = true;
            }
        }
    </script>



</div>
</body>
</html>
