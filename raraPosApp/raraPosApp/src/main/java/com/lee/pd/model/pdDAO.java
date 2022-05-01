/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lee.pd.model;

import com.db.DBUtil;
import com.lee.statement.model.stateDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author my
 */
public class pdDAO {

    public PdDTO selectPdName(String pdname) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        
        try{
            con = DBUtil.getConnection();
            String sql="select pdname,pdqty,pdprice,pdtotal from bill where pdname=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, pdname);
            
            rs=ps.executeQuery();
            PdDTO dto=new PdDTO();
            if(rs.next()){
                String pdName=rs.getString(1);
                int qty=rs.getInt(2);
                int price=rs.getInt(3);
                int total=rs.getInt(4);
                
                dto.setPdname(pdName);
                dto.setPdqty(qty);
                dto.setPdprice(price);
                dto.setPdtotal(total);
            }
            System.out.println("선택된 결과="+dto+"매개변수="+pdname);
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public List<PdDTO> showPdData() throws SQLException, SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<PdDTO> list=new ArrayList<>();
        try{
            con=DBUtil.getConnection();
            String sql="select * from bill";
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            while(rs.next()){
                String pdname=rs.getString(1);
                int pdqty=rs.getInt(2);
                int pdprice=rs.getInt(3);
                int pdtotal=rs.getInt(4);
                
                PdDTO dto=new PdDTO(pdname, pdqty, pdprice, pdtotal);
                list.add(dto);
            }
            System.out.println("선택된 결과 list.size="+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public int register(String pdName, int pdPrice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            con=DBUtil.getConnection();
            String sql="insert into bill(pdname, pdqty, pdprice, pdtotal) values (?,1,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, pdName);
            ps.setInt(2, pdPrice);
            ps.setInt(3, pdPrice);
            int result=ps.executeUpdate();
            System.out.println("업데이트 갯수="+result+", 매개변수="+pdName+","+pdPrice);
            return result;
        }
        finally{
            DBUtil.dbClose(ps, con);
        }
    }

    public PdDTO selectByName(String pdName) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try{
            con=DBUtil.getConnection();
            String sql="select * from bill where pdname=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, pdName);
            
            rs=ps.executeQuery();
            PdDTO dto=new PdDTO();
            while(rs.next()){
                int qty=rs.getInt(2);
                int pdPrice=rs.getInt(3);
                int pdTotal=rs.getInt(4);
                
                dto.setPdname(pdName);
                dto.setPdqty(qty);
                dto.setPdprice(pdPrice);
                dto.setPdtotal(pdTotal);
                
            }
            System.out.println("검색된 상품:"+dto+", 매개변수:"+pdName);
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    
    
    }

    public int edit(String pdName, int pdPrice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            con=DBUtil.getConnection();
            String sql="update bill set pdname=?, pdprice=? where pdname=?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, pdName);
            ps.setInt(2, pdPrice);
            ps.setString(3, pdName);
            
            int result=ps.executeUpdate();
            System.out.println("업데이트 갯수="+result+", 매개변수="+pdName+","+pdPrice);
            return result;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }

    public int deleteData(String pdName) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            con=DBUtil.getConnection();
            String sql="delete from bill where pdname=?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, pdName);
            
            int result=ps.executeUpdate();
            System.out.println("삭제처리 갯수="+result+", 매개변수="+pdName);
            return result;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    
    
}
