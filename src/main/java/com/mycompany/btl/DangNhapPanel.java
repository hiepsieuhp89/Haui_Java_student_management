/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.Label;
import java.awt.event.*;  
import java.awt.*;
import java.io.IOException;
import org.netbeans.lib.awtextra.*;
/**
 *
 * @author tungc
 */
public class DangNhapPanel extends java.awt.Panel {
    ArrayList<SinhVien> listSv;
    ArrayList<PhongHoc> listPh;
    ArrayList<Lop> listLop;
    String model;
    String[] columnName;
    ThemFrame add;
    SuaFrame edit;
    MHC parent;
    /**
     * Creates new form DanhSachPanel
     */
    public DangNhapPanel(MHC mhc) {   
        parent = mhc;
        initComponents();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        danhsach_label = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        submit = new java.awt.Button();
        isremember = new java.awt.Checkbox();
        validate_msg = new java.awt.Label();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        danhsach_label.setAlignment(java.awt.Label.CENTER);
        danhsach_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        danhsach_label.setMinimumSize(new java.awt.Dimension(62, 30));
        danhsach_label.setName(""); // NOI18N
        danhsach_label.setPreferredSize(new java.awt.Dimension(800, 23));
        danhsach_label.setText("LOGIN TO MANAGE STUDENT");
        add(danhsach_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Username");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, 50));

        username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 390, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, 50));

        password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 390, 50));

        submit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        submit.setLabel("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 150, 50));

        isremember.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        isremember.setLabel("Remember me!");
        add(isremember, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, 30));

        validate_msg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        validate_msg.setForeground(new java.awt.Color(255, 0, 0));
        validate_msg.setName(""); // NOI18N
        add(validate_msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 390, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        if(username.getText().trim().equals("") || password.getText().trim().equals(""))
            this.validate_msg.setText("Moi nhap day du Username va Password");      
        else{
            parent.user.setUsername(username.getText());
            parent.user.setPassword(password.getText());

            if(parent.user.Validate()){
                parent.submit_dangNhap();
                this.setVisible(false);
            }
            else{
                this.validate_msg.setText("Sai mat khau hoac tai khoan khong co trong he thong");
            }
        }
    }//GEN-LAST:event_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label danhsach_label;
    private java.awt.Checkbox isremember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField password;
    private java.awt.Button submit;
    private javax.swing.JTextField username;
    private java.awt.Label validate_msg;
    // End of variables declaration//GEN-END:variables
}
