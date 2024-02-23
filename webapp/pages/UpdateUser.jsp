
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的资料</title>
    <link rel="stylesheet" type="text/css" href="../css/updateU.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="mainBox">
    <h2 style="text-align: center;">个人资料</h2>
    <form action="/updateUser.html" method="post">
        <table cellpadding="10px" align="center">
        <tr>
            <td>id：</td>
            <td><input type="text" name="user_id" id="user_id" readonly value="${user.user_id}"/></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name" id="name" readonly value="${user.name}"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password" value="${user.password}" ></td>
        </tr>
        <tr>
            <td>email：</td>
            <td><input type="email" name="email" id="email" value="${user.email}" ></td>
        </tr>
        <tr>
            <td>phone：</td>
            <td><input type="tel" name="phone" id="phone" value="${user.phone}" ></td>
        </tr>
        <tr>
            <td colspan="2" align="center" >
                <input type="submit" class="btn_sub" value="确认修改">
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
