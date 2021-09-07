package JavaJDBC.DAO_.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//基于Druid连接池的工具类
public class JDBCUtilsByDruid {
    private static DataSource ds;
    //静态代码块完成 ds 初始化
    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //getConnection()方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接(把使用的连接放回到连接池中)
    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null){
            resultSet.close();
        }
        if (statement != null){
            statement.close();
        }
        if (connection != null){
            connection.close();
        }
    }
}
