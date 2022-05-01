/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lee.statement.model;

import com.db.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author my
 */
public class stateDAO {

    public static int save(stateDTO dto) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            con=DBUtil.getConnection();
            String sql = "INSERT INTO orderbox VALUES (ORDERBOX_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, dto.getItem());
            ps.setString(2, dto.getCount());
            ps.setString(3, dto.getMethod());
            ps.setDouble(4, dto.getGiveMoney());
            ps.setDouble(5, dto.getTakeMoney());
            ps.setDouble(6, dto.getRevenue());
            ps.setString(7, dto.getRegdate());

            int result=ps.executeUpdate();
            return result;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public List<stateDTO> showAllData() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<stateDTO> list = new ArrayList<>();
        try{
            con=DBUtil.getConnection();
            String sql="select * from orderbox order by ordno desc";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                int ordno=rs.getInt(1);
                String item=rs.getString(2);
                String count=rs.getString(3);
                String method=rs.getString(4);
                int giveMoney=rs.getInt(5);
                int takeMoney=rs.getInt(6);
                int revenue=rs.getInt(7);
                String regdate=rs.getString(8);
                
                stateDTO stateDto=new stateDTO(ordno, item, count, method, giveMoney, takeMoney, revenue,regdate);
                list.add(stateDto);
            }
                System.out.println("상품전체 조회 결과 list.size="+list.size());
                return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public List<stateDTO> SelectDate(String regdate) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<stateDTO> list = new ArrayList<>();
        try{
            con=DBUtil.getConnection();
            String sql="select * from orderbox where regdate like '%'||?||'%' order by ordno desc";
            ps=con.prepareStatement(sql);
            ps.setString(1, regdate);
            rs=ps.executeQuery();
            
            while(rs.next()){
                int ordno=rs.getInt(1);
                String item=rs.getString(2);
                String count=rs.getString(3);
                String method=rs.getString(4);
                int giveMoney=rs.getInt(5);
                int takeMoney=rs.getInt(6);
                int revenue=rs.getInt(7);
                String regdate2=rs.getString(8);
                
                stateDTO stateDto=new stateDTO(ordno, item, count, method, giveMoney, takeMoney, revenue,regdate2);
                list.add(stateDto);
            }
                System.out.println("상품전체 조회 결과 list.size="+list.size()+", 매개변수="+regdate);
                return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public List<stateDTO> SelectNo(int orderNo) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<stateDTO> list = new ArrayList<>();
        try{
            con=DBUtil.getConnection();
            String sql="select * from orderbox where ordno=? order by ordno desc";
            ps=con.prepareStatement(sql);
            ps.setInt(1, orderNo);
            rs=ps.executeQuery();
            
            while(rs.next()){
                int ordno=rs.getInt(1);
                String item=rs.getString(2);
                String count=rs.getString(3);
                String method=rs.getString(4);
                int giveMoney=rs.getInt(5);
                int takeMoney=rs.getInt(6);
                int revenue=rs.getInt(7);
                String regdate=rs.getString(8);
                
                stateDTO stateDto=new stateDTO(ordno, item, count, method, giveMoney, takeMoney, revenue,regdate);
                list.add(stateDto);
            }
                System.out.println("상품전체 조회 결과 list.size="+list.size()+", 매개변수="+orderNo);
                return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public List<stateDTO> SelectMethod(String method) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<stateDTO> list = new ArrayList<>();
        try{
            con=DBUtil.getConnection();
            String sql="select * from orderbox where method=? order by ordno desc";
            ps=con.prepareStatement(sql);
            ps.setString(1, method);
            rs=ps.executeQuery();
            
            while(rs.next()){
                int ordno=rs.getInt(1);
                String item=rs.getString(2);
                String count=rs.getString(3);
                String method2=rs.getString(4);
                int giveMoney=rs.getInt(5);
                int takeMoney=rs.getInt(6);
                int revenue=rs.getInt(7);
                String regdate=rs.getString(8);
                
                stateDTO stateDto=new stateDTO(ordno, item, count, method2, giveMoney, takeMoney, revenue,regdate);
                list.add(stateDto);
            }
                System.out.println("상품전체 조회 결과 list.size="+list.size()+", 매개변수="+method);
                return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
}
