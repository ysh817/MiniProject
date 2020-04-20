package com.enuri.myweb.vo.userinfo;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		UserInfo userinfo = (UserInfo)target;
			
		/*String pw=userinfo.getUser_pw();
		String pw2=userinfo.getUser_pw2();
		
		if(!pw.equals(pw2)){
			//비밀번호, 비밀번호 확인
			errors.rejectValue("user_pw", "er1");
			//errors.rejectValue("user_pw2", "er5");
		}
		if(userinfo.isDulcheck()==false){
			errors.rejectValue("user_id", "er2");
		}
*/
		
	}
	

}
