/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NEELA_kpwhyff
 */
public class CommonUtilities {
     static Properties props= null;
    public static Properties getProps(){
        props=PropertiesReader.readPropertiesFile();
        return props;
    }
    
}
