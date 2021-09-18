package JavaJDBC.DAO_.test;

import JavaJDBC.DAO_.dao.UserDAO;
import JavaJDBC.DAO_.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class TestDAO {

    @Test
    //测试UseDAO对user表的dml操作
    public void testUseDAO() throws SQLException {

        UserDAO userDAO = new UserDAO();

        //查询多行结果
        List<User> users = userDAO.queryMultiple("select* from user where id >= ?", User.class, 10);
        for(User user: users){
            System.out.println(user);
        }

        //查询单行结果
        User user = userDAO.querySingle("select* from user where id = ?", User.class, 1);
        System.out.println(user);

        //查询单值
        Object name = userDAO.queryScalar("select name from user where id = ?", 5);
        System.out.println(name);

        //insert
        /*
        int xiaohu = userDAO.dml("insert into user values(?, ?, ?)", 16, "xiaohu", 20);
        System.out.println(xiaohu>0 ? "插入成功" : "未插入");
         */

    }
}
