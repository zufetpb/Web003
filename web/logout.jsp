<%--
  Created by IntelliJ IDEA.
  User: Jackie
  Date: 2021/1/10
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    session.invalidate();
    request.getRequestDispatcher("/login.jsp").forward(request, response);
%>
<body>
</body>
</html>
