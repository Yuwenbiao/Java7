package Java7其他重要更新.关系数据库访问.数据库查询的默认模式;

import java.sql.*;

/**
 * setSchema方法的使用示例
 */
public class SetSchema {
    public void setSchema() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc: derby://localhost/java7book")) {
            connection.setSchema("DEMO_SCHEMA");
            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM author")) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        }
    }
}
