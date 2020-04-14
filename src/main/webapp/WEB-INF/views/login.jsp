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
        <h2>로그인</h2>
        <form action="/login" method="post">
	        <input type = "text" id = "user_id" name="user_id" placeholder="아이디"><br>
	        <input type = "password" id = "user_pw" name = "user_pw"placeholder="비밀번호"><br>
	        <button type="submit" class="login_process">로그인</button>
        </form>
        <p> <a href = "/join">회원가입</a></p>
        
        <!-- <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script> -->

    </body>
</html>
