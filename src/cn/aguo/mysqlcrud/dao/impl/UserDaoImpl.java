package cn.aguo.mysqlcrud.dao.impl;

import cn.aguo.mysqlcrud.dao.UserDao;
import cn.aguo.mysqlcrud.domain.LoginUser;
import cn.aguo.mysqlcrud.domain.User;
import cn.aguo.mysqlcrud.util.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author 石成果
 * @Date 2020/8/13 18:45
 * @Email 1260839205@qq.com
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        // 定义sql语句
        String sql = "select * from userinfo";

        //执行sql语句，并且获取数据
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public void add(User user) {
        String sql = "insert into userinfo value(null,?,?,?,?,?,?)";

        template.update(sql,
                user.getName(), user.getGender(),
                user.getAge(), user.getHometown(),
                user.getQq(), user.getEmail());
    }

    @Override
    public LoginUser loginUser(LoginUser loginuser) {
        try {
            String sql = "select * from user where username = ? and password = ?";

            return template.queryForObject(sql, new BeanPropertyRowMapper<LoginUser>(LoginUser.class), loginuser.getUsername(), loginuser.getPassword());
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void delete(int id) {

        //删除user信息的语句
        String sql = "delete from userinfo where id = ?";

        template.update(sql,id);

        //删除主键语句 --避免断层问题出现
        sql = "ALTER TABLE userinfo DROP id";

        template.update(sql);

        //重新设定id自动增长语句 --达到id重置的效果
        sql = "ALTER TABLE userinfo ADD COLUMN id INT PRIMARY KEY AUTO_INCREMENT FIRST";

        template.update(sql);
    }

    @Override
    public void update(User user) {
        String sql = "update userinfo set gender = ? , age = ? ,hometown = ? ,qq = ?,email =? where id = ?";

        template.update(sql,user.getGender(),user.getAge(),user.getHometown(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public User inquire(int id) {
        String sql = "select * from userinfo where id = ?";

        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);

        return user;
    }

    @Override
    public int count() {
        String sql = "select count(id) count from userinfo";

        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class));

        return user.getCount();

    }

    @Override
    public List<User> complexInquire(String dataone, String datatwo, String three) {
        return null;
    }

    @Override
    public List<User> complexInquire(String dataone, String datatwo) {
        return null;
    }

    @Override
    public List<User> complexInquire(String dataone) {
        return null;
    }

    @Override
    public List<User> findUserByPage(int currentPage, int row) {
        String sql = "select * from userinfo limit ? , ?";


        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),(currentPage - 1) * row ,row);
    }
}
