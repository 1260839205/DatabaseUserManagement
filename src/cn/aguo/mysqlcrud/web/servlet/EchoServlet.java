package cn.aguo.mysqlcrud.web.servlet;

import cn.aguo.mysqlcrud.domain.User;
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
 * @Date 2020/8/22 11:11
 * @Email 1260839205@qq.com
 */
@WebServlet("/echoServlet")
public class EchoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");

        //创建UserService对象查询该id的用户信息
        UserService us = new UserServiceImpl();

        User user = us.inquire(id);

        //将查询得到的数据存入request域中，转发到update.jsp
        request.setAttribute("user",user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
