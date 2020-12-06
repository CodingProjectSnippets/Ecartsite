/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author NEELA_kpwhyff
 */
import com.utils.DbUtil;
import com.utils.PropertiesReader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LoginFrmae extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel LoginLabel = new JLabel("Welcome To Worlds Great Shopping Experience of ECART");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    Connection con = null;
    Properties props;

    LoginFrmae() {
        setLayoutManager();
        showPassword.setBackground(Color.lightGray);
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        con = DbUtil.getDbConnection();
        props = PropertiesReader.readPropertiesFile();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

    }

    private void setLayoutManager() {

        container.setLayout(null);
    }

    private void setLocationAndSize() {
        Font font = new Font("Courier", Font.BOLD, 16);
        LoginLabel.setFont(font);
        LoginLabel.setBounds(400, 100, 600, 30);
        userLabel.setBounds(450, 150, 100, 30);
        passwordLabel.setBounds(450, 220, 100, 30);
        userTextField.setBounds(650, 150, 150, 30);
        passwordField.setBounds(650, 220, 150, 30);
        showPassword.setBounds(650, 250, 150, 30);
        loginButton.setBounds(450, 300, 100, 30);
        resetButton.setBounds(650, 300, 100, 30);

    }

    private void addComponentsToContainer() {
        container.add(LoginLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    private void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            try {
                String userText;
                String pwdText;
                ArrayList<String> dbUsername = new ArrayList<>();
                ArrayList<String> dbPwd = new ArrayList<>();

                userText = userTextField.getText();
                pwdText = passwordField.getText();

                ResultSet result = DbUtil.getQueryResult(props.getProperty("usernamepasswordquery"), con);
                System.out.println(result);
                while (result.next()) {
                    dbUsername.add(result.getString("username"));
                    dbPwd.add(result.getString("password"));
                }

                if (dbUsername.contains(userText) && dbPwd.contains(pwdText)) {
                    //JOptionPane.showMessageDialog(this, "Login Successful");
                    this.setVisible(false);
                    this.dispose();
                    SalePage sp = new SalePage(userText);
                    sp.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    sp.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginFrmae.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }

}
