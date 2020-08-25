package cn.aguo.mysqlcrud.service.impl;

import cn.aguo.mysqlcrud.dao.UserDao;
import cn.aguo.mysqlcrud.dao.impl.UserDaoImpl;
import cn.aguo.mysqlcrud.domain.LoginUser;
import cn.aguo.mysqlcrud.domain.PageBean;
import cn.aguo.mysqlcrud.service.UserService;
import cn.aguo.mysqlcrud.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author 石成果
 * @Date 2020/8/14 9:31
 * @Email 1260839205@qq.com
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public LoginUser loginUser(LoginUser loginuser) {
        return dao.loginUser(loginuser);
    }

    @Override
    public void delete(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public User inquire(String id) {
        return dao.inquire(Integer.parseInt(id));
    }

    @Override
    public void deleteUsers(String[] ids) {
        for (String id : ids) {
            dao.delete(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPageNumber, String rows, Map<String, String[]> parame) {

        //获取当前页码和每页显示条数
        int currentPage = Integer.parseInt(currentPageNumber);
        int row = Integer.parseInt(rows);
        if (currentPage < 1){
            currentPage = 1;
        }
        int count = dao.count(parame);
        int totalpage = (count % row )== 0 ? count / row : (count / row) + 1;
        if (currentPage > totalpage){
            currentPage = totalpage;
        }

        //创建PageBean对象
        PageBean<User> pb = new PageBean<User>();

        //存入数据
        pb.setCurrentPageNumber(currentPage);
        pb.setRows(row);
        pb.setTotalCount(count);
        pb.setTotalPageNumber(totalpage);
        pb.setListusers(dao.findUserByPage(currentPage,row,parame));
        System.out.println(dao.findUserByPage(currentPage,row,parame));

        return pb;
    }


}
