package cn.aguo.mysqlcrud.domain;

/**
 * @Author 石成果
 * @Date 2020/8/13 18:47
 * @Email 1260839205@qq.com
 */
public class User {
    private int id; //对应表中编号
    private String name; // 对应表中姓名
    private String gender; //对应表中性别
    private int age ; // 对应表中年龄
    private String hometown ; //对应表中籍贯
    private String qq; //对应表中qq号
    private String email; //对应表中邮箱
    private int count;

    /**
     * 空参构造
     */
    public User() {
    }

    /**
     * 全参构造
     * @param id
     * @param name
     * @param gender
     * @param age
     * @param hometown
     * @param qq
     * @param email
     */
    public User(int id, String name, String gender, int age, String hometown, String qq, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hometown = hometown;
        this.qq = qq;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
