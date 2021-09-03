package JavaJDBC.jdbc;

import java.sql.*;

public class JDBCBatch {
    //在URL后面加上 ?rewriteBatchedStatements=true 表示启动批处理操作，提高效率
    public static final String URL = "jdbc:mysql://localhost:3306/db01?rewriteBatchedStatements=true";
    public static final String USER = "root";
    public static final String PASSWORD = "235378";

    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insert = "insert into user values(?, 'Yuri', ?)";
            try (PreparedStatement ps = conn.prepareStatement(insert)){
                for (int i = 11; i<=15; i++){
                    ps.setObject(1, i);
                    ps.setObject(2, i);
                    ps.addBatch();
                }
                ps.executeBatch();
            }
        }
    }
}
