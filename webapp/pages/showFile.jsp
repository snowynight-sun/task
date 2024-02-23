<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看文件</title>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<jsp:include page="left3.jsp"></jsp:include>
<div class="mainBox">
    <h2 style="text-align: center;">查看文件</h2>
        <table cellpadding="10px" align="center">
            <c:forEach items="${tasks}" varStatus="i" var="task" >
            <tr>
                <td>任务编号：${task.t_id}</td>
            </tr>
            <tr>
                <td><a href="${task.taskInfo}" download="${task.filename}">点击下载</a></td>
            </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
