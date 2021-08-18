/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.oss.classes;

/**
 *
 * @author aashish
 */
public class OrderItem {
    
    
    public static final int ID = 0;
    public static final int PRODUCT_ID = 1;
    public static final int NAME = 2;
    public static final int PRICE = 3;
    public static final int ORDER_ID = 4;

    private int id;
    private Product product;
    private int quantity;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
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

    
    
}
