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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tungc
 */
public class SinhVien extends Nguoi implements Serializable{
    String table = "students";
    
    int id;
    String name, age, address, birthyear;
    
    ArrayList<SinhVien> list;
    
    String code;
    Lop lop;
    
    public SinhVien(int _id, String _name, String _age, String _address, String _birthyear, String _code, Lop _lop){
        id = _id;
        name = _name;
        age = _age;
        address = _address;
        birthyear = _birthyear;
        code = _code;
        lop = _lop;
    }
    public SinhVien(){
        
        lop = new Lop();      
        //url_path = java.net.URLDecoder.decode(new File(this.getClass().getResource("files/SinhVien.txt").getPath()).getAbsolutePath());
        try{
            String sql = "select * from "+this.table;
            
            //đọc bảng student
            ResultSet rs = new DB().execute(sql);
            
            Vector data = null;
            
            // Nếu không có sinh viên nào
            if (rs.isBeforeFirst() == false) {
                rs.next();
                list = new ArrayList<SinhVien>();            
                System.out.println("Khong tim thay sinh vien trong csdl");
            }
            else{
                list = new ArrayList<SinhVien>();  
                
                while(rs.next()){
                    //Lop lop = 
                    list.add(new SinhVien(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("address"),
                        rs.getString("birthyear"),
                        rs.getString("code"),
                        new Lop().findById(rs.getInt("classId"))
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public ArrayList<SinhVien> getList() {
        return list;
    }

    public void setList(ArrayList<SinhVien> list) {
        this.list = list;
    }
    
    public ArrayList<SinhVien> docdulieu(){      
        return list;
    }
    public ArrayList<SinhVien> findByKeyWord(String kw){
        try{
            String sql = "select * from "+this.table+" inner join class on "+this.table+".classId = class.id where code like \"%"+kw+"%\" or students.name like \"%"+kw+"%\" or address like \"%"+kw+"%\" or age like \""+kw+"\" or class.name like \"%"+kw+"%\"";
            
            //đọc bảng student
            ResultSet rs = new DB().execute(sql);
            
            Vector data = null;
            
            // Nếu không có sinh viên nào
            if (rs.isBeforeFirst() == false) {
                rs.next();
                list = new ArrayList<SinhVien>();            
                System.out.println("Khong tim thay sinh vien trong csdl");
            }
            else{
                list = new ArrayList<SinhVien>();  
                
                while(rs.next()){
                    //Lop lop = 
                    list.add(new SinhVien(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("address"),
                        rs.getString("birthyear"),
                        rs.getString("code"),
                        new Lop().findById(rs.getInt("classId"))
                    ));
                }
            }
            return list;
        }catch(Exception e){}
        
        return list;
    }
    public boolean save() {
        try{
            String sql = "insert into " + this.table + "(`name`,`age`,`address`,`code`,`birthyear`,`classId`) values (\""+ this.name +"\",\""+ this.age +"\",\""+ this.address +"\",\""+ this.code+"\",\""+ this.birthyear+"\","+ this.getLop().getId()+")";         
            list.add(this);
            return new DB().update(sql);
            
        }catch(Exception e){}
        return false;
    }
    public boolean update(int index){
        try{
            String sql = "update " + this.table + " set name = \"" + this.name + "\", age = \"" + this.age +"\", address = \"" + this.address +"\", code = \"" + this.code + "\", birthyear = \"" + this.birthyear + "\", classId = " + this.getLop().getId() + " where id = " + index;
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
