<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看我的项目</title>
    <link rel="stylesheet" type="text/css" href="../css/myProject.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<div class="leftbox">
    <div class="leftbox1">
        <a href="/project/projectlist.html">
            <svg t="1625300648887" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                 p-id="1527" width="200" height="200">
                <path d="M80.45 279.41L512.8 499.38l432.35-219.97L512.8 67.03 80.45 279.41z m60.68 341.33l-91.02-45.51C19.77 560.06 4.6 537.31 4.6 506.97c0-30.34 15.17-53.1 45.51-68.26l91.02-45.51-91.02-45.51C12.18 332.51-2.99 287 12.18 249.07c7.58-15.17 22.76-30.34 30.34-30.34L474.88 6.35c22.76-7.58 45.51-7.58 68.27 0L975.5 218.73c37.92 15.17 53.09 60.68 30.34 98.6-7.58 15.17-22.75 30.34-30.34 30.34l-91.02 45.51 83.44 37.93c37.92 15.17 53.09 37.92 53.09 75.85 0 30.34-15.17 60.68-53.09 75.85l-83.44 37.93 83.44 37.93c37.92 15.17 53.09 37.92 53.09 75.85 0 30.34-15.17 60.68-53.09 75.85l-417.18 204.8c-7.59 7.58-22.76 7.58-37.93 7.58s-22.76 0-37.93-7.58L42.52 802.79C12.18 787.62 4.6 764.86 4.6 734.52c0-30.34 15.17-53.1 45.51-68.27l91.02-45.51z m83.44 45.51L80.45 734.52 512.8 954.49l432.35-212.38-144.12-68.27-250.3 121.36c-7.59 7.58-22.76 7.58-37.93 7.58s-22.76 0-37.93-7.58l-250.3-128.95zM801.03 438.7l-250.3 121.36c-22.76 7.59-45.51 7.59-68.27 0L224.57 438.7 80.45 506.97 512.8 726.93l432.35-219.97-144.12-68.26z m0 0"
                      p-id="1528" fill="#ffffff"></path>
            </svg>
            我的项目
        </a>
    </div>
</div>
<div class="mainBox">
    <div class="maintitle">
        我的项目
        <svg t="1625196429462" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
             p-id="7446" width="200" height="200">
            <path d="M524.202667 487.381333a17.408 17.408 0 0 1-24.405334 0L226.261333 218.325333a17.408 17.408 0 0 0-24.448 0l-25.941333 25.514667a17.493333 17.493333 0 0 0 0 24.917333l323.925333 318.549334a17.408 17.408 0 0 0 24.405334 0L848.128 268.8a17.493333 17.493333 0 0 0 0-24.917333l-25.941333-25.514667a17.408 17.408 0 0 0-24.448 0l-273.493334 269.056z"
                  p-id="7447" fill="#2c2c2c"></path>
            <path d="M524.202667 705.706667a17.408 17.408 0 0 1-24.405334 0l-273.536-269.013334a17.408 17.408 0 0 0-24.448 0l-25.941333 25.472a17.493333 17.493333 0 0 0 0 24.917334l323.925333 318.592a17.408 17.408 0 0 0 24.405334 0l323.925333-318.549334a17.493333 17.493333 0 0 0 0-24.96l-25.941333-25.472a17.408 17.408 0 0 0-24.448 0l-273.493334 269.013334z"
                  p-id="7448" fill="#67c4d6"></path>
        </svg>
    </div>
    <div class="maintable">
        <table border="0" cellspacing="0" cellpadding="0">
            <tr>
                <th style="padding-left: 20px;padding-right: 20px;">项目id</th>
                <th style="padding-left: 20px;padding-right: 20px;">项目名称</th>
                <th style="padding-right: 30px;">项目描述</th>
                <th style="padding-right: 70px;">项目任务</th>
                <th style="padding-right: 70px;">项目文件</th>
                <th style="padding-right: 70px;">修改</th>
            </tr>
            <c:forEach items="${myprojects}" varStatus="i" var="p">
                <tr>
                        <%--                <td>111</td>--%>
                    <td style="padding-left: 40px;">${p.p_id}</td>
                    <td style="padding-left: 40px;">${p.p_title}</td>
                    <td>${p.desct}</td>
                    <td style="padding-top: 10px">
                        <form action="/task/findtask.html">
                            <input type="text" name="p_id" value="${p.p_id}" hidden>
                            <input type="submit" value="查看任务">
                        </form>
                    </td>
                    <td style="padding-top: 10px">
                        <form action="/showFiles.html" >
                            <input type="text" name="p_id" value="${p.p_id}" hidden>
                            <input type="submit" value="查看文件"></form>
                        </form>
                    </td>
                    <td style="padding-top: 10px">
                        <form action="/project/to_updateproject.html">
                            <input type="text" name="p_id" value="${p.p_id}" hidden>
                            <input type="submit" value="修改"></form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<img style="width: 300px;
    position:absolute;
    bottom: 0px;
    right:20px" src="../img/杭州.png">
</body>
</html>
