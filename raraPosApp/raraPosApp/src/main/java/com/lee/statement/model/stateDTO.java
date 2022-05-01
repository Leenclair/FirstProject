/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lee.statement.model;

import java.util.Date;

/**
 *
 * @author my
 */
public class stateDTO {
    private int ordno;
    private String item;
    private String count;
    private String method;
    private double giveMoney;
    private double takeMoney;
    private double revenue;
    private String regdate;

    public stateDTO() {
    }

    public stateDTO(int ordno, String item, String count, String method, double giveMoney, double takeMoney, double revenue, String regdate) {
        this.ordno = ordno;
        this.item = item;
        this.count = count;
        this.method = method;
        this.giveMoney = giveMoney;
        this.takeMoney = takeMoney;
        this.revenue = revenue;
        this.regdate = regdate;
    }

    public int getOrdno() {
        return ordno;
    }

    public void setOrdno(int ordno) {
        this.ordno = ordno;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getGiveMoney() {
        return giveMoney;
    }

    public void setGiveMoney(double giveMoney) {
        this.giveMoney = giveMoney;
    }

    public double getTakeMoney() {
        return takeMoney;
    }

    public void setTakeMoney(double takeMoney) {
        this.takeMoney = takeMoney;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "stateDTO{" + "ordno=" + ordno + ", item=" + item + ", count=" + count + ", method=" + method + ", giveMoney=" + giveMoney + ", takeMoney=" + takeMoney + ", revenue=" + revenue + ", regdate=" + regdate + '}';
    }
    

}
