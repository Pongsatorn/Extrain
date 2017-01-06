package jdbc;

import java.sql.*;
import java.util.Calendar;
import java.sql.*;
import java.util.Calendar;

public class BatchJob {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        System.out.println(startDate);
        //STEP:1 Load JDBC Driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //STEP:2 GetConnection
        String url = "jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1";
        String user = "SCOTT";
        String passwd = "TIGER";
        Connection connect = DriverManager.getConnection(url, user, passwd);
        System.out.println("Connection Complete");

        //STEP: 3 Create SQL Query
        String sql = "select * from employee_train_20161130";
        String sqlSelectPrepare = "select * from employee_train_20161130 WHERE Name = ?";
        String sqlInsertPrepare = "INSERT INTO employee_train_20161130  VALUES (?, ?, ?, ?, ?)";
        String sqlDelerePrepare = "DELETE FROM employee_train_20161130 WHERE NAME=? ";
        String sqlUpdatePrepare = "UPDATE employee_train_20161130 SET TEL= ?  WHERE NAME= ?";

        //STEP: 4 Create Statement
        Statement statement = connect.createStatement();

        connect.setAutoCommit(false);
        PreparedStatement pstmt = connect.prepareStatement(sqlUpdatePrepare);
//        /*INSERT*/

//        pstmt.setInt(1, 99);
//        pstmt.setString(2, "Keng123");
//        pstmt.setString(3, "Korat");
//        pstmt.setString(4, "00000000");
//        pstmt.setDate(5, startDate);
//        pstmt.addBatch();
//
//        pstmt.setInt(1, 99);
//        pstmt.setString(2, "Keng234");
//        pstmt.setString(3, "Korat");
//        pstmt.setString(4, "00000000");
//        pstmt.setDate(5, startDate);
//        pstmt.addBatch();
//
//        connect.commit();
//        connect.setAutoCommit(true);

        /*DELETE*/
//         pstmt.setString(1, "KengP");

        /*UPDATE*/
        pstmt.setString(1,"12344321");
        pstmt.setString(2,"KENG22");


        /*SELECT*/
//        pstmt.setString(1,"KENG22");


        int[] rowRecord = pstmt.executeBatch();

        //STEP: 5 Execute Query
        //  pstmt.executeUpdate();



        //STEP: 6 Get ResultSet
        ResultSet resultSet = statement.executeQuery(sql);//statement.executeQuery(sql);
//        System.out.println("Rows " + rowRecord);
        int time = 1;
        for (int i = 0 ; i < rowRecord.length ; i++){
            System.out.println("Time " + i+1 +" rows "+rowRecord[i]+" updated");
        }
        if (rowRecord.length == 0 )
            System.out.println("row 0 updated");


        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " : "
                    + resultSet.getString("NAME") + " : "
                    + resultSet.getString("ADDRESS") + " : "
                    + resultSet.getString("TEL") + " : "
                    + resultSet.getDate("WORKSTARTDATE"));
        }

        //STEP: 7 8
        statement.close();
        pstmt.close();
        connect.close();

    }
}

