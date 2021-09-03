package JavaJDBC.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBC_Druid {
    public static void main(String[] args) {

    }
    @Test
    //通过配置文件druid.properties获取相关连接信息
    public void testDruid_1() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = ds.getConnection();
        System.out.println("OK!");
        connection.close();
    }
}
