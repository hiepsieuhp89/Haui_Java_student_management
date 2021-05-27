/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;

import java.io.*;
import java.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tungc
 */
public class Lop implements Serializable{
    
    String table = "class";
    
    String url_path;
    ArrayList<Lop> list;
    
    int id;
    String name;
    String khoahoc, kyhoc;
    PhongHoc phonghoc;
    
    public Lop(int _id, String _name, String _khoahoc, String _kyhoc, PhongHoc _phonghoc){
        id = _id;
        name = _name;
        khoahoc = _khoahoc;
        kyhoc = _kyhoc;
        phonghoc = _phonghoc;
    }
    public Lop(){
       
        phonghoc = new PhongHoc();
        try{
            String sql = "select * from "+this.table;
            
            //đọc bảng student
            ResultSet rs = new DB().execute(sql);
            
            Vector data = null;
            
            // Nếu không có lop nào
            if (rs.isBeforeFirst() == false) {
                rs.next();
                list = new ArrayList<Lop>();            
                System.out.println("Khong tim thay lop trong csdl");
            }
            else{
                list = new ArrayList<Lop>();  
                
                while(rs.next()){
                    //Lop lop = 
                    list.add(new Lop(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("khoahoc"),
                        rs.getString("kyhoc"),
                        new PhongHoc().findById(rs.getInt("phonghocId"))
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
    public PhongHoc getPhonghoc() {
        return phonghoc;
    }

    public void setPhonghoc(PhongHoc phonghoc) {
        this.phonghoc = phonghoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(String khoahoc) {
        this.khoahoc = khoahoc;
    }

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }
    public ArrayList<Lop> docdulieu() throws IOException, ClassNotFoundException{       
        return list;
    }
    public Lop findById(int _id) throws IOException, ClassNotFoundException{
        
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getId() == _id)
                return list.get(i);
        }
        return new Lop();
    }
    public Lop findByClassName(String className){
        
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getName().equals(className))
                return list.get(i);
        }
        return new Lop();
    }
    public boolean save(){
        try{
            String sql = "insert into " + this.table + "(`name`,`khoahoc`,`kyhoc`,`phonghocId`) values (\""+ this.name +"\",\""+ this.khoahoc +"\",\""+ this.kyhoc +"\","+ this.getPhonghoc().getId() +")";         
            list.add(this);
            return new DB().update(sql);
            
        }catch(Exception e){}
        return false;
    }
    public boolean update(int index){
        try{
            String sql = "update " + this.table + " set name = \"" + this.name + "\", khoahoc = \"" + this.khoahoc +"\", kyhoc = \"" + this.kyhoc +"\", phonghocId = " + this.getPhonghoc().getId() + " where id = " + index;
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
