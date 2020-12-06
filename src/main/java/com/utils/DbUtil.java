/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import com.beans.ProductBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet dbResult = null;

    public static Connection getDbConnection() {
        // EmbeddedDriver e;
        try {
            String driver = CommonUtilities.getProps().getProperty("derbydriver");
            System.out.println(driver);
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby:" + driver, "root", "root");

            System.out.println("Connected To Derby Database!" + con);

        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static ResultSet getQueryResult(String query, Connection con) {
        try {
            stmt = con.createStatement();
            dbResult = stmt.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbResult;
    }

    public static int getupdateQueryResult(String query, Connection con) {
        int result = 0;
        try {

            stmt = con.createStatement();
            result = stmt.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static int insertqueryResult(String query, ProductBean bean) {
        try {
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, bean.getProductid());
            pstmt.setString(2, bean.getProductname());
            pstmt.setDouble(3, bean.getPrice());
            pstmt.setInt(4, bean.getQuantity());
            pstmt.setString(5, bean.getBarcode());
            pstmt.setString(6, bean.getDescription());
            pstmt.setString(7, bean.getUnreason());
            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int editqueryResult(String query, ProductBean bean) {
        try {
            PreparedStatement pstmt = con.prepareStatement(query);

           
            pstmt.setString(1, bean.getProductname());
            pstmt.setDouble(2, bean.getPrice());
            pstmt.setInt(3, bean.getQuantity());
            pstmt.setString(4, bean.getBarcode());
            pstmt.setString(5, bean.getDescription());
            pstmt.setString(6, bean.getUnreason());
             pstmt.setInt(7, bean.getProductid());
            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
