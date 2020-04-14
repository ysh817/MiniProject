<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
<h3>여기는 네비게이션</h3>
<%-- <div class="collapse navbar-collapse" id="navMenu">		
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${loginUser.userlogin == true }">
					<li class="nav-item">
						<a href="/user/modify" class="nav-link">정보수정</a>
					</li>
					<li class="nav-item">
						<a href="/logout" class="nav-link">로그아웃</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a href="/login" class="nav-link">로그인</a>
					</li>
					<li class="nav-item">
						<a href="/join" class="nav-link">회원가입</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			
		</ul>
	</div>
 --%>




</nav>


<hr>
<h1> Test</h1>
<hr>
<a href = "/login">로그인</a> <br/>
<hr>
<a href = "/board">게시판</a>
<hr>
<a href = "/join">회원가입</a>
<hr>
<a href = "/user/user_list">회원관리</a>


</body>
</html>