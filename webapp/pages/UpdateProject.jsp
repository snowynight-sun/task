<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改项目</title>
    <link rel="stylesheet" type="text/css" href="../css/newProject.css"/>
</head>
<body>
<jsp:include page="navigator.jsp"></jsp:include>
<div class="leftbox">
    <div class="leftbox1">
        <a href="/project/projectlist.html">
            <svg t="1625300648887" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1527" width="200" height="200"><path d="M80.45 279.41L512.8 499.38l432.35-219.97L512.8 67.03 80.45 279.41z m60.68 341.33l-91.02-45.51C19.77 560.06 4.6 537.31 4.6 506.97c0-30.34 15.17-53.1 45.51-68.26l91.02-45.51-91.02-45.51C12.18 332.51-2.99 287 12.18 249.07c7.58-15.17 22.76-30.34 30.34-30.34L474.88 6.35c22.76-7.58 45.51-7.58 68.27 0L975.5 218.73c37.92 15.17 53.09 60.68 30.34 98.6-7.58 15.17-22.75 30.34-30.34 30.34l-91.02 45.51 83.44 37.93c37.92 15.17 53.09 37.92 53.09 75.85 0 30.34-15.17 60.68-53.09 75.85l-83.44 37.93 83.44 37.93c37.92 15.17 53.09 37.92 53.09 75.85 0 30.34-15.17 60.68-53.09 75.85l-417.18 204.8c-7.59 7.58-22.76 7.58-37.93 7.58s-22.76 0-37.93-7.58L42.52 802.79C12.18 787.62 4.6 764.86 4.6 734.52c0-30.34 15.17-53.1 45.51-68.27l91.02-45.51z m83.44 45.51L80.45 734.52 512.8 954.49l432.35-212.38-144.12-68.27-250.3 121.36c-7.59 7.58-22.76 7.58-37.93 7.58s-22.76 0-37.93-7.58l-250.3-128.95zM801.03 438.7l-250.3 121.36c-22.76 7.59-45.51 7.59-68.27 0L224.57 438.7 80.45 506.97 512.8 726.93l432.35-219.97-144.12-68.26z m0 0" p-id="1528" fill="#ffffff"></path></svg>
            我的项目
        </a>
    </div>
</div>
<div class="mainBox">
    <h2 style="text-align: center;">修改项目</h2>
    <form method="post" action="/project/updateproject.html">
        <table cellpadding="10px" align="center">
            <tr>
                <td class="td_left">组长id：${curpro.leader_id}</td>
            </tr>
            <tr>
                <td class="td_left">项目名称：</td>
                <td class="td_mid"><input type="text" name="title" id="title" value="${curpro.p_title}"></td>
            </tr>
            <tr>
                <td class="td_left">项目描述：</td>
                <td class="td_mid"><input type="text" name="desc" id="desc" value="${curpro.desct}"></td>
            </tr>
            <tr>
                <td class="td_left">开始时间：</td>
                <td class="td_mid"><input type="datetime-local" name="s_t" id="s_t" value="${curpro.s_t}"></td>
            </tr>
            <tr>
                <td class="td_left">结束时间：</td>
                <td class="td_mid"><input type="datetime-local" name="e_t" id="e_t" value="${curpro.e_t}"></td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="submit" class="btn_sub" value="提交">&nbsp;&nbsp;
                    <input type="reset" class="btn_sub" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>
</form>
</body>
</html>
