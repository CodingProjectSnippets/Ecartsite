package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) throws SQLException {
            
		SpringApplication.run(BasicApplication.class, args);
                Connection con = DriverManager.getConnection("jdbc:derby:C:\\Users\\NEELA_kpwhyff\\OneDrive\\Documents\\NetBeansProjects\\Ecart\\EcartDb;create=true","root","root");
		System.out.println("Connected To Derby Database!"+con);
		con.close();
	}

}
