<%--
  Created by IntelliJ IDEA.
  User: Jackie
  Date: 2020/11/12
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <div class="card-header">用户列表</div>
                <div class="card-body">
                    <table class="table table-dark">
                        <thead>
                        <tr>
                            <th scope="col">序号</th>
                            <th scope="col">姓名</th>
                            <th scope="col">性别</th>
                            <th scope="col">专业</th>
                            <th scope="col">动作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="items">
                            <tr>
                                <td scope="col"><c:out value="${items.id}"></c:out></td>
                                <td scope="col"><c:out value="${items.userName}"></c:out></td>
                                <td scope="col"><c:out value="${items.sex}"></c:out></td>
                                <td scope="col"><c:out value="${items.major}"></c:out></td>
                                <td scope="col">
                                    <a type="button" href="GetUserServlet?id=${items.id}&type=detail" class="btn btn-primary">详情</a>
                                    <a type="button" href="GetUserServlet?id=${items.id}&type=update" class="btn btn-primary">修改用户信息</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
