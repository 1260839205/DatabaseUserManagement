package cn.aguo.mysqlcrud.dao;

import cn.aguo.mysqlcrud.domain.LoginUser;
import cn.aguo.mysqlcrud.domain.User;

import java.util.List;

/**
 * @Author 石成果
 * @Date 2020/8/14 9:21
 * @Email 1260839205@qq.com
 *
 * 作用：用户操作的DAO
 */
public interface UserDao {

    /**
     * 查询所有数据的方法
     * @return
     */
    public List<User> findAll();

    /**
     * 添加数据的方法
     * @param user
     */
    public void add(User user);

    /**
     * 管理员登陆的方法
     * @param loginuser
     * @return
     */
    public LoginUser loginUser(LoginUser loginuser);

    /**
     * 删除user信息
     * @param id
     */
    public void delete(int id);

    /**
     * 更改user信息
     * @param user
     */
    public void update(User user);

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    public User inquire(int id);

    /**
     * 查询数据库数据条数
     * @return
     */
    public int count();



    /**
     * 
     * @param dataone
     * @param datatwo
     * @param three
     * @return
     */
    public List<User> complexInquire(String dataone , String datatwo , String three);

    public List<User> complexInquire(String dataone , String datatwo);

    public List<User> complexInquire(String dataone);

    public List<User> findUserByPage(int currentPage, int row);
}
