package com.enuri.myweb.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserInfoDao;

@Service
public class LoginService {
	// 로그인 검사
	// 중복 id, email 검사

	// setLogin
	
	@Resource(name = "loginsession")
	@Lazy
	private UserInfo loginsession;
	
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	SqlSession session;

	// 로그인 검사는 jsp에서
	// 세션 저장 및 mapper
	
	public boolean loginCheck(UserInfo userInfo, HttpServletRequest request) {
		// 1. loginid, loginpw -> where 절에 넣어서 조회가 되는지 안되는 확인 //setLogin
		// 2. 조회가 된다 -> 그 사용자 정보를 session 사용
		// 3. 조회가 안된다 -> loginfail 페이지
		// jQuery
		
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println("id=" + id + " pw=" + pw + "로 로그인을 시도하였습니다.");

		/*UserInfo login=userInfoDao.getUserInfo(userInfo);
		System.out.println("유저이름:"+login.getUser_name());
		//로긴 메소드만들어서 거기에 로그인 회원정보 담아야함 (0)
*/		
		// 로그인 성공여부를 위해 유저 조회
		UserInfo ch = userInfoDao.login(userInfo); //ch가 null이면 아이디 없음
		
		if (ch==null) {	
			
			//session.setAttribute("LoginUser", null); 
			System.out.println("로그인 실패");
			//System.out.println("세션정보:"+session); //세션정보 없음
			/*mv.setViewName("/loginFail");*/
			return false;
		}
		//HttpSession session = request.getSession();
		System.out.println("유저아이디 존재");
		//userInfo=setloginUser(userInfo,request);
		//session.setAttribute("LoginUser", userInfo); //추후 수정
		//System.out.println("세션정보:"+session);
		
		return true;
		//mv.setViewName("redirect:/board/main");
		
		//return mv;
	}
	
	public UserInfo setloginUser(UserInfo userInfo, HttpServletRequest request)
	{
		//유저정보 서버에서 사용할 수 있도록 DB->object로 
		//세션 등록

		UserInfo loginuser=userInfoDao.getUserInfo(userInfo);
		
		HttpSession session = request.getSession(); 
		session.setAttribute("LoginUser", loginuser);
		
		loginuser.setUserlogin(true);//로그인 여부 0
		
		System.out.println("set에서의 유저??: "+loginuser.getUser_name());
		
		return loginuser;
	
	}
	
	public void setloginUsersession(UserInfo userInfo, HttpServletRequest request) {
		//세션영역에 로그인 유저정보 저장
		UserInfo loginuser=userInfoDao.getUserInfo(userInfo);
		if(loginuser!=null) {
			loginsession.setUser_id(loginuser.getUser_id());
			loginsession.setUser_name(loginuser.getUser_name());
			loginsession.setUserlogin(true);
			
			HttpSession session = request.getSession(); 
			session.setAttribute("LoginUser", loginsession);
			//or
			//session.setAttribute("LoginUser", loginuser);
		}
			
	}
	
	/*public void ModifyUserIfo(UserInfo userInfo) {
		//유저정보 수정하기 위해 해당 유저조히
		userInfo.setUser_id(loginsession.getUser_id());
		
		//dao
	}*/
	
	
	
/*	public String getuserList(UserInfo userInfo) {
		//회원정보창
		List<UserInfo> userlist = UserInfoDao.getAllUserInfo();
		
		return "";
	}
*/

	
	public void logout(HttpSession session) {
		System.out.println("세션정보:"+session);
		session.invalidate();
		
		//session.setAttribute("LoginUser", null);
	}

}
/*
 * @Inject private SqlSession session; private static final String NameSpace =
 * "memberMapper.";
 * 
 * public int Id_Check(UserInfoVo userinfo) { //예외처리 try { //결과값을 반환 return
 * session.selectOne(NameSpace + "Id_Check", userinfo); } catch (Exception e) {
 * //오류 발생시 오류 출력과 -1 반환 e.printStackTrace(); return -1; } }
 * 
 * public int Register(UserInfoVo userinfo) { //위에 선언된 Id_Check(m)의 결과값을
 * Id_Check_Result에 담는다. int Id_Check_Result = Id_Check(userinfo);
 * //Id_Check_Result값이 0이 아니라면 Id_Check_Result값을 반환 //0은 아이디가 중복되지 않음 자세한거는
 * mapper를 열어보세요. if(Id_Check_Result != 0) return Id_Check_Result;
 * 
 * try { //sqlsession에 insert를 할꺼고 내가 쓸 맵퍼는 위에 12번째줄에 선언된거고 //내가 사용 할 QUERY문은
 * Register를 사용하고 넘길 값은 m이다. //이후 설명은 다 생략 똑같은 내용 session.insert(NameSpace +
 * "Register", userinfo); return 0; } catch (Exception e) { e.printStackTrace();
 * return -2; } }
 * 
 * public int Login(UserInfoVo userinfo, HttpSession Hsession) { int
 * Id_Search_Result = -1; try { // Id_Search_Result =
 * session.selectOne(NameSpace + "Login", userinfo); } catch (Exception e) {
 * e.printStackTrace(); return -1; }
 * 
 * if(Id_Search_Result != 1) return Id_Search_Result;
 * 
 * try { UserInfoVo u_info = session.selectOne(NameSpace + "Login_Info",
 * userinfo); Hsession.setAttribute("userinfo", u_info); return 1; } catch
 * (Exception e) { e.printStackTrace(); return -2; } }
 * 
 * 
 * }
 */
