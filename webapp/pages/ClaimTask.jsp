<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>未认领任务列表</title>
    <link rel="stylesheet" type="text/css" href="../css/WeiRenLing.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<jsp:include page="left2.jsp"></jsp:include>

<div class="mainBox">
    <div class="maintitle">
        待认领任务列表
        <svg t="1625196429462" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7446" width="200" height="200"><path d="M524.202667 487.381333a17.408 17.408 0 0 1-24.405334 0L226.261333 218.325333a17.408 17.408 0 0 0-24.448 0l-25.941333 25.514667a17.493333 17.493333 0 0 0 0 24.917333l323.925333 318.549334a17.408 17.408 0 0 0 24.405334 0L848.128 268.8a17.493333 17.493333 0 0 0 0-24.917333l-25.941333-25.514667a17.408 17.408 0 0 0-24.448 0l-273.493334 269.056z" p-id="7447" fill="#2c2c2c"></path><path d="M524.202667 705.706667a17.408 17.408 0 0 1-24.405334 0l-273.536-269.013334a17.408 17.408 0 0 0-24.448 0l-25.941333 25.472a17.493333 17.493333 0 0 0 0 24.917334l323.925333 318.592a17.408 17.408 0 0 0 24.405334 0l323.925333-318.549334a17.493333 17.493333 0 0 0 0-24.96l-25.941333-25.472a17.408 17.408 0 0 0-24.448 0l-273.493334 269.013334z" p-id="7448" fill="#67c4d6"></path></svg>
    </div>
    <div class="maintable">
        <table border="0" cellspacing="0" cellpadding="0">
            <tr>
                <th style="padding-left: 40px;padding-right: 180px;">任务编号</th>
                <th style="padding-right: 180px;">任务名称</th>
                <th style="padding-right: 120px;">操作</th>
            </tr>
            <c:forEach items="${claimTaskList}" varStatus="i" var="task">
            <tr>
                <td style="padding-left: 40px;">${task.t_id}</td>
                <td>${task.t_title}</td>
                <td><form action="/task/ClaimTask.html">
                    <input type="text" name="t_id" value="${task.t_id}" hidden>
                    <input type="text" name="p_id" value="${curpro.p_id}" hidden>
                    <input type="submit" value="认领">
                </form></td>
            </c:forEach>
            </tr>
        </table>
    </div>
</div>
<img style="width: 280px;
    position:absolute;
    bottom: 0px;
    right:20px" src="../img/南京.png" >
</body>
</html>
