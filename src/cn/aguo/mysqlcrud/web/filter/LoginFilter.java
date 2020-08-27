package cn.aguo.mysqlcrud.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author 石成果
 * @Date 2020/8/27 10:24
 * @Email 1260839205@qq.com
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //2.获取用户请求资源的路径
        String URI = request.getRequestURI();

        //3.判断是否包含登陆相关资源
        if (URI.contains("/login.jsp") || URI.contains("/loginServlet") || URI.contains("/js/") || URI.contains("/css/") || URI.contains("/fonts/") || URI.contains("/checkCodeServlet")) {
            chain.doFilter(req, resp);
        }else {
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_error","您尚未登陆，请先登陆");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
