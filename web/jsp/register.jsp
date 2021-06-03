<%--
  Created by IntelliJ IDEA.
  User: TPB
  Date: 2020/9/30
  Time: 10:05
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
    <jsp:include page="../nav.jsp"></jsp:include>
    <div class="row" style="margin-top: 10px;">
        <jsp:include page="../left.jsp"></jsp:include>
        <div class="col-md">
            <div class="card">
                <div class="card-header">用户注册</div>
                <div class="card-body">
                    <form method="post" action="RegisterServlet">
                        <p>姓名：<input type="text" name="userName"></p>
                        <p>密码：<input type="password" name="passWord"></p>
                        <p>性别：
                            <input type="radio" name="sex" value="男">男
                            <input type="radio" name="sex" value="女">女
                        </p>
                        <p>专业：
                            <select name="major">
                                <option name="软件工程">软件工程</option>
                                <option name="电子商务">电子商务</option>
                                <option name="计算机">计算机</option>
                                <option name="信息管理">信息管理</option>
                                <option name="人工智能">人工智能</option>
                            </select>
                        </p>
                        <p><input type="submit" value="注册"></p>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../right.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
