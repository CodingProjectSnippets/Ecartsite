/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.utils.DbUtil;
import com.utils.PropertiesReader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NEELA_kpwhyff
 */
public class WelcomePage extends JFrame implements ActionListener {

    Connection con = null;
    Properties props;

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    WelcomePage() {
        con = DbUtil.getDbConnection();
        props = PropertiesReader.readPropertiesFile();
        setPanels();

    }
    JTable jtbl;
    Container cnt;
JButton button;
    private void setPanels() {
        try {
             button = new JButton("This is Demo Text!");
            button.setBackground(Color.blue);
            button.setForeground(Color.white);
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            cnt = this.getContentPane();
            jtbl = new JTable(model);

            cnt.setLayout(
                    new BorderLayout());

            model.addColumn(
                    "productid");
            model.addColumn(
                    "productname");
            model.addColumn(
                    "price");
            model.addColumn(
                    "quantity");
            model.addColumn(
                    "barcode");
            model.addColumn(
                    "Description");
            model.addColumn(
                    "unreason");

            ResultSet result = DbUtil.getQueryResult(props.getProperty("productsquery"), con);

            while (result.next()) {
                model.addRow(new Object[]{result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4),
                    result.getString(5), result.getString(6), result.getString(7)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(WelcomePage.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        jtbl.setRowHeight(30);
        JPanel jp = new JPanel();
        
        JScrollPane pg = new JScrollPane(jtbl);
        jp.add(button);
        jp.add(pg);

        cnt.add(jp);

        this.pack();

    }

}
