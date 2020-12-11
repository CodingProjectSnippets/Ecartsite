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
public class ProductBean {

    private int productid;
    private String productname;
    private double price;
    private int quantity;
    private String barcode;
    private String description;
    private String unreason;
    private int counter=0;
    private boolean exist=false;

    /**
     * @return the productid
     */
    public int getProductid() {
        return productid;
    }

    /**
     * @param productid the productid to set
     */
    public void setProductid(int productid) {
        this.productid = productid;
    }

    /**
     * @return the productname
     */
    public String getProductname() {
        return productname;
    }

    /**
     * @param productname the productname to set
     */
    public void setProductname(String productname) {
        this.productname = productname;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unreason
     */
    public String getUnreason() {
        return unreason;
    }

    /**
     * @param unreason the unreason to set
     */
    public void setUnreason(String unreason) {
        this.unreason = unreason;
    }

   @Override
	public String toString() {
		return "bean [productid=" + productid + ", productname=" + productname + ", price=" + price + ", quantity="
				+ quantity + ", barcode=" + barcode + ", description=" + description + ", unreason=" + unreason
				+ ", counter=" + counter + ", exist=" + exist + "]";
	}
	

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = this.counter+counter;
    }

    /**
     * @return the exist
     */
    public boolean isExist() {
        return exist;
    }

    /**
     * @param exist the exist to set
     */
    public void setExist(boolean exist) {
        this.exist = exist;
    }

}
