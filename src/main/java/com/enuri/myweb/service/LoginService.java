package com.enuri.myweb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuri.myweb.mapper.UserMapper;
import com.enuri.myweb.vo.UserInfoVo;



@Service
public class LoginService extends SqlSessionDaoSupport {
	//로그인 검사
	//중복 id, email 검사
	
	//setLogin
	
	@Autowired
	UserMapper mapper;
	
	
	public String setLogin(HttpServletRequest request) {
		//로그인 저장, 실패
		String id=request.getParameter("user_id");
		String pw=request.getParameter("user_pw");
		
		if(login_Check(id, pw)<0) {
			return "loginFail";
		}
		//세션 및 비밀번호 암호화 저장
		
		//UserInfoVo.setUser_pw(sha256Utils.encrypt(pw));
		
		
		
		return "board";
	}
		
		

	
	public static int login_Check(String loginId, String loginPw) {
	
		if(loginId == ""|| loginPw == ""){
			// id와 pw 둘 중에 하나라도 입력 null
			return -1;
		}
		
		if(UserInfoVo.getUser_id().equals(loginId)) {
			//입력한 id 가 유저정보에 없음
			return -1;
		}
		if(UserInfoVo.getUser_pw().equals(loginPw)) {
			//입력한 pw 가 유저정보에 없음
			return -1;
		}
		//중복로그인?
		
		
		return 0;
	}
	


	
}
	/* @Inject
	    private SqlSession session;
	    private static final String NameSpace = "memberMapper.";
	    
	    public int Id_Check(UserInfoVo userinfo) {
	        //예외처리
	        try {
	            //결과값을 반환
	            return session.selectOne(NameSpace + "Id_Check", userinfo);
	        }
	        catch (Exception e) {
	            //오류 발생시 오류 출력과 -1 반환
	            e.printStackTrace();
	            return -1;
	        }
	    }
	    
	    public int Register(UserInfoVo userinfo) {
	        //위에 선언된 Id_Check(m)의 결과값을 Id_Check_Result에 담는다.
	        int Id_Check_Result = Id_Check(userinfo);
	        //Id_Check_Result값이 0이 아니라면 Id_Check_Result값을 반환
	        //0은 아이디가 중복되지 않음 자세한거는 mapper를 열어보세요.
	        if(Id_Check_Result != 0) return Id_Check_Result;
	        
	        try {
	            //sqlsession에 insert를 할꺼고 내가 쓸 맵퍼는 위에 12번째줄에 선언된거고
	            //내가 사용 할 QUERY문은 Register를 사용하고 넘길 값은 m이다.
	            //이후 설명은 다 생략 똑같은 내용
	            session.insert(NameSpace + "Register", userinfo);
	            return 0;
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return -2;
	        }
	    }
	    
	    public int Login(UserInfoVo userinfo, HttpSession Hsession) {
	        int Id_Search_Result = -1;
	        try {
	           // Id_Search_Result = session.selectOne(NameSpace + "Login", userinfo);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return -1;
	        }
	        
	        if(Id_Search_Result != 1) return Id_Search_Result;
	        
	        try {
	        	UserInfoVo u_info = session.selectOne(NameSpace + "Login_Info", userinfo);
	            Hsession.setAttribute("userinfo", u_info);
	            return 1;
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return -2;
	        }
	    }
	    

}*/
