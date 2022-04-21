/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lee.member.model;

import com.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author my
 */
public class MemberDAO {

    public int loginChecked(String userid, String pwd) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result=0;
        
        try{
            //1,2
            con=DBUtil.getConnection();

            String sql = "select pwd from account where userid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userid);

            //3
            rs=ps.executeQuery();

            if(rs.next()){
                String dbPwd=rs.getString(1);
                if(dbPwd.equals(pwd)){
                    result=MemberService.LOGIN_OK;
                }else{
                    result=MemberService.PWD_DISAGREE;
                }
            }else{
                result=MemberService.NONE_USERID;
            }
            System.out.println("로그인 처리결과:"+result+", 매개변수 userid="+userid+", pwd="+pwd);
            return result;
            }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public int duplicate(String userId) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try{
            con=DBUtil.getConnection();
            String sql="select count(*) from account where userid=?";
            ps=con.prepareCall(sql);
            
            ps.setString(1, userId);
            rs=ps.executeQuery();
            while(rs.next()){
                int dbCount=rs.getInt(1);
                if(dbCount>0){
                    result=MemberService.NON_USABLE_ID;
                }else{
                    result=MemberService.USABLE_ID;
                }
            }
            System.out.println("아이디 중복확인 결과="+result+", 매개변수="+userId);
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public int insertMember(MemberDTO dto) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            con=DBUtil.getConnection();
            String sql="insert into account values(?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, dto.getUserid());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getPhone());
            
            int result=ps.executeUpdate();
            System.out.println("멤버등록 결과="+result+", 매개변수="+dto);
            
            return result;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
}
