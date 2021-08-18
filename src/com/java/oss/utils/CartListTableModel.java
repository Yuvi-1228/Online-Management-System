/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.oss.utils;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ajay
 */
public class CartListTableModel  extends DefaultTableModel {

    public CartListTableModel() {
    }

    public CartListTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public boolean isCellEditable(int row, int column){  
        return false;  
    }

}
