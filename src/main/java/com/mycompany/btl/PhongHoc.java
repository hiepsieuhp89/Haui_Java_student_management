/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author tungc
 */
public class PhongHoc implements Serializable {
    String table = "classrooms";
    
    ArrayList<PhongHoc> list;
    
    int id;
    String sophong;
    String tenphong;
    String loaiphong;
    
    public PhongHoc(int _id, String _sophong, String _tenphong, String _loaiphong){
        id = _id;
        sophong = _sophong;
        tenphong = _tenphong;
        loaiphong = _loaiphong;
    }
    public PhongHoc(){
        
        try{
            String sql = "select * from " + this.table;
            
            //đọc bảng student
            ResultSet rs = new DB().execute(sql);
            
            Vector data = null;
            
            // Nếu không có phong nào
            if (rs.isBeforeFirst() == false) {
                rs.next();
                list = new ArrayList<PhongHoc>();            
                System.out.println("Khong tim thay phong hoc trong csdl");
            }
            else{
                list = new ArrayList<PhongHoc>();  
                
                while(rs.next()){
                    //Lop lop = 
                    list.add(new PhongHoc(
                        rs.getInt("id"),
                        rs.getString("sophong"),
                        rs.getString("tenphong"),
                        rs.getString("loaiphong")
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
    
    public String getSophong() {
        return sophong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public void setSophong(String sophong) {
        this.sophong = sophong;
    }
    public PhongHoc findById(int _id) throws IOException, ClassNotFoundException{
        
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getId() == _id)
                return list.get(i);
        }
        return new PhongHoc();
    }
    public PhongHoc findByRoomNumber(String number) throws IOException, ClassNotFoundException{
        
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getSophong().equals(number ))
                return list.get(i);
        }
        return new PhongHoc();
    }
    public ArrayList<PhongHoc> docdulieu(){
        return list;
    }
    public boolean save(){
        try{
            String sql = "insert into " + this.table + "(`sophong`,`tenphong`,`loaiphong`) values (\""+ this.sophong +"\",\""+ this.tenphong +"\",\""+ this.loaiphong +"\")";         
            list.add(this);
            return new DB().update(sql);
            
        }catch(Exception e){}
        return false;
    }
    public boolean update(int index){ 
        try{
            String sql = "update " + this.table + " set sophong = \"" + this.sophong + "\", tenphong = \"" + this.tenphong +"\", loaiphong = \"" + this.loaiphong +"\"" + " where id = " + index;
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
