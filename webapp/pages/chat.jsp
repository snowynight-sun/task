<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天室</title>
    <link rel="stylesheet" type="text/css" href="../css/chat.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<jsp:include page="left2.jsp"></jsp:include>
<div class="mainBox">
    <div class="maintitle">
        &nbsp;&nbsp;&nbsp;聊天室
        <svg t="1625196429462" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7446" width="200" height="200"><path d="M524.202667 487.381333a17.408 17.408 0 0 1-24.405334 0L226.261333 218.325333a17.408 17.408 0 0 0-24.448 0l-25.941333 25.514667a17.493333 17.493333 0 0 0 0 24.917333l323.925333 318.549334a17.408 17.408 0 0 0 24.405334 0L848.128 268.8a17.493333 17.493333 0 0 0 0-24.917333l-25.941333-25.514667a17.408 17.408 0 0 0-24.448 0l-273.493334 269.056z" p-id="7447" fill="#2c2c2c"></path><path d="M524.202667 705.706667a17.408 17.408 0 0 1-24.405334 0l-273.536-269.013334a17.408 17.408 0 0 0-24.448 0l-25.941333 25.472a17.493333 17.493333 0 0 0 0 24.917334l323.925333 318.592a17.408 17.408 0 0 0 24.405334 0l323.925333-318.549334a17.493333 17.493333 0 0 0 0-24.96l-25.941333-25.472a17.408 17.408 0 0 0-24.448 0l-273.493334 269.013334z" p-id="7448" fill="#67c4d6"></path></svg>
    </div>
    <div class="talk_con">
        <div class="talk_show" id="words">
            <c:forEach items="${newsList}" var="news" varStatus="i">
                <c:if test="${news.user_name != user.name}">
                    <div class="atalk">${news.user_name}&nbsp;<span id="asay">${news.info}</span></div>
                </c:if>
                <c:if test="${news.user_name eq user.name}">
                    <div class="btalk"><span id="bsay">${news.info}</span>&nbsp;${news.user_name}</div>
                </c:if>
            </c:forEach>
        </div>
        <form action="/SendNews.html">
            <div class="talk_input">
                <input type="text" name="info" id="chatinfo">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="发送" class="talk_sub" id="talksub">
            </div>
        </form>
    </div>
</div>
</body>
</html>
