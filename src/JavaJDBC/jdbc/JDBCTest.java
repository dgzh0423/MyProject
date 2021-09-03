package JavaJDBC.jdbc;

import java.sql.*;

public class JDBCTest {
    public static final String URL = "jdbc:mysql://localhost:3306/db01";
    public static final String USER = "root";
    public static final String PASSWORD = "235378";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载MySQL驱动程序
        //新的驱动程序类是`com.mysql.cj.jdbc.Driver'。 驱动程序通过 SPI 自动注册，通常不需要手动加载驱动程序类。
        //Class.forName("com.mysql.jdbc.Driver");

        //2. 获得数据库连接
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "select* from user";//查询操作
            //3.1 通过Connection提供的prepareStatement()方法创建一个PreparedStatement对象，用于执行一个查询;
            //使用PreparedStatement防止SQL注入问题
            try(PreparedStatement statement = conn.prepareStatement(sql)) {
                //3.2 执行Statement对象提供的executeQuery()，获得返回的结果集，使用ResultSet来引用这个结果集;
                try(ResultSet resultSet = statement.executeQuery()){
                    //3.3 反复调用ResultSet的next()方法并读取每一行结果
                    while(resultSet.next()){
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        System.out.println("id = " + id + " name = " + name + " age = " + age);
                    }
                }
            }
        }

        //除了sql代码不同，插入，更新和删除代码基本一致
        /*
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
            String insert = "insert into user values(5, 'Jerry', 10)";
            try(PreparedStatement ps = conn.prepareStatement(insert)){
                int n = ps.executeUpdate();// n返回的是插入/更新/删除的行数
                System.out.println("插入成功");
            }
        }
         */
    }
}
