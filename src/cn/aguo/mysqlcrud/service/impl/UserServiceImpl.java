package cn.aguo.mysqlcrud.service.impl;

import cn.aguo.mysqlcrud.dao.UserDao;
import cn.aguo.mysqlcrud.dao.impl.UserDaoImpl;
import cn.aguo.mysqlcrud.domain.LoginUser;
import cn.aguo.mysqlcrud.domain.PageBean;
import cn.aguo.mysqlcrud.service.UserService;
import cn.aguo.mysqlcrud.domain.User;

import java.util.List;

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
    public PageBean<User> findUserByPage(String currentPageNumber, String rows) {

        //获取当前页码和每页显示条数
        int currentPage = Integer.parseInt(currentPageNumber);
        int row = Integer.parseInt(rows);

        //创建PageBean对象
        PageBean<User> pb = new PageBean<User>();

        //存入数据
        pb.setCurrentPageNumber(currentPage);
        pb.setRows(row);
        int count = dao.count();
        pb.setTotalCount(count);
        pb.setTotalPageNumber((count % row )== 0 ? count / row : (count / row) + 1);
        pb.setListusers(dao.findUserByPage(currentPage,row));

        return pb;
    }


}
