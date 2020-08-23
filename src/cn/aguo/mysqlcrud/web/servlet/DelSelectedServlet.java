package cn.aguo.mysqlcrud.web.servlet;

import cn.aguo.mysqlcrud.service.UserService;
import cn.aguo.mysqlcrud.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 石成果
 * @Date 2020/8/23 10:18
 * @Email 1260839205@qq.com
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有选中的User的Id
        String[] ids = request.getParameterValues("uid");

        //创建UserService 调用其中deleteUsers方法删除选中的数据
        UserService us = new UserServiceImpl();
        us.deleteUsers(ids);

        //重定向到UserListServlet查询所有User信息
        response.sendRedirect(request.getContextPath()+"/userListServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
