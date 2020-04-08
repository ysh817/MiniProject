package com.enuri.myweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuri.myweb.util.UserInfoDao;
import com.enuri.myweb.vo.userinfo.UserInfo;




@Service
public class LoginService {
	//로그인 검사
	//중복 id, email 검사
	
	//setLogin
	@Autowired UserInfoDao userInfoDao;
	@Autowired SqlSession session;

	
	//로그인 검사는 jsp에서 
	//세션 저장 및 mapper
	/*public UserInfo setLogin(HttpServletRequest request, HttpServletResponse response) {
		//로그인 저장, 실패
		String id=request.getParameter("user_id");
		String pw=request.getParameter("user_pw");
		
		System.out.println("id="+ id +" pw= "+ pw);
		HttpSession session = request.getSession();
		//세션 저장
		
		//session.setAttribute("id", id);

		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", id);
		map.put("user_pw", pw);
		UserInfo userInfo = userInfoDao.getUser(map);
		//dao에서 인터페이스 구현
		return userInfo;
		// id, pw로 한 유저 선택 , 데이터 저장
	}
		*/
		

	
	public String loginCheck(UserInfo userInfo, HttpServletRequest request) {
		//1. loginid, loginpw -> where 절에 넣어서 조회가 되는지 안되는 확인
		//2. 조회가 된다 -> 그 사용자 정보를 session 사용
		//3. 조회가 안된다 -> loginfail 페이지
		//jQuery 
		
		UserInfo user = userInfoDao.getUserInfo(userInfo);
		HttpSession session = request.getSession();
		/*if(user.getUser_id()==null) {
			return "loginfail";
		}*/
		
		
		
		return "/board/main";
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
