package JavaJDBC.DAO_.dao;

import JavaJDBC.DAO_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//BasicDAO : 其他DAO的父类
public class BasicDAO<T> {

    private QueryRunner queryRunner = new QueryRunner();

    //开发通用的dml操作
    public int dml(String sql, Object... parameters) throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();
        int dml = queryRunner.update(connection, sql, parameters);
        JDBCUtilsByDruid.close(null,null,connection);

        return dml;
    }

    //返回多个对象(多行结果)，对任意表
    //Class<T> clazz 传入一个类的Class对象
    //parameters传入sql中？的具体值
    //return 根据User.class 返回对应的ArrayList集合
    public List<T> queryMultiple(String sql, Class<T> clazz, Object... parameters) throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();
        //执行sql语句，将结果封装到list中
        List<T> list = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), parameters);
        JDBCUtilsByDruid.close(null,null,connection);

        return list;
    }

    //返回单个对象
    public T querySingle(String sql, Class<T> clazz, Object... parameters) throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();
        T result = queryRunner.query(connection, sql, new BeanHandler<>(clazz), parameters);
        JDBCUtilsByDruid.close(null,null,connection);

        return result;
    }

    //返回单行单列的单值
    public Object queryScalar(String sql, Object... parameters) throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();
        Object object = queryRunner.query(connection, sql, new ScalarHandler(), parameters);
        JDBCUtilsByDruid.close(null,null,connection);

        return object;
    }
}
