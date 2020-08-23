<%--
  Created by IntelliJ IDEA.
  User: 石成果
  Date: 2020/8/13
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-3.5.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateServlet" method="post">
            <input type="hidden" name="id" value="${requestScope.user.id}">
          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${requestScope.user.name}" readonly="readonly" placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${requestScope.user.gender == '男'}">
                  <input type="radio" name="gender" value="男"  checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>
              <c:if test="${requestScope.user.gender == '女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女" checked />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  value="${requestScope.user.age}" name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="hometown" id="address" class="form-control" >
                 <c:if test="${requestScope.user.hometown == '广东'}">
                     <option value="广东" selected>广东</option>
                     <option value="广西">广西</option>
                     <option value="湖南">湖南</option>
                     <option value="湖北">湖北</option>
                     <option value="浙江">浙江</option>
                     <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${requestScope.user.hometown == '广西'}">
                     <option value="广东">广东</option>
                     <option value="广西" selected>广西</option>
                     <option value="湖南">湖南</option>
                     <option value="湖北">湖北</option>
                     <option value="浙江">浙江</option>
                     <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${requestScope.user.hometown == '湖南'}">
                     <option value="广东">广东</option>
                     <option value="广西">广西</option>
                     <option value="湖南" selected>湖南</option>
                     <option value="湖北">湖北</option>
                     <option value="浙江">浙江</option>
                     <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${requestScope.user.hometown == '湖北'}">
                     <option value="广东">广东</option>
                     <option value="广西">广西</option>
                     <option value="湖南">湖南</option>
                     <option value="湖北" selected>湖北</option>
                     <option value="浙江">浙江</option>
                     <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${requestScope.user.hometown == '浙江'}">
                     <option value="广东">广东</option>
                     <option value="广西">广西</option>
                     <option value="湖南">湖南</option>
                     <option value="湖北">湖北</option>
                     <option value="浙江" selected>浙江</option>
                     <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${requestScope.user.hometown == '上海'}">
                     <option value="广东">广东</option>
                     <option value="广西">广西</option>
                     <option value="湖南">湖南</option>
                     <option value="湖北">湖北</option>
                     <option value="浙江">浙江</option>
                     <option value="上海" selected>上海</option>
                 </c:if>
            </select>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" value="${requestScope.user.qq}" name="qq" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" value="${requestScope.user.email}" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>