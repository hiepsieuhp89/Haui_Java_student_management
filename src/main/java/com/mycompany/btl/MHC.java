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
    public static DangNhapPanel login;
    public static DanhSachPanel pn;
    public static User user;
    public static final Frame ManHinhChinh = new MHC();
    
    public ActionListener phonghoc_danhsach_menu_action = new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            phonghoc_danhsach_menuActionPerformed(evt);
        }
    };
    public ActionListener sinhvien_danhsach_menu_action = new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            sinhvien_danhsach_menuActionPerformed(evt);
        }
    };
    public ActionListener lophoc_danhsach_menu_action = new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            lophoc_danhsach_menuActionPerformed(evt);
        }
    };
    public ActionListener admin_danhsach_menu_action = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_danhsach_menuActionPerformed(evt);
            }
        };
    
    /**
     * Creates new form MHC
     */
    void closePanels(){
//        danhsachhocsinh.setVisible(false);
//        setSize(new java.awt.Dimension(560, 361));
    }
    public MHC() {
        user = new User();
        
        xuatmanhinh();
        //initComponents(); 
        if(user.getRole() == 0){
            login = new DangNhapPanel(this);
            this.add(login );
            
            this.setSize(800,500);
            this.setVisible(true);
        }     
            
    }
    public void submit_dangNhap(){
        
            if(pn != null && pn.isEnabled())
               pn.setVisible(false);
        
            sinhvien_danhsach_menu.addActionListener(sinhvien_danhsach_menu_action);
            phonghoc_danhsach_menu.addActionListener(phonghoc_danhsach_menu_action);
            lophoc_danhsach_menu.addActionListener(lophoc_danhsach_menu_action);
            admin_user_menu.addActionListener(admin_danhsach_menu_action);
           
            
            dangnhap_menu.setLabel("Xin chao " + user.getName());
            dangnhap_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            
            dangnhap.setLabel("Dang nhap");
            dangxuat.setLabel("Dang xuat");
            
            dangxuat.setEnabled(true);
            dangnhap.setEnabled(false);
            
            dangxuat.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dangxuatActionPerformed(evt);
                }
            });
            
            //dangnhap_menu.add(dangnhap);
            dangnhap_menu.add(dangxuat);
    }
    public void submit_dangxuat(){
            user = new User();
            if(pn != null && pn.isEnabled())
               pn.setVisible(false);
            
            sinhvien_danhsach_menu.removeActionListener(sinhvien_danhsach_menu_action);
            phonghoc_danhsach_menu.removeActionListener(phonghoc_danhsach_menu_action);
            lophoc_danhsach_menu.removeActionListener(lophoc_danhsach_menu_action);
            admin_user_menu.removeActionListener(admin_danhsach_menu_action);
 
                      
            dangnhap_menu.setLabel("Ban chua dang nhap! ");
            dangnhap_menu.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
            
            dangnhap.setLabel("Dang nhap");
            dangxuat.setLabel("Dang xuat");
            
            dangnhap.setEnabled(true);
            dangxuat.setEnabled(false);
            
            dangnhap.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dangnhapActionPerformed(evt);
                }
            });
            
            dangnhap_menu.add(dangnhap);
            //dangnhap_menu.add(dangxuat);
    }
    private void xuatmanhinh(){
         mhc_menu = new java.awt.MenuBar();
        dangnhap_menu = new java.awt.Menu();
        dangxuat = new java.awt.MenuItem();
        dangnhap = new java.awt.MenuItem();
        admin_user_menu = new java.awt.Menu();
        user_danhsach_menu = new java.awt.MenuItem();
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
        admin_user_menu.setLabel("Admin Users");
        
        admin_user_menu.setName("");
        
        user_danhsach_menu.setLabel("List");
        
        admin_user_menu.add(user_danhsach_menu);
        

        lophoc_menu.setLabel("Class");

        lophoc_danhsach_menu.setLabel("List");
        
        lophoc_menu.add(lophoc_danhsach_menu);
        

        phonghoc_menu.setLabel("Class rooms");

        phonghoc_danhsach_menu.setLabel("List");
        
        phonghoc_menu.add(phonghoc_danhsach_menu);


        sinhvien_menu.setLabel("Students");
        
        sinhvien_menu.setName("Student List");

        sinhvien_danhsach_menu.setLabel("List");
        
        sinhvien_menu.add(sinhvien_danhsach_menu);
        

        help_menu.setLabel("Help");
        help_menu.setName("");
        
        submit_dangxuat();
        
        mhc_menu.add(dangnhap_menu);
        mhc_menu.add(admin_user_menu);
        mhc_menu.add(lophoc_menu);
        mhc_menu.add(phonghoc_menu);
        mhc_menu.add(sinhvien_menu);
        mhc_menu.add(help_menu);
        
        setMenuBar(mhc_menu);
       
        pack();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mhc_menu = new java.awt.MenuBar();
        dangnhap_menu = new java.awt.Menu();
        dangxuat = new java.awt.MenuItem();
        dangnhap = new java.awt.MenuItem();
        admin_user_menu = new java.awt.Menu();
        user_danhsach_menu = new java.awt.MenuItem();
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

        dangnhap_menu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dangnhap_menu.setLabel("Login");

        dangxuat.setLabel("menuItem1");
        dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangxuatActionPerformed(evt);
            }
        });
        dangnhap_menu.add(dangxuat);

        dangnhap.setLabel("menuItem1");
        dangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangnhapActionPerformed(evt);
            }
        });
        dangnhap_menu.add(dangnhap);

        mhc_menu.add(dangnhap_menu);

        admin_user_menu.setLabel("Admin Users");
        admin_user_menu.setName("");
        admin_user_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_user_menuActionPerformed(evt);
            }
        });

        user_danhsach_menu.setLabel("List");
        user_danhsach_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_danhsach_menuActionPerformed(evt);
            }
        });
        admin_user_menu.add(user_danhsach_menu);

        mhc_menu.add(admin_user_menu);

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
        this.setVisible(true);
    }//GEN-LAST:event_sinhvien_danhsach_menuActionPerformed

    private void phonghoc_danhsach_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonghoc_danhsach_menuActionPerformed
        if(pn != null && pn.isEnabled())
               pn.setVisible(false);
        pn = new DanhSachPanel("ClassRoom List","PhongHoc");
        pn.setVisible(true);
        this.add(pn);
        this.setSize(800,500);
        this.setVisible(true);
    }//GEN-LAST:event_phonghoc_danhsach_menuActionPerformed

    private void lophoc_danhsach_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lophoc_danhsach_menuActionPerformed
        if(pn != null && pn.isEnabled())
               pn.setVisible(false);
        pn = new DanhSachPanel("Class List","lop");
        pn.setVisible(true);
        this.add(pn);
        this.setSize(800,500);
        this.setVisible(true);
    }//GEN-LAST:event_lophoc_danhsach_menuActionPerformed

    private void dangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangxuatActionPerformed
        // TODO add your handling code here:
        this.submit_dangxuat();
    }//GEN-LAST:event_dangxuatActionPerformed

    private void dangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangnhapActionPerformed
        // TODO add your handling code here:
        if(login != null && login.isEnabled())
               login.setVisible(false);
        login = new DangNhapPanel(this);
        login.setVisible(true);
        this.add(login );
        this.setSize(800,500);
        this.setVisible(true);
    }//GEN-LAST:event_dangnhapActionPerformed

    private void admin_user_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_user_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_user_menuActionPerformed

    private void user_danhsach_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_danhsach_menuActionPerformed
        // TODO add your handling code here:
       if(pn != null && pn.isEnabled())
               pn.setVisible(false);
        pn = new DanhSachPanel("User List","Users");
        pn.setVisible(true);
        this.add(pn);
        this.setSize(800,500);
        this.setVisible(true); 
    }//GEN-LAST:event_user_danhsach_menuActionPerformed

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
    private java.awt.Menu admin_user_menu;
    private java.awt.MenuItem dangnhap;
    private java.awt.Menu dangnhap_menu;
    private java.awt.MenuItem dangxuat;
    private java.awt.Menu help_menu;
    private java.awt.MenuItem lophoc_danhsach_menu;
    private java.awt.Menu lophoc_menu;
    private java.awt.MenuBar mhc_menu;
    private java.awt.MenuItem phonghoc_danhsach_menu;
    private java.awt.Menu phonghoc_menu;
    private java.awt.MenuItem sinhvien_danhsach_menu;
    private java.awt.Menu sinhvien_menu;
    private java.awt.MenuItem user_danhsach_menu;
    // End of variables declaration//GEN-END:variables

}
