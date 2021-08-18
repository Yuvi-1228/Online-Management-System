/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.oss.frame.form.product;

import com.java.oss.classes.Product;
import com.java.oss.classes.User;
import com.java.oss.frame.LoginPortal;
import com.java.oss.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ajay
 */
public class ViewProductlist extends javax.swing.JPanel implements ListSelectionListener {

    private JPanel parentPanel; 
    private List<Product> productList = new ArrayList<>();
    private Product product;
    /**
     * Creates new form ProductListPanel
     */
    public ViewProductlist(JPanel parentPanel) {
        
        this.parentPanel = parentPanel;
        this.product = null;
        
        initComponents();
        
        setProductListInView();
        
        switch(LoginPortal.user.getRole()) {
            case User.ROLE_CUSTOMER:
                addBtn.setVisible(false);
                break;
            case User.ROLE_MANAGER:
                addBtn.setVisible(true);
                break;
            case User.ROLE_ADMIN:
                addBtn.setVisible(false);
                break;
        }

    }
    
    public void resetProduct() {
        this.product = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addBtn = new javax.swing.JButton();
        addProductLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));

        addBtn.setBackground(new java.awt.Color(204, 204, 255));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addBtn.setText("Add");
        addBtn.setBorder(null);
        addBtn.setBorderPainted(false);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        addProductLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addProductLabel.setText("Product");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(addProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        
        this.parentPanel.removeAll();
        this.parentPanel.revalidate();
        this.parentPanel.repaint();

        AddProductPanel addProductPanel = new AddProductPanel(parentPanel, this);
        parentPanel.add(addProductPanel);
        
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addProductLabel;
    private javax.swing.JList<Product> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void setProductListInView() {
        getProductListFromFile();
        
        DefaultListModel<Product> defaultListModel = new DefaultListModel<>();
        
        for(Product product: productList) {
            defaultListModel.addElement(product);
            
        }
        
        jList1.setModel(defaultListModel);
        jList1.setCellRenderer(new ViewProductListRow());
        jList1.addListSelectionListener(this);
    }

    private void getProductListFromFile() {
        BufferedReader reader = null;
        try {
            File file = new File(Utils.P_FILENAME);
            if(!file.exists()) {
                return;
            }   
            
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            
            while(line != null) {
                String[] productDetails = line.split(",");
                
                Product product = new Product();
                product.setId(Integer.parseInt(productDetails[Product.ID]));
                product.setName(productDetails[Product.NAME]);
                product.setModelNumber(productDetails[Product.MODEL_NUMBER]);
                product.setStock(Integer.parseInt(productDetails[Product.STOCK]));
                product.setPrice(Double.parseDouble(productDetails[Product.PRICE]));
                product.setCategory(productDetails[Product.CATEGORY]);
                
                productList.add(product);
               
                line = reader.readLine();
            }
            
        } catch (IOException ex) {
            
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(ViewProductlist.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int id = jList1.getSelectedValue().getId();
        if(product == null || (product != null && product.getId() != id)) {
            product = jList1.getSelectedValue();
            DeleteUpdate panel = new DeleteUpdate(product, parentPanel, this);
            
            this.parentPanel.removeAll();
            this.parentPanel.revalidate();
            this.parentPanel.repaint();
            
            this.parentPanel.add(panel);
        }
    }
    
}
