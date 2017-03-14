package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zhangbaoning on 2017/3/8.
 */
public class DBUtil {
    private static final String USER = "root";
    private static final String PASSWORD = "3896";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/goddess";
    private static Connection connection = null; //必须为静态
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
