<%@ page import="cn.edu.zufe.web003.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Jackie
  Date: 2020/11/11
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean flag = false;
    User user = new User();
    if(session.getAttribute("user") != null) {
        flag = true;
        user = (User) session.getAttribute("user");
    }
    String href = String.format("GetUserServlet?id=%s&type=detail", session.getAttribute("userId"));
%>
<div class="col-md-2">
    <div class="list-group">
        <a href="SeatListServlet" class="list-group-item list-group-item-action active">首页</a>
        <a id="login" href="login.jsp" class="list-group-item list-group-item-action">登录</a>
        <a id="user" href="#" class="list-group-item list-group-item-action" style="display: none;"></a>
        <a id="logout" href="logout.jsp" class="list-group-item list-group-item-action" style="display: none;">注销</a>
        <a id="register" href="jsp/register.jsp" class="list-group-item list-group-item-action">注册</a>
        <a href="UserListServlet?keyword=" class="list-group-item list-group-item-action">用户列表</a>
    </div>
</div>
<script>
    var flag = <%=flag%>;
    if(flag == true) {
        document.getElementById("login").style.display="none";
        document.getElementById("register").style.display="none";
        document.getElementById("logout").style.display="block";
        document.getElementById("user").style.display="block";
        document.getElementById("user").innerText='<%=user.getUserName()%>';
        document.getElementById("user").setAttribute("href", '<%=href%>');
    }
</script>

