/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungc
 */
public class DB {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
        
    String dbURL;
    String username;
    String password;
    
    public DB(){
        dbURL = "jdbc:mysql://localhost:3306/java_student_management";
        username = "root";
        password = "";
    }
    public ResultSet execute(String sql){
            
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null){
                System.out.println("Kết nối thành công");

                System.out.println(sql);
                // Tạo đối tượng thực thi câu lệnh Select
                st = conn.createStatement();
                // Thực thi
                rs = st.executeQuery(sql);
                Vector data = null;
                
                st.closeOnCompletion();
            }
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public boolean update(String sql){
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null){
                System.out.println("Kết nối thành công");
                
                st = conn.createStatement();
                // Thực thi
                st.executeUpdate(sql);
                st.closeOnCompletion();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
