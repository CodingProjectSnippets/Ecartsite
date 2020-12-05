/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.EmbeddedDriver;

/**
 *
 * @author NEELA_kpwhyff
 */
public class DbUtil {
private static Connection con=null;
private static Statement stmt= null;
private static ResultSet dbResult=null;
    public static Connection getDbConnection()  {
       // EmbeddedDriver e;
        try {
              String driver=CommonUtilities.getProps().getProperty("derbydriver");
              System.out.println(driver);
              Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
              con = DriverManager.getConnection("jdbc:derby:"+driver, "root", "root");
             
            
            System.out.println("Connected To Derby Database!" + con);
           
        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
         return con;
    }
    public static ResultSet getQueryResult(String query,Connection con){
    try {
        stmt = con.createStatement();
          dbResult = stmt.executeQuery(query);
       
    } catch (SQLException ex) {
        Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
     return dbResult;
    }

}
