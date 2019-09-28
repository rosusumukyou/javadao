package cn.mldn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 此类专门获取我们的connection对象，调用此类的时候就生成一个我们的connection对象
 * 
 * @author Administrator
 *
 */
public class DbConnection {
    private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:mldn";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";
    private Connection conn;

    public DbConnection() {
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close() {
        if (this.conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
