package com.enuri.myweb;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.enuri.myweb.vo.board.BoardContent;
import com.enuri.myweb.vo.board.BoardContentDao;
import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserInfoDao;


public class test extends AbstractApplicationContextTest{
	@Autowired SqlSession session;
	@Autowired BoardContentDao dao;
	/*@Test
	public void tes() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_id("test");
		userInfo.setUser_pw("test");
		
		UserInfo user = dao.getUser(userInfo);
		
		System.out.println(user.getUser_id());
		System.out.println(user.getUser_pw());
	}*/
	
	@Override
	protected void test() {

		/*UserInfo userInfo = new UserInfo();
		userInfo.setUser_id("test2");
		userInfo.setUser_pw("test2");
		System.out.println(userInfo.getUser_id());
		try {
		UserInfo user = dao.getUser(userInfo);
		//UserInfo user = session.selectOne("UserInfo.getUser", userInfo);
		System.out.println(user.getUser_id());
		System.out.println(user.getUser_pw());
		}catch(Exception e){
			System.out.println("Dd");
		}*/
	

		/*BoardContent board = new BoardContent();
=======
		BoardContent board = new BoardContent();
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
		board.setTitle("abbbs");
		board.setWriter("abc");
		board.setContent("abc");
		board.setRegdate(YmdFull());
		board.setCnt(cntMethod(board));
		//board.setCnt(0);
		System.out.println(board.getTitle());
	
		//UserInfoDao dao = new UserInfoDao();
		System.out.println("ddd");
		System.out.println(board.getTitle());
		try {
			System.out.println("This is"+board.getRegdate());
			dao.insertBoard(board);
			System.out.println("ddda");
			}catch(Exception e){
				System.out.println("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\n\n"+ e );
			}
<<<<<<< HEAD
		*/
		
		//getuserInfo 테스트
		
		String id="dddd";
		String pw="1234";
		//UserInfo ch = userInfoDao.login(userInfo);
		UserInfo userInfo = new UserInfo();
		
		//userInfo = getUserInfo
	

		
	}
	
	
	public String YmdFull(){
		//Date now= new Date(System.currentTimeMillis());
        //return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
		
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
