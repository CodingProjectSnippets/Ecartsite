/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NEELA_kpwhyff
 */
public class PropertiesReader {
    public static Properties readPropertiesFile() {
      FileInputStream fis = null;
      Properties prop = null;
      try {
         fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\application.properties");
         prop = new Properties();
         prop.load(fis);
      } catch(FileNotFoundException fnfe) {
         fnfe.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
          try {
              fis.close();
          } catch (IOException ex) {
              Logger.getLogger(PropertiesReader.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return prop;
   }
}
    
