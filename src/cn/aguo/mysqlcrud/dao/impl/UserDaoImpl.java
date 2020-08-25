package cn.aguo.mysqlcrud.dao.impl;

import cn.aguo.mysqlcrud.dao.UserDao;
import cn.aguo.mysqlcrud.domain.LoginUser;
import cn.aguo.mysqlcrud.domain.User;
import cn.aguo.mysqlcrud.util.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public int count(Map<String, String[]> parame) {
        String sql = "select count(*) count from userinfo where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> list = new ArrayList<Object>();

        Set<String> keys = parame.keySet();
        for (String key : keys) {
            if ("currentPageNumber".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = parame.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                list.add("%"+value+"%");
            }
        }

        sql = sb.toString();
        System.out.println(sql);
        System.out.println(list);

        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), list.toArray());

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
    public List<User> findUserByPage(int currentPage, int row, Map<String, String[]> parame) {
        try {
            String sql = "select * from userinfo where 1 = 1 ";
            StringBuilder sb = new StringBuilder(sql);
            List<Object> list = new ArrayList<Object>();

            Set<String> keys = parame.keySet();
            for (String key : keys) {
                if ("currentPageNumber".equals(key) || "rows".equals(key)){
                    continue;
                }
                String value = parame.get(key)[0];
                if (value != null && !"".equals(value)){
                    sb.append(" and "+key+" like ? ");
                    list.add("%"+value+"%");
                }
            }
            sb.append(" limit ?,? ");
            sql = sb.toString();
            list.add((currentPage - 1) * row);
            list.add(row);

            return template.query(sql,new BeanPropertyRowMapper<User>(User.class),list.toArray());
        }catch (Exception e){
            return null;
        }

    }
}
