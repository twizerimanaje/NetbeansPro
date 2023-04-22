/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author BABA
 */
public class DbUtils {
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException{
    PreparedStatement ps = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DbUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    String url = "jdbc:mysql://localhost:3306/busness";
    String username = "root";
    String password = "";
    
    Connection con = DriverManager.getConnection(url, username, password);
    
      ps = con.prepareStatement(sql);
      
      return ps;
    
    }   
    
}
