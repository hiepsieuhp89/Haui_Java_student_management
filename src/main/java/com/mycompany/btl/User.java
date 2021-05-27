/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tungc
 */
public class User implements Serializable {
    
    String[] roles = new String[]{"Không chức vụ", "Quản trị viên", "Giáo viên"};
    
    String table = "users";
    ArrayList<User> list;
    
    int id;
    String username, password, name;
    int role;
    public User(int _id, String _username, String _password, String _name ,int _role){
        id = _id;
        name = _name;
        username = _username;
        password = _password;
        role = _role;
    }
    public User(){ 
        role = 0;
        try{
            String sql = "select * from "+this.table;
            
            //đọc bảng student
            ResultSet rs = new DB().execute(sql);
            
            Vector data = null;
            
            if (rs.isBeforeFirst() == false) {
                rs.next();
                list = new ArrayList<User>();            
            }
            else{
                list = new ArrayList<User>();  
                
                while(rs.next()){
                    //Lop lop = 
                    list.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("role")
                    ));
                }
            }
            
        }catch(Exception e){}
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }
    
    public void setRole(String _role) {
        System.out.println(_role);
        int i;
        for(i = 0; i < roles.length; i++){
            if(_role.equals(roles[i]))
                break;
        }
        this.role = i;
    }
    public ArrayList<User> docdulieu(){
        return list;
    }
    public boolean Validate(){
        if(username.trim() == "" || username.length() < 1 || password.trim() == "" || password.length() < 1){
             return false;
        }
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbURL = "jdbc:mysql://localhost:3306/java_student_management";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
             System.out.println("Kết nối thành công");
            }
            // Câu lệnh xem dữ liệu
            String sql = "select * from users where username = \""+ this.username + "\" and password = \""+ this.password + "\"";
            System.out.println(sql);
            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();
            // Thực thi
            rs = st.executeQuery(sql);
            Vector data = null;
            
            // Nếu tài khoản tồn tại
            if (rs.isBeforeFirst() == true) {
                rs.next();
                this.name= rs.getString("name");
                this.role = rs.getInt("role");
                return true;
            }
        } catch (Exception e) {e.printStackTrace();}
        
        return false;
    }   
    public boolean save() {
        try{
            String sql = "insert into " + this.table + "(`username`,`password`,`name`,`role`) values (\""+ this.username +"\",\""+ this.password +"\",\""+ this.name + "\","+ this.role +")";         
            list.add(this);
            return new DB().update(sql);
            
        }catch(Exception e){}
        return false;
    }
    public boolean update(int index){
        try{
            String sql = "update " + this.table + " set username = \"" + this.username + "\", password = \"" + this.password +"\", name = \"" + this.name + "\" where id = " + index;
            return new DB().update(sql);
            
        }catch(Exception e){}
        return false;
    }
    public boolean delete(int index){
        try{
            
            String sql = "delete from " + this.table + " where id = " + index;
            return new DB().update(sql);
            
        }catch(Exception e){}
        return false;
    }
}
