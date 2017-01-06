package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcWithDataSource {
    public static void main(String[] args) throws SQLException{
        DataSource d    = new DataSource();
        Connection conn = d.getConnection();
        String sql = "Select * From president";
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("Name : " + resultSet.getString(1));
        }
    }
}
