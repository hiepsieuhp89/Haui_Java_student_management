/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;
import java.awt.*;
import java.awt.event.*;  
import java.util.*;
import java.net.URL;   
/**
 *
 * @author tungc
 */
public class MHC extends java.awt.Frame {
    static Panel currentOpenPanel;
    static DanhSachPanel pn;
    public static final Frame ManHinhChinh = new MHC();
    /**
     * Creates new form MHC
     */
    void closePanels(){
//        danhsachhocsinh.setVisible(false);
//        setSize(new java.awt.Dimension(560, 361));
    }
    public MHC() {
        initComponents(); 
        System.out.println(this.getClass().getResource("files/SinhVien.txt"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mhc_menu = new java.awt.MenuBar();
        lophoc_menu = new java.awt.Menu();
        lophoc_danhsach_menu = new java.awt.MenuItem();
        phonghoc_menu = new java.awt.Menu();
        phonghoc_danhsach_menu = new java.awt.MenuItem();
        sinhvien_menu = new java.awt.Menu();
        sinhvien_danhsach_menu = new java.awt.MenuItem();
        help_menu = new java.awt.Menu();

        setBackground(new java.awt.Color(240, 240, 240));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(640, 420));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(540, 361));
        setTitle("Quản lý học sinh trường THPT Bôn Ba");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        lophoc_menu.setLabel("Class");

        lophoc_danhsach_menu.setLabel("List");
        lophoc_danhsach_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lophoc_danhsach_menuActionPerformed(evt);
            }
        });
        lophoc_menu.add(lophoc_danhsach_menu);

        mhc_menu.add(lophoc_menu);

        phonghoc_menu.setLabel("Class rooms");

        phonghoc_danhsach_menu.setLabel("List");
        phonghoc_danhsach_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonghoc_danhsach_menuActionPerformed(evt);
            }
        });
        phonghoc_menu.add(phonghoc_danhsach_menu);

        mhc_menu.add(phonghoc_menu);

        sinhvien_menu.setLabel("Students");
        sinhvien_menu.setName("Student List");

        sinhvien_danhsach_menu.setLabel("List");
        sinhvien_danhsach_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinhvien_danhsach_menuActionPerformed(evt);
            }
        });
        sinhvien_menu.add(sinhvien_danhsach_menu);

        mhc_menu.add(sinhvien_menu);

        help_menu.setLabel("Help");
        help_menu.setName("");
        mhc_menu.add(help_menu);

        setMenuBar(mhc_menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        this.setVisible(false);
    }//GEN-LAST:event_exitForm

    private void sinhvien_danhsach_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinhvien_danhsach_menuActionPerformed
        // TODO add your handling code here: 
        //DanhSachForm dssv = new DanhSachForm();
        //dssv.setVisible(true);
        if(pn != null && pn.isEnabled())
               pn.setVisible(false);
        pn = new DanhSachPanel("Student List","SinhVien");
        pn.setVisible(true);
        this.add(pn);
        this.setSize(800,500);
        this.setLocation(200,200);
        this.setVisible(true);
    }//GEN-LAST:event_sinhvien_danhsach_menuActionPerformed

    private void phonghoc_danhsach_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonghoc_danhsach_menuActionPerformed
        if(pn != null && pn.isEnabled())
               pn.setVisible(false);
        pn = new DanhSachPanel("ClassRoom List","PhongHoc");
        pn.setVisible(true);
        this.add(pn);
        this.setSize(800,500);
        this.setLocation(200,200);
        this.setVisible(true);
    }//GEN-LAST:event_phonghoc_danhsach_menuActionPerformed

    private void lophoc_danhsach_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lophoc_danhsach_menuActionPerformed
        if(pn != null && pn.isEnabled())
               pn.setVisible(false);
        pn = new DanhSachPanel("Class List","lop");
        pn.setVisible(true);
        this.add(pn);
        this.setSize(800,500);
        this.setLocation(200,200);
        this.setVisible(true);
    }//GEN-LAST:event_lophoc_danhsach_menuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManHinhChinh.setLocation(200,200);
                ManHinhChinh.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Menu help_menu;
    private java.awt.MenuItem lophoc_danhsach_menu;
    private java.awt.Menu lophoc_menu;
    private java.awt.MenuBar mhc_menu;
    private java.awt.MenuItem phonghoc_danhsach_menu;
    private java.awt.Menu phonghoc_menu;
    private java.awt.MenuItem sinhvien_danhsach_menu;
    private java.awt.Menu sinhvien_menu;
    // End of variables declaration//GEN-END:variables

}