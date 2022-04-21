/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lee.pd.model;

/**
 *
 * @author my
 */
public class PdDTO {
    private String pdname;
    private int pdqty;
    private int pdprice;
    private int pdtotal;

    public PdDTO(String pdname, int pdqty, int pdprice, int pdtotal) {
        this.pdname = pdname;
        this.pdqty = pdqty;
        this.pdprice = pdprice;
        this.pdtotal = pdtotal;
    }
    
    public String getPdname() {
        return pdname;
    }

    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    public int getPdqty() {
        return pdqty;
    }

    public void setPdqty(int pdqty) {
        this.pdqty = pdqty;
    }

    public int getPdprice() {
        return pdprice;
    }

    public void setPdprice(int pdprice) {
        this.pdprice = pdprice;
    }

    public int getPdtotal() {
        return pdtotal;
    }

    public void setPdtotal(int pdtotal) {
        this.pdtotal = pdtotal;
    }

   @Override
    public String toString() {
        return "PdDTO{" + "pdname=" + pdname + ", pdqty=" + pdqty + ", pdprice=" + pdprice + ", pdtotal=" + pdtotal + '}';
    }

    public PdDTO() {
    }

    
    
}
