<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>로그인</title>
    </head>
    
    
    
    <body>

<h2>로그인</h2><br>

					<form:form action="/login" method='post' modelAttribute="LoginUserInfo">
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<form:input path="user_id" class='form-control'/>
							<form:errors path='user_id' style='color:red'/>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class='form-control'/>
							<form:errors path='user_pw' style='color:red'/>
						</div>
						<div class="form-group text-right">
							<form:button class='btn btn-primary'>로그인</form:button>
							<a href="/join" class="login_process">회원가입</a>
						</div>
					</form:form>



    </body>
</html>
