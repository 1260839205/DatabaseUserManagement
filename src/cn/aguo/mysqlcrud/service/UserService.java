package cn.aguo.mysqlcrud.service;

import cn.aguo.mysqlcrud.domain.LoginUser;
import cn.aguo.mysqlcrud.domain.PageBean;
import cn.aguo.mysqlcrud.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author 石成果
 * @Date 2020/8/14 9:29
 * @Email 1260839205@qq.com
 *
 * 作用：用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户的信息
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户信息
     * @return
     */
    public void add(User user);

    /**
     * 管理员登陆的方法
     * @param loginuser
     * @return
     */
    public LoginUser loginUser(LoginUser loginuser);

    /**
     * 删除用户的方法
     * @param id
     */
    public void delete(String id);

    /**
     * 更改用户数据的方法
     * @param user
     */
    public void update(User user);

    /**
     * 通过id查询User数据的方法
     * @param id
     * @return
     */
    public User inquire(String id);

    /**
     * 通过id删除所有选中的User信息
     * @param ids
     */
    public void deleteUsers(String[] ids);


    /**
     * 分页查找用户
     * @return
     * @param currentPageNumber
     * @param rows
     * @param parame
     */
    public PageBean<User> findUserByPage(String currentPageNumber, String rows, Map<String, String[]> parame);
}
