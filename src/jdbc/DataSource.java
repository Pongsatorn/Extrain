package jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {
    private Connection c = null;
    private BasicDataSource bdSource = new BasicDataSource();

    public DataSource(){
        bdSource.setDriverClassName("oracle.jdbc.OracleDriver");
        bdSource.setUrl("jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1");
        bdSource.setUsername("SCOTT");
        bdSource.setPassword("TIGER");
    }

    public Connection getConnection() {
        try {
            c = bdSource.getConnection();
            System.out.println("Success");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        DataSource d = new DataSource();
        Connection c = d.getConnection();
        try {
            System.out.println(c);
            c.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
