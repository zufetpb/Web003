<%--
  Created by IntelliJ IDEA.
  User: TPB
  Date: 2020/9/30
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>座位预约系统</title>
    <base href="<%=String.format("%s://%s:%d%s/",request.getScheme(),request.getServerName(),request.getServerPort(),request.getContextPath())%>">
    <link rel="stylesheet" href="bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <script src="bootstrap-4.4.1-dist/jquery.min.js"></script>
    <script src="bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-4.4.1-dist/popper.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="nav.jsp"></jsp:include>
    <div class="row" style="margin-top: 10px;">
        <jsp:include page="left.jsp"></jsp:include>
        <jsp:include page="center.jsp"></jsp:include>
        <jsp:include page="right.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
