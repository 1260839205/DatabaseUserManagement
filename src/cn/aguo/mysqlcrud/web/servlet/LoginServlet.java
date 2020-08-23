package cn.aguo.mysqlcrud.web.servlet;

import cn.aguo.mysqlcrud.dao.impl.UserDaoImpl;
import cn.aguo.mysqlcrud.domain.LoginUser;
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
 * @Date 2020/8/15 13:17
 * @Email 1260839205@qq.com
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取本地生成的验证码
        Object checkcode_server = request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");

        //获取管理员登陆输入的账号和密码以及验证码,并且封装到LoginUser对象中
        Map<String, String[]> adminuser = request.getParameterMap();
        LoginUser loginuser = new LoginUser();
        try {
            BeanUtils.populate(loginuser,adminuser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        if (checkcode_server != null && checkcode_server.toString().equalsIgnoreCase(loginuser.getCheckcode())){

            UserDaoImpl udi = new UserDaoImpl();
            LoginUser loginUser = udi.loginUser(loginuser);

            if (loginUser == null){
                request.setAttribute("login_error","登陆失败，账号或者密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                request.getSession().setAttribute("user",loginUser);
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }else {
            request.setAttribute("login_error","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
