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
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author tungc
 */
public class Lop implements Serializable{
    
    String url_path;
    ArrayList<Lop> list;
    
    String name;
    String khoahoc, kyhoc;
    PhongHoc phonghoc;
    
    public Lop() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        phonghoc = new PhongHoc();
        
        url_path = java.net.URLDecoder.decode(new File(this.getClass().getResource("files/Lop.txt").getPath()).getAbsolutePath());
        
        
        try{
            FileInputStream fis = new FileInputStream(url_path);     
            ObjectInputStream ois = new ObjectInputStream(fis); 
            list = (ArrayList) ois.readObject();   
            ois.close();
            
        }catch(Exception e){
            
            list = new ArrayList<Lop>();
            
            System.out.println("Khong tim thay lop hoc trong csdl");
        }
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
    public Lop findByClassName(String className) throws IOException, ClassNotFoundException{
        
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getName().equals(className))
                return list.get(i);
        }
        return new Lop();
    }
    public void save() throws IOException, ClassNotFoundException{
        
        list.add(this);
        
        FileOutputStream fos = new FileOutputStream(url_path);
        
        ObjectOutputStream oos = new ObjectOutputStream(fos);
       
        oos.writeObject(list);
            
        oos.close();
    }
    public void update(int index) throws IOException, ClassNotFoundException{
        
        list.get(index).name = name;
        list.get(index).khoahoc = khoahoc;
        list.get(index).kyhoc = kyhoc;
        list.get(index).phonghoc = phonghoc;
        
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
