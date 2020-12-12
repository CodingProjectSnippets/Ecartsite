/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecarbussiness;

import java.io.IOException;
import javax.swing.JFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author NEELA_kpwhyff
 */
@SpringBootApplication
public class Login {

    public static void main(String[] a) throws IOException {
       
        //creating new object to swith to login page Frame
        LoginFrmae frame = new LoginFrmae();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}
