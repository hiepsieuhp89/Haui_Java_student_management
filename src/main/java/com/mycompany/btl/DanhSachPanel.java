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
public class DanhSachPanel extends java.awt.Panel {
    
    String[] role = new String[]{"Không chức vụ", "Quản trị viên", "Giáo viên"};
    
    ArrayList<SinhVien> listSv;
    ArrayList<PhongHoc> listPh;
    ArrayList<Lop> listLop;
    ArrayList<User> listUser;
    
    String model;
    String[] columnName;
    ThemFrame add;
    SuaFrame edit;
    /**
     * Creates new form DanhSachPanel
     */
    public DanhSachPanel(String lb, String tble) {        
        model = tble;      
        initComponents();
        danhsach_label.setText(lb);
        danhsach_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event) {
                        String textArea = "";
                        for(int i = 0; i < columnName.length; i++){
                            textArea += columnName[i] + ": " + danhsach_table.getValueAt(danhsach_table.getSelectedRow(), i).toString() + "\n";
                        } 
                        hienthi.setText(textArea);
                        xoa_btn.setEnabled(true);
                        sua_btn.setEnabled(true);
                    }
                });
        UpdateModel();
    }
    void UpdateModel(){
        danhsach_table.repaint(); 
        xoa_btn.setEnabled(false);
        sua_btn.setEnabled(false);
        
        if(model == "SinhVien"){
            columnName = new String[]{"Id","Mã sinh viên","Họ tên","Tuổi", "Năm Sinh", "Quê Quán", "Lớp", "Khóa học", "Kỳ học"};
            try{
                listSv = new SinhVien().docdulieu();
                DefaultTableModel dtm = new DefaultTableModel(new String[]{"Id","Mã","Họ tên","Tuổi", "Năm Sinh", "Quê Quán", "Lớp", "Khóa học", "Kỳ học"},0);
                for(int i = 0; i < listSv.size();i++){
                    System.out.println(listSv.get(i).getName());
                    dtm.addRow(new Object[]{
                        listSv.get(i).getId(),
                        listSv.get(i).getCode(),
                        listSv.get(i).getName(),
                        listSv.get(i).getAge(),
                        listSv.get(i).getBirthyear(),
                        listSv.get(i).getAddress(),
                        listSv.get(i).getLop().getName(),
                        listSv.get(i).getLop().getKhoahoc(),
                        listSv.get(i).getLop().getKyhoc(),
                    });
                }
                danhsach_table.setModel(dtm);
                
            }
            catch(Exception e){}
        }
        if(model == "PhongHoc"){
            columnName = new String[]{"Id","Số phòng","Tên Phòng","Loại phòng"};
            try{
                listPh = new PhongHoc().docdulieu();
                DefaultTableModel dtm = new DefaultTableModel(new String[]{"Id","Số phòng","Tên Phòng","Loại phòng"},0);
                for(int i = 0; i < listPh.size();i++){
                    dtm.addRow(new Object[]{
                        listPh.get(i).getId(),
                        listPh.get(i).getSophong(),
                        listPh.get(i).getTenphong(),
                        listPh.get(i).getLoaiphong(),
                    });
                }
                danhsach_table.setModel(dtm);
                
            }
            catch(Exception e){}
        }
        if(model == "lop"){
            columnName = new String[]{"Id","Tên lớp","Khóa học","Kỳ học","Lớp học"};
            try{
                listLop = new Lop().docdulieu();
                DefaultTableModel dtm = new DefaultTableModel(new String[]{"Id","Tên lớp","Khóa học","Kỳ học","Lớp học"},0);
                for(int i = 0; i < listLop.size();i++){
                    dtm.addRow(new Object[]{
                        listLop.get(i).getId(),
                        listLop.get(i).getName(),
                        listLop.get(i).getKhoahoc(),
                        listLop.get(i).getKyhoc(),
                        listLop.get(i).getPhonghoc().getSophong(),
                    });
                }
                danhsach_table.setModel(dtm);
                
            }
            catch(Exception e){}
        }
        if(model == "Users"){
            columnName = new String[]{"Id","Tên hiển thị","Tên tài khoản","Mật khẩu","Chức vụ"};
            try{
                listUser = new User().docdulieu();
                DefaultTableModel dtm = new DefaultTableModel(new String[]{"Id","Tên hiển thị","Tên tài khoản","Mật khẩu","Chức vụ"},0);
                for(int i = 0; i < listUser.size();i++){
                    dtm.addRow(new Object[]{
                        listUser.get(i).getId(),
                        listUser.get(i).getName(),
                        listUser.get(i).getUsername(),
                        listUser.get(i).getPassword(),
                        role[(int)listUser.get(i).getRole()]
                    });
                }
                danhsach_table.setModel(dtm);
                
            }
            catch(Exception e){}
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_group = new java.awt.Panel();
        danhsach_label = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        javax.swing.JScrollPane hocsinh_scroll_table = new javax.swing.JScrollPane();
        danhsach_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        sua_btn = new java.awt.Button();
        them_btn = new java.awt.Button();
        xoa_btn = new java.awt.Button();
        thoat_btn = new java.awt.Button();
        keyword = new java.awt.TextField();
        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hienthi = new java.awt.TextArea();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_group.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(button_group, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 820, -1));

        danhsach_label.setAlignment(java.awt.Label.CENTER);
        danhsach_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        danhsach_label.setMinimumSize(new java.awt.Dimension(62, 30));
        danhsach_label.setName(""); // NOI18N
        danhsach_label.setPreferredSize(new java.awt.Dimension(800, 23));
        danhsach_label.setText("Title");
        add(danhsach_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Table"));

        hocsinh_scroll_table.setPreferredSize(new java.awt.Dimension(500, 260));

        danhsach_table.setBackground(new java.awt.Color(204, 255, 204));
        danhsach_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        danhsach_table.setPreferredSize(new java.awt.Dimension(500, 300));
        hocsinh_scroll_table.setViewportView(danhsach_table);

        jPanel2.add(hocsinh_scroll_table);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 540, 300));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sua_btn.setBackground(new java.awt.Color(240, 240, 240));
        sua_btn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sua_btn.setForeground(new java.awt.Color(102, 153, 255));
        sua_btn.setLabel("Edit");
        sua_btn.setName(""); // NOI18N
        sua_btn.setPreferredSize(new java.awt.Dimension(70, 40));
        sua_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua_btnActionPerformed(evt);
            }
        });
        jPanel1.add(sua_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        them_btn.setBackground(new java.awt.Color(240, 240, 240));
        them_btn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        them_btn.setForeground(new java.awt.Color(0, 153, 51));
        them_btn.setLabel("Add");
        them_btn.setPreferredSize(new java.awt.Dimension(70, 40));
        them_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them_btnActionPerformed(evt);
            }
        });
        jPanel1.add(them_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        xoa_btn.setBackground(new java.awt.Color(240, 240, 240));
        xoa_btn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        xoa_btn.setForeground(new java.awt.Color(204, 51, 0));
        xoa_btn.setLabel("Delete");
        xoa_btn.setPreferredSize(new java.awt.Dimension(70, 40));
        xoa_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa_btnActionPerformed(evt);
            }
        });
        jPanel1.add(xoa_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        thoat_btn.setBackground(new java.awt.Color(240, 240, 240));
        thoat_btn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        thoat_btn.setLabel("Exit");
        thoat_btn.setPreferredSize(new java.awt.Dimension(70, 40));
        thoat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat_btnActionPerformed(evt);
            }
        });
        jPanel1.add(thoat_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        keyword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(keyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, -1));

        button1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button1.setLabel("Find");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 50, 20));

        jLabel1.setText("Type name, id or anything");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 760, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Show"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(hienthi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 270));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 210, 300));
    }// </editor-fold>//GEN-END:initComponents

    private void thoat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat_btnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_thoat_btnActionPerformed

    private void them_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them_btnActionPerformed
        // TODO add your handling code here:
        if(model == "SinhVien"){
            if(add == null || !add.isVisible()){
                    
                try {
                    
                    ArrayList<Lop> phs;
                    phs = new Lop().docdulieu();
                    String[] tenlop = new String[phs.size()+1];
                    
                    tenlop[0] = "Class";
                            
                    for(int i = 0;i < phs.size();i++){
                        tenlop[i+1] = phs.get(i).getName();
                    }
                    String[] choice_input = tenlop;
                    
                    String[][] input = {
                        {"code", "Student code"},
                        {"name", "Name"},
                        {"age", "Age"},
                        {"birthyear", "Birth-Year"},
                        {"address", "Address"},
                    };
                    
                    add = new ThemFrame("SinhVien","Thêm Sinh Viên",input, this, new SinhVien().list.size(),choice_input);
                    add.setLocation(200,200);
                    add.setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DanhSachPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                add.setVisible(true);
                add.toFront();
                add.requestFocus();
            }
        }
        if(model == "PhongHoc"){
            if(add == null || !add.isVisible()){
                String[][] input = {
                    {"sophong", "Room code"},
                    {"tenphong", "Room name"},
                    {"loaiphong", "Room type"},
                };
                add = new ThemFrame("PhongHoc","Thêm Phòng học",input, this, new PhongHoc().list.size(),null);
                add.setLocation(200,200);
                add.setVisible(true);
            }
            else{
                add.setVisible(true);
                add.toFront();
                add.requestFocus();
            }
        }
        if(model == "lop"){
            if(add == null || !add.isVisible()){
                ArrayList<PhongHoc> phs = new PhongHoc().docdulieu();
                String[] tenphonghoc = new String[phs.size()+1];
                tenphonghoc[0] = "Class Room";
                for(int i = 0;i < phs.size();i++){
                    tenphonghoc[i+1] = phs.get(i).getSophong();
                }
                String[] choice_input = tenphonghoc;
                String[][] input = {
                    {"name", "Class name"},
                    {"khoahoc", "Course"},
                    {"kyhoc", "Semester"},
                };
                add = new ThemFrame("Lop","Thêm Lớp học", input, this, new Lop().list.size(),choice_input);
                add.setLocation(200,200);
                add.setVisible(true);
            }
            else{
                add.setVisible(true);
                add.toFront();
                add.requestFocus();
            }
        }
        if(model == "Users"){
            if(add == null || !add.isVisible()){
                String[][] input = {
                    {"name", "Full name"},
                    {"username", "Username"},
                    {"password", "Passwod"},
                };
                String[] choice_input = new String[]{"Role","Không chức vụ", "Quản trị viên", "Giáo viên"};
                add = new ThemFrame("Users","Thêm tài khoản",input, this, new User().list.size(),choice_input);
                add.setLocation(200,200);
                add.setVisible(true);
            }
            else{
                add.setVisible(true);
                add.toFront();
                add.requestFocus();
            }
        }
    }//GEN-LAST:event_them_btnActionPerformed

    private void xoa_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa_btnActionPerformed
        // TODO add your handling code here:
        Dialog d = new Dialog(MHC.ManHinhChinh,"Alert",true);
        d.setLayout(new FlowLayout());  
        Button close_btn = new Button("Confirm");
        close_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(model == "PhongHoc")
                    new PhongHoc().delete((int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0));
                if(model == "lop")
                   new Lop().delete((int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0));
                if(model == "SinhVien")
                   new SinhVien().delete((int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0));
                if(model == "Users")
                   new User().delete((int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0));
                    
                UpdateModel();
                d.setVisible(false); 
            }
        });
        d.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                d.setVisible(false);
            }
        });
        d.setSize(250,100);
        d.setLocation((int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY() - 150);
        d.add(new Label("Are you sure want to delete this record?"));
        d.add(close_btn);
        d.setVisible(true);
    }//GEN-LAST:event_xoa_btnActionPerformed

    private void sua_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua_btnActionPerformed
        // TODO add your handling code here:
        if(model == "Users"){
            if(edit == null || !edit.isVisible()){     
                String[] choice_input = new String[]{"Role","Không chức vụ", "Quản trị viên", "Giáo viên"};
                String[][] input = {
                    {"name", "Full name",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 1).toString()},
                    {"username", "Username",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 2).toString()},
                    {"password", "Passwod",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 3).toString()},
                };

                edit = new SuaFrame("Users","Sửa thông tin người dùng",input, this, (int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0),choice_input);
                edit.setLocation(200,200);
                edit.setVisible(true);
            }
            else{
                edit.setVisible(true);
                edit.toFront();
                edit.requestFocus();   
            }
        }
        if(model == "SinhVien"){
            if(edit == null || !edit.isVisible()){     
                try {
                    ArrayList<Lop> phs;
                    phs = new Lop().docdulieu();
                    String[] tenlop = new String[phs.size()+1];
                    
                    tenlop[0] = "Class";
                            
                    for(int i = 0;i < phs.size();i++){
                        tenlop[i+1] = phs.get(i).getName();
                    }
                    String[] choice_input = tenlop;
                    String[][] input = {
                        {"code", "Student code",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 1).toString()},
                        {"name", "Name",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 2).toString()},
                        {"age", "Age",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 3).toString()},
                        {"birthyear", "Birth-Year",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 5).toString()},
                        {"address", "Address",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 4).toString()},
                    };

                    edit = new SuaFrame("SinhVien","Sửa Sinh Viên",input, this, (int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0),choice_input);
                    edit.setLocation(200,200);
                    edit.setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DanhSachPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                edit.setVisible(true);
                edit.toFront();
                edit.requestFocus();               
            }
        }
        if(model == "PhongHoc"){
            if(edit == null || !edit.isVisible()){
                
                String[][] input = {
                    {"sophong", "Room code", danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 1).toString()},
                    {"tenphong", "Room name", danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 2).toString()},
                    {"loaiphong", "Room type", danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 3).toString()},
                };
                    
                edit = new SuaFrame("PhongHoc","Sửa Phòng học",input, this, (int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0),null);
                edit.setLocation(200,200);
                edit.setVisible(true);
               
            }
            else{
                edit.setVisible(true);
                edit.toFront();
                edit.requestFocus();               
            }
        }
        if(model == "lop"){
            if(edit == null || !edit.isVisible()){
                
                    ArrayList<PhongHoc> phs = new PhongHoc().docdulieu();
                    
                    String[] tenphonghoc = new String[phs.size()+1];
                    
                    tenphonghoc[0] = "Class Room";
                    //tenphonghoc[1] = new PhongHoc().findByRoomNumber(danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 3).toString()).getSophong();
                    
                    for(int i = 0;i < phs.size();i++){
                        //if(!phs.get(i).getSophong().equals(tenphonghoc[1]))
                            tenphonghoc[i+1] = phs.get(i).getSophong();
                    }
                    
                    String[] choice_input = tenphonghoc;
                    
                    String[][] input = {
                        {"name", "Class name",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 1).toString()},
                        {"khoahoc", "Course",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 2).toString()},
                        {"kyhoc", "Semester",danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 3).toString()},
                    };
                    
                    edit = new SuaFrame("Lop","Sửa Lớp học", input, this, (int)danhsach_table.getValueAt(danhsach_table.getSelectedRow(), 0),choice_input);
                    edit.setLocation(200,200);
                    edit.setVisible(true);
               
            }
            else{
                edit.setVisible(true);
                edit.toFront();
                edit.requestFocus();               
            }
            
        }
    }//GEN-LAST:event_sua_btnActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        if(model == "SinhVien"){
            danhsach_table.repaint(); 
            xoa_btn.setEnabled(false);
            sua_btn.setEnabled(false);
            try{
                listSv = new SinhVien().findByKeyWord(keyword.getText());
                DefaultTableModel dtm = new DefaultTableModel(new String[]{"Id","Mã","Họ tên","Tuổi", "Năm Sinh", "Quê Quán", "Lớp", "Khóa học", "Kỳ học"},0);
                for(int i = 0; i < listSv.size();i++){
                    System.out.println(listSv.get(i).getName());
                    dtm.addRow(new Object[]{
                        listSv.get(i).getId(),
                        listSv.get(i).getCode(),
                        listSv.get(i).getName(),
                        listSv.get(i).getAge(),
                        listSv.get(i).getBirthyear(),
                        listSv.get(i).getAddress(),
                        listSv.get(i).getLop().getName(),
                        listSv.get(i).getLop().getKhoahoc(),
                        listSv.get(i).getLop().getKyhoc(),
                    });
                }
                danhsach_table.setModel(dtm);
            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Panel button_group;
    private java.awt.Label danhsach_label;
    private javax.swing.JTable danhsach_table;
    private java.awt.TextArea hienthi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.TextField keyword;
    private java.awt.Button sua_btn;
    private java.awt.Button them_btn;
    private java.awt.Button thoat_btn;
    private java.awt.Button xoa_btn;
    // End of variables declaration//GEN-END:variables
}
