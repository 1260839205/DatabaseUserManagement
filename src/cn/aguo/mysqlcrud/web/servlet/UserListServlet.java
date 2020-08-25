package cn.aguo.mysqlcrud.web.servlet;

import cn.aguo.mysqlcrud.domain.PageBean;
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
import java.util.Map;

/**
 * @Author 石成果
 * @Date 2020/8/14 9:28
 * @Email 1260839205@qq.com
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置获取数据的编码
        request.setCharacterEncoding("utf-8");

        //获取页面显示条数，以及页码
        String currentPageNumber = request.getParameter("currentPageNumber");
        String rows = request.getParameter("rows");
        Map<String, String[]> parame = request.getParameterMap();

        //设置未传参的默认值
        if (currentPageNumber == null || "".equals(currentPageNumber)){
            currentPageNumber = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }

        //1.调用UserService查询所有用户
        UserService service = new UserServiceImpl();
        PageBean<User> users = service.findUserByPage(currentPageNumber,rows,parame);


        //2.将数据存到request域中
        request.setAttribute("parame",parame);
        request.setAttribute("users",users);

        //3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
