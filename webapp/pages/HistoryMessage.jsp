<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史消息</title>
    <link rel="stylesheet" type="text/css" href="../css/message.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="mainBox">
    <div class="maintitle">
        历史消息
        <svg t="1625196429462" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7446" width="200" height="200"><path d="M524.202667 487.381333a17.408 17.408 0 0 1-24.405334 0L226.261333 218.325333a17.408 17.408 0 0 0-24.448 0l-25.941333 25.514667a17.493333 17.493333 0 0 0 0 24.917333l323.925333 318.549334a17.408 17.408 0 0 0 24.405334 0L848.128 268.8a17.493333 17.493333 0 0 0 0-24.917333l-25.941333-25.514667a17.408 17.408 0 0 0-24.448 0l-273.493334 269.056z" p-id="7447" fill="#2c2c2c"></path><path d="M524.202667 705.706667a17.408 17.408 0 0 1-24.405334 0l-273.536-269.013334a17.408 17.408 0 0 0-24.448 0l-25.941333 25.472a17.493333 17.493333 0 0 0 0 24.917334l323.925333 318.592a17.408 17.408 0 0 0 24.405334 0l323.925333-318.549334a17.493333 17.493333 0 0 0 0-24.96l-25.941333-25.472a17.408 17.408 0 0 0-24.448 0l-273.493334 269.013334z" p-id="7448" fill="#67c4d6"></path></svg>
    </div>
    <div class="maincontent">
        <a style="margin-left: 600px" href="/toHome.html" style="text-decoration:none;margin-left: 780px;">
            <svg t="1625318878804" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6639" width="200" height="200"><path d="M622.650611 284.901749 447.745069 284.901749 447.745069 142.823869 63.980685 334.705038l383.76336 191.882192L447.744046 384.834762l189.391465 0c149.914358 0 224.855164 62.789045 224.855164 188.368158 0 129.928165-77.435627 194.876386-232.338602 194.876386L187.952184 768.079306l0 99.93199L634.146433 868.011296c211.184817 0 316.777737-95.104031 316.777737-285.311071C950.924169 384.178823 841.510224 284.901749 622.650611 284.901749z" p-id="6640"></path></svg>
            返回
        </a>
        <div class="message">
            <table>
                <tr>
                    <td>${info}</td>
                </tr>
    <c:forEach items="${messages}" varStatus="i"  var="m">
                <tr><td>发布时间：${m.m_time}</td></tr>
                <tr><td>发件人：${m.in_name}</td></tr>
                <tr><td>收件人：${m.bein_name}</td></tr>
                <tr><td>内容：${m.m_info}</td></tr>
                <tr></tr><tr></tr><tr></tr><tr></tr>
    </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>