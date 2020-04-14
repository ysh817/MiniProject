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
<<<<<<< HEAD
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


=======
        <h2>로그인</h2>
        <form action="/login" method="post">
	        <input type = "text" id = "user_id" name="user_id" placeholder="아이디"><br>
	        <input type = "password" id = "user_pw" name = "user_pw"placeholder="비밀번호"><br>
	        <button type="submit" class="login_process">로그인</button>
        </form>
        <p> <a href = "/join">회원가입</a></p>
        
        <!-- <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script> -->

>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
    </body>
</html>
