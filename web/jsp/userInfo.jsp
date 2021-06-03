<%@ page import="cn.edu.zufe.web003.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: TPB
  Date: 2020/9/30
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Web开发技术</title>
    <base href="<%=String.format("%s://%s:%d%s/",request.getScheme(),request.getServerName(),request.getServerPort(),request.getContextPath())%>">
    <link rel="stylesheet" href="bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <script src="bootstrap-4.4.1-dist/jquery.min.js"></script>
    <script src="bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-4.4.1-dist/popper.min.js"></script>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<div class="container-fluid">
    <jsp:include page="../nav.jsp"></jsp:include>
    <div class="row" style="margin-top: 10px;">
        <jsp:include page="../left.jsp"></jsp:include>
        <div class="col-md">
            <div class="card">
                <div class="card-header">用户注册</div>
                <div class="card-body">
                    <form>
                        <p>姓名：<%=user.getUserName()%></p>
                        <p>密码：<%=user.getPassWord()%></p>
                        <p>性别：<%=user.getSex()%></p>
                        <p>专业：<%=user.getMajor()%></p>
                        <p>使用座位：<%=user.isUsingSeat()%></p>
                        <p>座位编号：<%=user.getSeatId()%></p>
                        <p>离座：<%=user.isLeft()%></p>
                        <p>离座时间：<%=user.getTimeLeft()%></p>
                        <p>违规次数：<%=user.getViolationCounts()%></p>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../right.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
