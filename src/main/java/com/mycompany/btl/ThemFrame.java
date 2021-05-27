/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;

import java.awt.Label;
import java.awt.event.*;  
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.lib.awtextra.*;
//import org.netbeans.lib.awtextra.*;

/**
 *
 * @author tungc
 */
public class ThemFrame extends java.awt.Frame {
    DanhSachPanel parent;
    String model;
    int space;
    Label lble_choice;
    Choice choice;
    Label[] lble;
    TextField[] tf;
    //static Frame main;
    /**
     * Creates new form ThemFrame
     */

    public ThemFrame(String name, String title, String[][] input, DanhSachPanel pn, int model_count, String[] choice_input) {
        parent = pn;
        model = name;
        space = 60;
        
        lble = new Label[input.length];      
        tf = new TextField[input.length];
        
        this.setTitle(title);
        this.setPreferredSize(new java.awt.Dimension(400, 400));
        this.setLayout(new AbsoluteLayout());
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });
        
        Label id_lble = new Label();
        TextField id_tf = new TextField();
        id_lble.setText("Index");
        id_tf.setText(String.valueOf(model_count));
        id_tf.setEditable(false);
        
        this.add(id_lble, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, space, -1, -1));
        this.add(id_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, space, 200, -1));
        space += 40;
        
        for(int i = 0;i < input.length; i++){
            lble[i] = new Label();
            lble[i].setText(input[i][1]);
            this.add(lble[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(50, space, -1, -1));
            tf[i] = new TextField();
            tf[i].setName(input[i][0]);
            this.add(tf[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(150, space, 200, -1));                   
            space += 40;
        }
        
        if(choice_input != null && choice_input.length > 0){
            lble_choice = new Label();
            lble_choice.setText(choice_input[0]);
            choice = new Choice();
            for(int i = 1;i < choice_input.length; i++){
                choice.add(choice_input[i]);
            }
            this.add(lble_choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, space, -1, -1));
            this.add(choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, space, 200, -1));
        }
        
        Button them_btn = new Button();
        them_btn.setLabel("Create new");
        them_btn.setName(""); // NOI18N
        them_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    them_btnActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(ThemFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ThemFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        this.add(them_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));      
        this.pack();
        
        //main.setVisible(true);
        
        //initComponents();
    }
    private void them_btnActionPerformed(java.awt.event.ActionEvent evt) throws IOException, ClassNotFoundException { 
        if(model == "Users"){
            User u = new User();
            for(int i = 0;i<tf.length;i++){
                if(tf[i].getName() == "name")
                    u.setName(tf[i].getText());
                
                if(tf[i].getName() == "username")
                    u.setUsername(tf[i].getText());
                
                if(tf[i].getName() == "password")
                    u.setPassword(tf[i].getText());
               
            }
            u.setRole(choice.getSelectedItem());
            u.save();
        }
        if(model == "PhongHoc"){
            PhongHoc ph = new PhongHoc();
            for(int i = 0;i<tf.length;i++){
                if(tf[i].getName() == "tenphong")
                    ph.setTenphong(tf[i].getText());
                
                if(tf[i].getName() == "sophong")
                    ph.setSophong(tf[i].getText());
                
                if(tf[i].getName() == "loaiphong")
                    ph.setLoaiphong(tf[i].getText());
            }
            ph.save();
        }
        if(model == "Lop"){
            Lop l = new Lop();
            for(int i = 0;i<tf.length;i++){
                if(tf[i].getName() == "name")
                    l.setName(tf[i].getText());
                
                if(tf[i].getName() == "khoahoc")
                    l.setKhoahoc(tf[i].getText());
                
                if(tf[i].getName() == "kyhoc")
                    l.setKyhoc(tf[i].getText());
            }
            PhongHoc ph = new PhongHoc().findByRoomNumber(choice.getSelectedItem());
            l.setPhonghoc(ph);
            l.save();
        }
        if(model == "SinhVien"){
            SinhVien sv = new SinhVien();
            for(int i = 0;i<tf.length;i++){
                if(tf[i].getName() == "name")
                    sv.setName(tf[i].getText());
                
                if(tf[i].getName() == "age")
                    sv.setAge(tf[i].getText());
                
                if(tf[i].getName() == "code")
                    sv.setCode(tf[i].getText());
                
                if(tf[i].getName() == "address")
                    sv.setAddress(tf[i].getText());
                
                if(tf[i].getName() == "birthyear")
                    sv.setBirthyear(tf[i].getText());
            }
            Lop l = new Lop().findByClassName(choice.getSelectedItem());
            sv.setLop(l);
            sv.save();
        }
        parent.UpdateModel();
        this.dispose();
           
//        Dialog d = new Dialog(this,"Thong bao",true);
//        d.setLayout(new FlowLayout());
//        
//        Button close_btn = new Button("Xác nhận");
//        close_btn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                d.setVisible(false);
//            }
//        });
//        d.setSize(200,200);
//        d.add(new Label(lble[1].getText()));
//        d.add(close_btn);
//        d.setVisible(true);
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(400, 500));
        setTitle("Thêm");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //main.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
