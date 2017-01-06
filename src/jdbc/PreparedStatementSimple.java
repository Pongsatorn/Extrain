package jdbc;

import org.apache.log4j.Logger;

import java.sql.*;

public class PreparedStatementSimple {
    static final Logger logger = Logger.getLogger(PreparedStatementSimple.class);
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement  pstmt = null;
        Statement stmt = null;
        int rowRecord;

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
        String sql       = "SELECT * FROM ELECTION WHERE CANDIDATE LIKE 'k%'";
        String sqlSelect = "SELECT * FROM ELECTION WHERE VOTES = ?";
        String sqlInsert = "INSERT INTO ELECTION VALUES (?,?,?,?)";
        String sqlUpdate = "UPDATE ELECTION SET VOTES = ? WHERE VOTES = ?";
        String sqlDelete = "DELETE ELECTION WHERE VOTES = ?";

        //STEP4: Create Statement
        try {
            //select
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setInt(1,12);


            //insert
//            pstmt = conn.prepareStatement(sqlInsert);
//            pstmt.setInt(1,55);
//            pstmt.setString(2,"keng");
//            pstmt.setInt(3,777);
//            pstmt.setString(4,"W");

            //update
//            pstmt = conn.prepareStatement(sqlUpdate);
//            pstmt.setInt(1,55);
//            pstmt.setInt(2,777);

            //delete
//            pstmt = conn.prepareStatement(sqlDelete);
//            pstmt.setInt(1,55);


            stmt  = conn.createStatement();

            logger.debug("CreateStatement Complete");
        } catch (SQLException e) {
            logger.error("CreateStatement Failed");
        }

        //STEP:5 Execute Statement
//        try {
//            rowRecord =  pstmt.executeUpdate();
//
//            logger.debug(rowRecord + " rows updated");
//            logger.debug("Execute Statement Success .. Bravo !!!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            logger.error("Execute Statement Failed");
//        }

        //STEP:6 Get ResultSet
        try {
            ResultSet resultSet = pstmt.executeQuery();
            logger.debug("Election Year : Candidate : Votes :  Winne_rLoser_indic");
            while (resultSet.next()){

                logger.debug(resultSet.getString(1) + "           " +
                        resultSet.getString(2) + "" +
                        resultSet.getString(3) + "      " +
                        resultSet.getString(4));
            }
            logger.debug("Get ResultSet Success .. Bravo !!!");
        } catch (SQLException e) {
            logger.error("Get ResultSet Failed");
        }



        //STEP:7, 8
        try {
            pstmt.close();
            stmt.close();
            conn.close();
            logger.debug("Close Success!!!");
        } catch (SQLException e) {
            logger.error("Close Failed");
        }

    }
}
