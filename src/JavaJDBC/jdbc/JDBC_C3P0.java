package JavaJDBC.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC_C3P0 {
    public static void main(String[] args) {

    }

    @Test
    // 方式1：通过配置文件mysql.properties获取相关连接信息
    public void testC3P0_1() throws IOException, SQLException {
        //创建一个数据源对象
        ComboPooledDataSource cs = new ComboPooledDataSource();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USER");
        String password = properties.getProperty("PASSWORD");

        //给ComboPooledDataSource设置相关参数
        cs.setJdbcUrl(url);
        cs.setUser(user);
        cs.setPassword(password);
        cs.setInitialPoolSize(10);//设置数据库连接池初始化的连接数目
        cs.setMaxPoolSize(20);//设置数据库连接池最大的连接数目
        Connection connection = cs.getConnection();//核心方法，从连接池中获取一个数据库连接
        System.out.println("OK!");
        connection.close();
    }

    @Test
    //方式2：使用配置文件模板c3p0-config.xml
    public void testC3P0_2() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("config");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("OK!");
        connection.close();
    }
}
