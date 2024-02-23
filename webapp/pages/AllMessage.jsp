<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有消息</title>
</head>
<body>
<table>
    <tr>
        <th>发件人</th>
        <th>内容</th>
    </tr>
    <c:forEach items="${messages}" var="m">
    <tr>
        <td>${m.in_name}</td>
        <td>${m.m_info}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>




