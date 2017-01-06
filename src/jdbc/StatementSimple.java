package jdbc;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StatementSimple {
    static final Logger logger = Logger.getLogger(StatementSimple.class);
    public static void main(String[] args){
        Connection conn = null;
        Statement  stmt = null;

        //STEP:1 Load driver
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            logger.debug("Load Driver Successfully");
        } catch (ClassNotFoundException e) {
            logger.error("Load Driver Failed");
        }

        //STEP:2 GetConnection
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "test";
        String passwd = "test";
        try {
            conn = DriverManager.getConnection(url,user,passwd);
            logger.debug("Connect Complete");
        } catch (SQLException e) {
            logger.error("Connect Failed");
        }

        //STEP:3 Create Sql
        String sqlSelect = "SELECT * FROM ELECTION";
        String sqlInsert = "INSERT INTO ELECTION(VOTES) VALUES (777)";
        String sqlUpdate = "UPDATE ELECTION SET VOTES = 55 WHERE VOTES =777";
        String sqlDelete = "DELETE ELECTION WHERE VOTES=55";

        //STEP4: Create Statement
        try {
            stmt = conn.createStatement();
            logger.debug("CreateStatement Complete");
        } catch (SQLException e) {
            logger.error("CreateStatement Failed");
        }

        //STEP:5 Execute Statement
        try {
            int rowRecord =  stmt.executeUpdate(sqlDelete);
            logger.debug(rowRecord + " rows updated");
            logger.debug("Execute Statement Success .. Bravo !!");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Execute Statement Failed");
        }

        //STEP:6 Get ResultSet
        try {
            ResultSet resultSet = stmt.executeQuery(sqlSelect);

            while (resultSet.next()){
                logger.debug(resultSet.getString(1) + " " +
                                   resultSet.getString(2) + " " +
                                   resultSet.getString(3) + " " +
                                   resultSet.getString(4));
            }
            logger.debug("Get ResultSet Success .. Bravo !!");
        } catch (SQLException e) {
            logger.error("Get ResultSet Failed");
        }


        //STEP:7, 8
        try {
            stmt.close();
            conn.close();
            logger.debug("Close Success!!");
        } catch (SQLException e) {
            logger.error("Close Failed");
        }



    }
}
