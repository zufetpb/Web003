<%@ page import="cn.edu.zufe.web003.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Jackie
  Date: 2020/11/27
  Time: 11:58
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
                <div class="card-header">修改用户信息</div>
                <div class="card-body">
                    <form action="UserUpdateServlet">
                        <p>id：<input type="text" name="id" value="<%=user.getId()%>" readonly="readonly"></p>
                        <p>姓名：<input type="text" name="userName" value="<%=user.getUserName()%>" maxlength="20"></p>
                        <p>密码：<input type="text" name="passWord" value="<%=user.getPassWord()%>" maxlength="20"></p>
                        <p>性别：<input type="text" name="sex" value="<%=user.getSex()%>" maxlength="20"></p>
                        <p>专业：<input type="text" name="major" value="<%=user.getMajor()%>" maxlength="20"></p>
                        <input type="submit" value="修改">
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../right.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
