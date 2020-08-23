package cn.aguo.mysqlcrud.domain;

/**
 * @Author 石成果
 * @Date 2020/8/14 16:25
 * @Email 1260839205@qq.com
 */
public class LoginUser {
    private int id;
    private String username;
    private String password;
    private String checkcode;

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", checkcode='" + checkcode + '\'' +
                '}';
    }

    public LoginUser(int id, String username, String password, String checkcode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.checkcode = checkcode;
    }

    public LoginUser() {
    }
}
