
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
    <link rel="stylesheet" type="text/css" href="../css/updateU.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<jsp:include page="left3.jsp"></jsp:include>
<div class="mainBox">
    <h2 style="text-align: center;">上传文件</h2>
    <form action="/AddFile.html" method="post" enctype="multipart/form-data">
        <table cellpadding="10px" align="center">
            <tr>
                <td><input type="file" name="fname"></td>
            </tr>
            <tr>
                <td><input type="submit"  value="上传文件"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
