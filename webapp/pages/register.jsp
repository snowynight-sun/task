<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            letter-spacing: .05em;
        }

        html {
            height: 100%;

        }

        body {
            height: 100%;

        }

        .container {
            height: 100%;
            background-image: linear-gradient(-225deg, #7085B6 0%, #87A7D9 50%, #DEF3F8 100%);
        }

        .login-wrapper {
            background-color: #fff;
            width: 250px;
            height: 550px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }

        .login-wrapper .header {
            font-size: 30px;
            font-weight: bold;
            text-align: center;
            line-height: 75px;
        }

        .login-wrapper .form-warpper .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px
        }
        .btn{
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(
                    -225deg
                    , #7085B6 0%, #87A7D9 50%, #DEF3F8 100%);
            color: #fff;
        }
    </style>

    <script type="text/javascript">
        function checkname() {
            var name = document.getElementById("name").value;
            var span = document.getElementById("span_name");
            if (name == "" || name == null) {
                span.innerHTML = "<font color='red' size='2'>姓名不能为空</font>";
                document.getElementById("name").value = "";
                document.getElementById("name").focus();
                return false;
            } else if (name.length > 10) {
                span.innerHTML = "<font color='red' size='2'>姓名长度不能超过10</font>";
                document.getElementById("name").value = "";
                document.getElementById("name").focus();
                return false
            } else {
                span.innerHTML = "<font color='green' size='2'>用户名可用</font>";
                return true;
            }
        }

        function checkpwd() {
            var pwd = document.getElementById("password").value;
            var span = document.getElementById("span_pwd");
            if (pwd == "" || pwd == null) {
                span.innerHTML = "<font color='red' size='2'>密码不能为空</font>";
                document.getElementById("password").value = "";
                document.getElementById("password").focus();
                return false;
            } else if (pwd.length < 6) {
                span.innerHTML = "<font color='red' size='2'>密码长度不能短于6</font>";
                document.getElementById("password").value = "";
                document.getElementById("password").focus();
                return false;
            } else if (pwd.length > 16) {
                span.innerHTML = "<font color='red' size='2'>密码长度不能长于16</font>";
                document.getElementById("password").value = "";
                document.getElementById("password").focus();
                return false;
            } else {
                span.innerHTML = "<font color='green' size='2'>密码可用</font>";
                return true;
            }
        }

        function checkemail() {
            var email = document.getElementById("email").value;
            var span = document.getElementById("span_email");
            if (email == "" || email == null) {
                span.innerHTML = "<font color='red' size='2'>邮箱不能为空</font>";
                document.getElementById("email").value = "";
                document.getElementById("email").focus();
                return false;
            } else if (email.indexOf("@", 0) == -1) {
                span.innerHTML = "<font color='red' size='2'>邮箱需包含'@'符号</font>";
                document.getElementById("email").value = "";
                document.getElementById("email").focus();
                return false
            } else if (email.indexOf(".", 0) == -1) {
                span.innerHTML = "<font color='red' size='2'>邮箱需包含'.'符号</font>";
                document.getElementById("email").value = "";
                document.getElementById("email").focus();
                return false
            } else {
                span.innerHTML = "<font color='green' size='2'>邮箱可用</font>";
                return true;
            }
        }

        function checkphone() {
            var phone = document.getElementById("phone").value;
            var span = document.getElementById("span_phone");
            if (phone == "" || phone == null) {
                span.innerHTML = "<font color='red' size='2'>手机号不能为空</font>";
                document.getElementById("phone").value = "";
                document.getElementById("phone").focus();
                return false;
            } else if (phone.length > 11) {
                span.innerHTML = "<font color='red' size='2'>号码长度不符合要求</font>";
                document.getElementById("phone").value = "";
                document.getElementById("phone").focus();
                return false
            } else if (!/^\d+$/.test(phone)) {
                span.innerHTML = "<font color='red' size='2'>电话不能含除数字外的字符</font>";
                document.getElementById("phone").value = "";
                document.getElementById("phone").focus();
                return false
            } else {
                span.innerHTML = "<font color='green' size='2'>手机号可用</font>";
                return true;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">注   册</div>
        <div class="form-warpper">
            <form action="/Register.html" method="post">
                <input id="name" type="text" name="name" onblur="checkname()" placeholder="username"  class="input-item">
                <span id="span_name"></span>
                <input type="password"id="password"  name="password" placeholder="password"onblur="checkpwd()" class="input-item">
                <span id="span_pwd"></span>
                <input type="text"id="email"  name="email" placeholder="email" onblur="checkemail()"class="input-item">
                <span id="span_email"></span><input type="text"id="phone"  name="phone" onblur="checkphone()"placeholder="phone" class="input-item">
                <span id="span_phone"></span>

                <input type="submit"  value=" 注  册 " class="btn"/></form>
        </div>
        <br>
        <div class="msg">
            已有账号?<a href="/ToLogin.html">立即登录</a>
        </div>
    </div>
</div>
<%
    String info = (String) request.getAttribute("info1");
    if (info == null || info == "") {
        info = "";
    }
%>
<div style="position:absolute;top:250px;left:620px;margin-left: 20px;color:#6b6d71"><%=info%>
</div>


</body>
</html>

