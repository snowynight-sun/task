<%@ page import="com.springpro.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建项目</title>
    <link rel="stylesheet" type="text/css" href="../css/newProject.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="mainBox">
    <h2 style="text-align: center;">创建项目</h2>
    <form method="post" action="/project/addproject.html">`
        <table cellpadding="10px" align="center">
            <tr>
                <td class="td_left">组长id：${user.user_id}</td>
            </tr>
            <tr>
                <td class="td_left">项目名称：</td>
                <td class="td_mid"><input type="text" name="p_title" id="p_title" placeholder="请输入项目名称" required></td>
            </tr>
            <tr>
                <td class="td_left">项目描述：</td>
                <td class="td_mid"><textarea name="desct" id="desct" placeholder="请输入项目描述"></textarea></td>
            </tr>
            <tr>
                <td class="td_left">开始时间：</td>
                <td class="td_mid"><input type="datetime-local" name="s_t" id="s_t" placeholder="请选择开始时间" required></td>
            </tr>
            <tr>
                <td class="td_left">结束时间：</td>
                <td class="td_mid"><input type="datetime-local" name="e_t" id="e_t" placeholder="请选择结束时间" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="submit" class="btn_sub" value="提交">
                    <input type="reset" class="btn_sub" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>
</form>
<img style="width: 220px;
    position:absolute;
    bottom: 0px;
    right:20px" src="../img/深圳.png" >
</body>
</html>
