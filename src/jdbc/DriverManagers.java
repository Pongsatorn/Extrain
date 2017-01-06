package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverManagers {
    String driverName = "oracle.jdbc.OracleDriver";
    Connection connection =null;

    public Connection getConnection() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1","SCOTT","TIGER");
            System.out.println("Connect success!!");
        }catch(ClassNotFoundException e){// cannt find DriverManager
            System.out.println("Connect error Driver!!");
        }
        catch(SQLException e){
            System.out.println("Connect error!!");
        }
        return connection;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DriverManagers d = new DriverManagers();
        Connection c = d.getConnection();
        try {
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery("select * from EMPLOYEE_TRAIN");
            while(result.next()){
                StringBuffer stringBuf = new StringBuffer();
                stringBuf.append("ID: ");
                stringBuf.append(result.getInt("ID"));
                stringBuf.append(" NAME: ");
                stringBuf.append(result.getString("NAME"));
                stringBuf.append(" DATE: ");
                stringBuf.append(result.getDate("WORKSTARTDATE"));
                System.out.println(stringBuf);
            }
            s.close();
            c.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
