/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 *
 * @author tungc
 */
public class SinhVien extends Nguoi implements Serializable{
    String name, age, address, birthyear;
    String url_path;
    ArrayList<SinhVien> list;
    
    String code;
    Lop lop;
    
    public SinhVien() throws FileNotFoundException, IOException, ClassNotFoundException{
        lop = new Lop();
        
        url_path = java.net.URLDecoder.decode(new File(this.getClass().getResource("files/SinhVien.txt").getPath()).getAbsolutePath());
        try{
            FileInputStream fis = new FileInputStream(url_path);     
            ObjectInputStream ois = new ObjectInputStream(fis); 
            list = (ArrayList) ois.readObject();   
            ois.close();
            
        }catch(Exception e){
            
            list = new ArrayList<SinhVien>();            
            System.out.println("Khong tim thay sinh vien trong csdl");
        }
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
    
    public ArrayList<SinhVien> docdulieu() throws IOException, ClassNotFoundException{      
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
        
        list.get(index).name = name;
        list.get(index).age = age;
        list.get(index).address = address;
        list.get(index).birthyear = birthyear;
        list.get(index).code = code;
        list.get(index).lop = lop;
        
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
