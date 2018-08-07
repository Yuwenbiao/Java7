package Java7其他重要更新.关系数据库访问.使用trywithresources语句;

import java.sql.*;

/**
 * 使用try-with-resources语句进行数据库操作的示例
 */
public class DbOperation {
    public void dbOperation() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost/java7book");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM book")) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }
}
