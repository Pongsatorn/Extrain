package jdbc;

import org.apache.log4j.Logger;

import java.sql.*;

public class CallableStatementSimple {
    final static Logger logger = Logger.getLogger(CallableStatementSimple.class);
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt  = null;
        CallableStatement csmt = null;
        int count;

        //STEP:1 Load driver
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Load Driver Failed");
        }

        //STEP:2 GetConnection
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "test";
        String passwd = "test";
        try {
            conn = DriverManager.getConnection(url,user,passwd);
        } catch (SQLException e) {
            System.out.println("Connect Failed");
        }


        //STEP:3 Create Sql
        String sql       = "SELECT * FROM ELECTION";
        String sqlPrepareFunction  = "{call ? := COUNTPRESIDENT()}";
        String sqlPrepareProcedure = "{call FINDMIN(?,?,?)}";

        //STEP4: Create Statement
        try {
            //Function
//            csmt = conn.prepareCall(sqlPrepareFunction);
//            csmt.registerOutParameter(1,Types.INTEGER);

            //Procedure
            csmt = conn.prepareCall(sqlPrepareProcedure);
            csmt.setInt(1,10);
            csmt.setInt(2,3);
            csmt.registerOutParameter(3,Types.INTEGER);


            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("CreateStatement Failed");
        }

        //STEP:5 Execute Statement
        try {
            csmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Execute Statement Failed");
        }

        //STEP:6 Get ResultSet
        try {
            //Function
//            count = csmt.getInt(1);
//            System.out.println("Number of president = " + count);

            //Procedure
            logger.debug(csmt.getInt(3));

        } catch (SQLException e) {
            System.out.println("Get ResultSet Failed");
        }


        //STEP:7, 8
        try {
            csmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Close Failed");
        }

    }
}
