/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungc
 */
public class PhongHoc implements Serializable {
    String url_path;
    ArrayList<PhongHoc> list;
    
    String sophong;
    String tenphong;
    String loaiphong;
    
    public PhongHoc() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        url_path = java.net.URLDecoder.decode(new File(this.getClass().getResource("files/PhongHoc.txt").getPath()).getAbsolutePath());
        try{
            FileInputStream fis = new FileInputStream(url_path);     
            ObjectInputStream ois = new ObjectInputStream(fis); 
            list = (ArrayList) ois.readObject();   
            ois.close();
            
        }catch(Exception e){
            
            list = new ArrayList<PhongHoc>();
            
            System.out.println("Khong tim thay phong hoc trong csdl");
        }
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
    public PhongHoc findByRoomNumber(String number) throws IOException, ClassNotFoundException{
        
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getSophong().equals(number ))
                return list.get(i);
        }
        return new PhongHoc();
    }
    public ArrayList<PhongHoc> docdulieu() throws IOException, ClassNotFoundException{
        return list;
    }
    public void save() throws IOException, ClassNotFoundException{
        
        list.add(this);
        
        FileOutputStream fos = new FileOutputStream(url_path);
        
        ObjectOutputStream oos = new ObjectOutputStream(fos);
       
        oos.writeObject(list);
            
        oos.close();
    }
    public void update(int index) throws IOException, ClassNotFoundException{
        
        list.get(index).sophong = sophong;
        list.get(index).loaiphong = loaiphong;
        list.get(index).tenphong = tenphong;
        
        FileOutputStream fos = new FileOutputStream(url_path);
        
        ObjectOutputStream oos = new ObjectOutputStream(fos);
       
        oos.writeObject(list);
            
        oos.close();
    }
    public void delete(int index) throws IOException, ClassNotFoundException{
        
        list.remove(index);
        
        FileOutputStream fos = new FileOutputStream(url_path);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(list);
            
        oos.close();
    }
}
