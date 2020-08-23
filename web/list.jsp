<%--
  Created by IntelliJ IDEA.
  User: 石成果
  Date: 2020/8/13
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.5.1.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function () {
            var uids = document.getElementsByName("uid");
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除吗？")){
                    var flag = false;
                    for (var i = 0; i < uids.length ; i++){
                        if (uids[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    if (flag){
                        document.getElementById("form").submit();
                    }
                }
            }
            var selectedAll = document.getElementById("selectedAll");
            selectedAll.onclick = function () {
                if (selectedAll.checked){
                    for (var i = 0 ; i < uids.length ; i++){
                        uids[i].checked = true;
                    }
                }
                else {
                    for (var i = 0 ; i < uids.length ; i++){
                        uids[i].checked = false;
                    }
                }

            }
        }
        function deleteUser(id) {
            if (confirm("您确定要删除吗？")){
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id="+id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left; margin-bottom: 10px">
        <form class="form-inline" action="${pageContext.request.contextPath}/complexServlet" method="get">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="输入需要查询的姓名">
            </div>
            <div class="form-group">
                <label for="hometown">籍贯</label>
                <input type="email" class="form-control" id="hometown" name="hometown" placeholder="输入需要查询的籍贯">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="输入需要查询的邮箱">
            </div>
            <button type="submit" class="btn btn-default" id="inquire">查询</button>
        </form>
    </div>
    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary"  id="delSelected" href="javascript:void(0);">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/delSelectedServlet" method="post" id="form">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="selectedAll" ></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="user" varStatus="s">
        <tr>
            <td><input type="checkbox" name="uid" value="${user.id}"></td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.hometown}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/echoServlet?id=${user.id}" id="update">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    </form>
    <nav aria-label="...">
        <ul class="pagination">
            <li class="disabled">
      <span>
        <span aria-hidden="true">&laquo;</span>
      </span>
            </li>
            <li class="active">
                <span>1 <span class="sr-only">(current)</span></span>
            </li>
            <li class="">
                <span>2 <span class="sr-only">(current)</span></span>
            </li>
            <li class="">
                <span>3 <span class="sr-only">(current)</span></span>
            </li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px;">
                <strong style="margin-left: 15px">
                    共${requestScope.count}条数据，共3页
                </strong>
            </span>
        </ul>
    </nav>
</div>
</body>
</html>
