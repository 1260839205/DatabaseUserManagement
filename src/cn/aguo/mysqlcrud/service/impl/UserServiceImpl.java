package cn.aguo.mysqlcrud.service.impl;

import cn.aguo.mysqlcrud.dao.UserDao;
import cn.aguo.mysqlcrud.dao.impl.UserDaoImpl;
import cn.aguo.mysqlcrud.domain.LoginUser;
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
    public int count() {
        return dao.count();
    }


}
