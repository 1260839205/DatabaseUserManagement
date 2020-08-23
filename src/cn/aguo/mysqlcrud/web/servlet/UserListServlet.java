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
import java.util.List;

/**
 * @Author 石成果
 * @Date 2020/8/14 9:28
 * @Email 1260839205@qq.com
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService查询所有用户
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

        //查询用户数量
        int count = service.count();


        //2.将数据存到request域中
        request.setAttribute("users",users);
        request.setAttribute("count",count);

        //3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
