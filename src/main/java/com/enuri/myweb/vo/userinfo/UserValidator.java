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
		
		String id = userinfo.getUser_id();
		if(id==null||id.trim().isEmpty()) {
			//id가 공백이거나 사이에 공백이 있을때
			errors.rejectValue("user_id","er1");
		}
		String name = userinfo.getUser_name();
		if(name==null||name.trim().isEmpty()) {
			//name가 공백이거나 사이에 공백이 있을때
			errors.rejectValue("user_name","er2");
		}
		
		String email = userinfo.getUser_email();
		if(email==null||email.trim().isEmpty()) {
			//email가 공백이거나 사이에 공백이 있을때
			errors.rejectValue("user_email","er3");
		}		
		String pw=userinfo.getUser_pw();
		String pw2=userinfo.getUser_pw2();
		if(!pw.equals(pw2)){
			//비밀번호, 비밀번호 확인
			errors.rejectValue("user_pw", "er4");
			//errors.rejectValue("user_pw2", "er5");
		}
		if(pw==null||pw.trim().isEmpty()) {
			errors.rejectValue("user_pw", "er5");
		}
		if(pw2==null||pw2.trim().isEmpty()) {
			errors.rejectValue("user_pw2", "er6");//프로퍼티에 집어넣음
		}
		
	}
	

}
