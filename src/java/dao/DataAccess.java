/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DbUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DbModel;

/**
 *
 * @author BABA
 */
public class DataAccess {
    public static List<DbModel> getAll(){

    List<DbModel> ls = new LinkedList<>();

    try{
    ResultSet rs = DbUtils.getPreparedStatement("select * from products").executeQuery();

    while(rs.next())
    {
    
     DbModel n = new DbModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
     ls.add(n);
    }
}catch(Exception e){
    e.printStackTrace();
}
    return ls;
    }
    
    public static List<DbModel> getProById(int id){
        
        List<DbModel> ls = new LinkedList<>();
        
        try {
            String sql = "select *from products where id="+id;
            ResultSet rs = DbUtils.getPreparedStatement(sql).executeQuery(); 
            while(rs.next()){
              DbModel db = new DbModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));  
              
              ls.add(db);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    
    public void addNew(DbModel n){
        String sql = "insert into produts(name, description, price) values(?,?,?)";
      try {
        PreparedStatement ps = DbUtils.getPreparedStatement(sql);
            
        ps.setString(1, n.getName());
        ps.setString(2, n.getDescription());
        ps.setFloat(3, n.getPrice());
        
        ps.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static void edit(String name, String Description, Float price){
              String sql = "update products set name=?,description=?,price=?";
            try {
        PreparedStatement ps = DbUtils.getPreparedStatement(sql);
            
        ps.setString(1, name);
        ps.setString(2, Description);
        ps.setFloat(3, price);
        
        ps.executeUpdate();
                } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
