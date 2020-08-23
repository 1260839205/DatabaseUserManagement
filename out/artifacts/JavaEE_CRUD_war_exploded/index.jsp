<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 石成果
  Date: 2020/8/13
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>首页</title>

  <!-- 1. 导入CSS的全局样式 -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
  <script src="js/jquery-3.5.1.js"></script>
  <!-- 3. 导入bootstrap的js文件 -->
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body>
<c:if test="${sessionScope.user.username != null}">
<div style="color: #2aabd2; font-size: 30px">
  ${sessionScope.user.username}，欢迎登陆！！
</div>
<div align="center">
  <a
          href="${pageContext.request.contextPath}/userListServlet" style="text-decoration:none;font-size:33px">查询所有用户信息
  </a>
</div>
</c:if>
<c:if test="${sessionScope.user.username == null}">
  <%
    response.sendRedirect(request.getContextPath()+"/login.jsp");
  %>
</c:if>
</body>
</html>
