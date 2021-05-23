/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl;

import java.util.ArrayList;

/**
 *
 * @author tungc
 */
public class NganhHoc {
    String name;
    MonHoc[] mh;
    int somonhoc;
    ArrayList<SinhVien> list;
    
    public NganhHoc(int n){
        somonhoc = n;
        for(int i = 0;i < n;i++){
            mh[i] = new MonHoc();
        }
    }
    public NganhHoc(){
        somonhoc = 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonHoc[] getMh() {
        return mh;
    }

    public void setMh(MonHoc[] mh) {
        this.mh = mh;
    }

    public int getSomonhoc() {
        return somonhoc;
    }

    public void setSomonhoc(int somonhoc) {
        this.somonhoc = somonhoc;
    }
    
    
}
