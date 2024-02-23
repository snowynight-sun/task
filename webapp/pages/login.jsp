<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <script type="text/javascript">
        function onload(){
            var info=document.getElementById("infoo").value;
            if(info=="已注销"){
                alert(info);
            }
            else if(info=="用户名密码不正确")
            {
                alert(info);
            }
        }
    </script>
</head>
<body>
<input type="text" style="display: none" id="infoo" value="${info}">
<div class="container">
    <div class="login-wrapper">
        <div class="header"> 登 录 </div>
        <br><br><br>
        <div class="form-warpper">
            <form action="/login.html" method="post">
                <input type="text" name="name" placeholder="username" class="input-item">
                <input type="password" name="password" placeholder="password" class="input-item">
                <input type="submit" class="btn" value="登 录" class="submit"/></form>
        </div>
        <div class="msg">
            没有账号？<a href="/ToRegister.html">注 册</a>
        </div>
    </div>
</div>
<div style="position:absolute;top:180px;left:450px;margin-left: 20px;color:#6b6d71">${info}</div>
</body>
</html>