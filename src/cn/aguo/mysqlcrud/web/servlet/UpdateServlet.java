package cn.aguo.mysqlcrud.web.servlet;

import cn.aguo.mysqlcrud.domain.User;
import cn.aguo.mysqlcrud.service.UserService;
import cn.aguo.mysqlcrud.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author 石成果
 * @Date 2020/8/14 15:04
 * @Email 1260839205@qq.com
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //指定字符编码
        request.setCharacterEncoding("utf-8");

        //获取数据并封装到User类中
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserService里的update方法
        UserService us = new UserServiceImpl();
        us.update(user);

        //重定向到UserListServlet中重新查询数据
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
