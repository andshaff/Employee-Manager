/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Andy Shaffer
 */
public class databaseInterface {
    String url ="jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g";
    Connection con = null;
    Statement statement = null;

    public Statement establishConnection(String username, String password) throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection( url, username,password);
            statement = con.createStatement();
            System.out.println("***** Connection Established *****");
            return statement;   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(databaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
        
    }
    
    public void dropConnection() {
        try {
            statement.close();
            con.commit();
            con.close();
            System.out.println("***** Connection Dropped *****");
        } catch (SQLException ex) {
            Logger.getLogger(databaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
