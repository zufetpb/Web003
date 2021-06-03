<%--
  Created by IntelliJ IDEA.
  User: TPB
  Date: 2020/10/21
  Time: 9:48
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
                <div class="card-header">网站地址二维码</div>
                <div class="card-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm">
                                <img type="image" src="${pageContext.request.contextPath}/QrcodeServlet" id="codeImage" name="codeImage"
                                     style="cursor:pointer;height: 300px;width: 300px;" class="rounded mx-auto d-block"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../right.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
