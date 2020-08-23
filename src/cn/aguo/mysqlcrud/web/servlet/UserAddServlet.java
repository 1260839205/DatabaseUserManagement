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
import java.util.Map;

/**
 * @Author 石成果
 * @Date 2020/8/14 10:11
 * @Email 1260839205@qq.com
 */
@WebServlet("/userAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //设置编码
            request.setCharacterEncoding("utf-8");
            //获取用户输入信息
            Map<String, String[]> user = request.getParameterMap();

            //创建User对象
            User useradd = new User();

            //封装Map的键值
            BeanUtils.populate(useradd,user);

            //获取用户操作对象
            UserService us = new UserServiceImpl();

            //增加数据
            us.add(useradd);

            //重定向到查询页面
            response.sendRedirect(request.getContextPath()+"/userListServlet");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
