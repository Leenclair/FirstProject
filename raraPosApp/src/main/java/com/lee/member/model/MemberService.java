package com.lee.member.model;

/**
 *
 * @author my
 */
public class MemberService {
    //로그인 처리시 필요한 상수
    public static final int LOGIN_OK=1; //로그인 성공
    public static final int PWD_DISAGREE=2; //비밀번호 불일치
    public static final int NONE_USERID=3; //아이디 존재하지 않음
    
    //아이디 중복확인시 필요한 상수
    public static final int USABLE_ID=1; //아이디 사용가능
    public static final int NON_USABLE_ID=2; //아이디 사용불가
    
    private static String userid;

    public static String getUserid() {
        return userid;
    }

    public static void setUserid(String userid) {
        MemberService.userid = userid;
    }
    
    
}
