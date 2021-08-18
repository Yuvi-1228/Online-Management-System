/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.oss.classes;

import java.util.List;

/**
 *
 * @author aashish
 */
public class Order {
    
    public static final int ID = 0;
    public static final int TOTAL_PRICE = 1;
    public static final int CUSTOMER_ID = 2;
    
    private int id;
    private User customer;
    private double totalPrice;
    private List<OrderItem> orderItems;

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
     * @return the orderItems
     */
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * @param orderItems the orderItems to set
     */
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the customer
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(User customer) {
        this.customer = customer;
    }
    
}