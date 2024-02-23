<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${user.name}
<a href="/ToUpdateUser.html" >修改</a>
<a href="/team/GetAccepteUser.html">展示可邀请的成员</a>
<a href="/message/Unread.html">未读消息</a>
<a href="/message/History.html">历史消息</a>
<a href="/message/MyMessage.html">所有消息</a>

</body>
</html>
