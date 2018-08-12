package Java7其他重要更新.关系数据库访问.RowSet实现提供者;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 * 使用工厂方法创建RowSet接口的实现对象的示例
 */
public class UseRowSet {
    public void useRowSet() throws SQLException {
        RowSetFactory rsFactory = RowSetProvider.newFactory();
        try (JdbcRowSet jrs = rsFactory.createJdbcRowSet()) {
            jrs.setUrl("jdbc:derby://localhost/java7book");
            jrs.setCommand("SELECT * FROM book");
            jrs.execute();
            jrs.absolute(1);
            jrs.updateString("name", "New book");
            jrs.updateRow();
        }
    }
}
