<%@ page import="cn.edu.zufe.web003.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Jackie
  Date: 2020/11/11
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md">
    <div class="card">
        <div class="card-header">座位列表</div>
        <div class="card-body">
            <div class="alert alert-primary" role="alert">
                ${info}
            </div>
            <c:forEach items="${seats}" var="items">
                <div style="width: 33%; float: left;">
                    <div style="width: 80%; float: left;">
                        <c:choose>
                            <c:when test="${items.beUsing == false}">
                                <img src="images/seat1.png" class="img-thumbnail">
                            </c:when>
                            <c:otherwise>
                                <img src="images/seat.png" class="img-thumbnail">
                            </c:otherwise>
                        </c:choose>

                        <p>编号: <c:out value=" ${items.id}"></c:out></p>
                        <p>使用中: <c:out value=" ${items.beUsing}"></c:out></p>
                        <p>用户名: <c:out value=" ${items.userName}"></c:out></p>
<%--                        <p><button>座位详情</button></p>--%>
                    </div>
                    <div>
                        <c:choose>
                            <c:when test="${items.beUsing == false}">
                                <a type="button" href="OrderSeatServlet?id=${items.id}" class="btn btn-primary">预约</a>
                            </c:when>
                            <c:when test="${items.userId == sessionScope.user.id}">
                                <a type="button" href="ReturnSeatServlet?id=${items.id}" class="btn btn-primary">归还</a>
                                <a type="button" href="#?id=${items.id}" class="btn btn-primary">离座</a>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
