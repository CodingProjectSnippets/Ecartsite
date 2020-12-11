/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author NEELA_kpwhyff
 */
public class DatabaseValues {
   private boolean overflow=false;
   private int dbquantity=0;

    /**
     * @return the overflow
     */
    public boolean isOverflow() {
        return overflow;
    }

    /**
     * @param overflow the overflow to set
     */
    public void setOverflow(boolean overflow) {
        this.overflow = overflow;
    }

    /**
     * @return the dbquantity
     */
    public int getDbquantity() {
        return dbquantity;
    }

    /**
     * @param dbquantity the dbquantity to set
     */
    public void setDbquantity(int dbquantity) {
        this.dbquantity = dbquantity;
    }
    
}
