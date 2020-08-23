package cn.aguo.mysqlcrud.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author 石成果
 * @Date 2020/8/13 18:38
 * @Email 1260839205@qq.com
 */
public class JDBCUtils {
    private static DataSource ds; //创建数据连接池对象

    static {
        try {
            //创建存放配置文件的集合
            Properties pt = new Properties();

            //获取配置文件 , 并存入集合中
            pt.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            //获取数据连接池
            ds = DruidDataSourceFactory.createDataSource(pt);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
