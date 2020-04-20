<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ABOUT</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>
<c:import url="import/header.jsp"></c:import>


<div class="container" style="margin-top:100px">
<h1> 미니 웹 프로젝트 설명</h1>
<h4>※ 요구사항</h4>
	1. 로그인<br>
	2. 회원가입<br>
		&emsp;a. 유효성 검사<br>
		&emsp;b. 중복아이디 검사<br>
	3. 회원정보 수정<br>
	4. 게시판<br>
		&emsp;a. 글목록<br>
		&emsp;b. 게시글 작성<br>
		&emsp;c. 권한- 게시글 수정/삭제<br>
		&emsp;d. 조회수<br>
		&emsp;e. 페이징<br>
		&emsp;f. 댓글(추가작업중)<br>
	5. 회원관리(관리자)<br>
		&emsp;a. 회원목록<br>
		&emsp;b. 회원정보 수정(비밀번호, 회원권한)<br>
		<br><br>
	6. 프로젝트 개발 기간 : 14일<br>
	7. 개발환경 : 이클립스(Spring  Framework),MySQL<br>
		
		<br>

</div>
<c:import url="import/footer.jsp"></c:import>
</body>
</html>