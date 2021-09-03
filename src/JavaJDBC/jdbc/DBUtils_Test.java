package JavaJDBC.jdbc;

import JavaJDBC.DAO_.domain.User;
import JavaJDBC.DAO_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//使用apache-DBUtils 工具类和 JDBCUtilsByDruid 工具类实现对表的CRUD操作
//不足：sql语句固定，select的返回值不能固定（需要泛型），实际工作中用的表很多，不能在这一个类中完成
public class DBUtils_Test {
    @Test
    public void test() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        //就可以执行相关的方法，返回一个ArrayList结果集
        String sql = "select* from user where id >= ?";

        //query()方法就是执行sql语句，再将resultSet封装到ArrayList
        //BeanListHandler<>(User.class) 底层使用反射机制将User的属性封装到ArrayList
        //1是传给？占位符的
        List<User> list = queryRunner.query(connection, sql, new BeanListHandler<>(User.class), 1);
        //返回单行数据(单个对象)，使用BeanHandler
        //User user = queryRunner.query(connection, sql, new BeanHandler<>(User.class), 1);

        //输出user
        for(User user: list){
            System.out.println(user);
        }

        //释放资源
        //resultSet在query()中关闭，同时也关闭PreparedStatement
        JDBCUtilsByDruid.close(null,null, connection);
    }

    @Test
    //返回单行单列的结果(object),使用ScalarHandler
    public void testScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from user where id >= ?";

        Object object = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(object);

        JDBCUtilsByDruid.close(null,null, connection);
    }

    @Test
    //DML指的是insert，update和delete
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String update = "update user set name = ? where id = ?";
        int n = queryRunner.update(connection, update, "GOD", 1);//n是受影响的行数
        System.out.println(n>0 ? "更新成功" : "更新无效");

        JDBCUtilsByDruid.close(null,null, connection);
    }
}
