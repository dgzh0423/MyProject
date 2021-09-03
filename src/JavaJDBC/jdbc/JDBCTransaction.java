package JavaJDBC.jdbc;

import java.sql.*;

public class JDBCTransaction {
    public static final String URL = "jdbc:mysql://localhost:3306/db01";
    public static final String USER = "root";
    public static final String PASSWORD = "235378";

    public static void main(String[] args) throws SQLException {
        //默认情况下，我们获取到Connection连接后，总是处于“自动提交”模式，也就是每执行一条SQL都是作为事务自动执行的
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //设定事务的隔离级别
        //conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        String sql1 = "update user set age = age + 2 where id=1";
        String sql2 = "update user set age = age - 2 where id=2";
        try {
            conn.setAutoCommit(false);//关闭自动提交
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps1.executeUpdate();
            ps2.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            conn.rollback();//回滚到事务开始
        }finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}