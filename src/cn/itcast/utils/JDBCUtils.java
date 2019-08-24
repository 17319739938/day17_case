package cn.itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
             ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //返回连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //返回连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
}
