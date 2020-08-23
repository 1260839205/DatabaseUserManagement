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
 * @Date 2020/8/16 16:25
 * @Email 1260839205@qq.com
 */
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");

        //获取需要删除的id
        String id = request.getParameter("id");

        //调用UserService对象中的delete方法
        UserService us = new UserServiceImpl();
        us.delete(id);

        //重定向到UserListServlet中重新查询数据
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
