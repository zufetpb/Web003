<%--
  Created by IntelliJ IDEA.
  User: Jackie
  Date: 2020/11/11
  Time: 11:30
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
<div class="container-fluid">
    <jsp:include page="nav.jsp"></jsp:include>
    <div class="row" style="margin-top: 10px;">
        <jsp:include page="left.jsp"></jsp:include>
        <div class="col-md">
            <div class="card">
                <div class="card-header">用户登录</div>
                <div class="card-body">
                    <form action="LoginServlet">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label text-danger">${info}</label>
                        </div>
                        <div class="form-group row">
                            <label for="userName" class="col-sm-2 col-form-label">用户名</label>
                            <div class="col-sm">
                                <input type="text" class="form-control" name="userName" id="userName" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="passWord" class="col-sm-2 col-form-label">密码</label>
                            <div class="col-sm">
                                <input type="password" class="form-control" name="passWord" id="passWord" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="verifyCode" class="col-sm-2 col-form-label">验证码</label>
                            <img type="image" src="VerifyCodeServlet" id="codeImage" name="codeImage" style="cursor:pointer;"/>
                            <div class="col-sm">
                                <input type="text" class="form-control" name="verifyCode" id="verifyCode" placeholder="验证码">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">登录</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="right.jsp"></jsp:include>
    </div>
</div>
</body>
</html>