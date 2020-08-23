package cn.aguo.mysqlcrud.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Author 石成果
 * @Date 2020/8/23 17:55
 * @Email 1260839205@qq.com
 */
@WebServlet("/complexServlet")
public class ComplexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置获取数据的编码
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> values = request.getParameterMap();
        Set<String> strings = values.keySet();

        for (String string : strings) {
            System.out.println(string);

            String[] value = values.get(string);
            for (String s : value) {
                if (s == ""){
                    System.out.println("我为空");
                }
                System.out.println(s);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
