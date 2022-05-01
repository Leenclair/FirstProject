/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lee.member.model;

/**
 *
 * @author my
 */
public class MemberDTO {
    private String userid;
    private String pwd;
    private String name;
    private String phone;

    public MemberDTO() {
    }

    public MemberDTO(String userid, String pwd, String name, String phone) {
        this.userid = userid;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MemberDTO{" + "userid=" + userid + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + '}';
    }
    
    
}
