<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
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
<c:choose>
    <c:when test="${loginsession.isUserlogin()==true}">
        [ ${loginsession.user_name } ] 님 페이지 입니다. &emsp;<br>
        <a href = "${root }user/logoutSuccess">로그아웃</a>&emsp;|&emsp;
		<a href = "/board/main">게시판</a>&emsp;|&emsp;
		<a href = "${root}user/modify_enter">회원정보수정</a>
    </c:when>
    <c:otherwise>
    	<p>로그인 하세요</p>
   		<a href = "${root}login">로그인</a>&emsp;|&emsp;
   		<a href = "/join">회원가입</a>
    </c:otherwise>
</c:choose>
<hr>
<p>테스트중</p>
<a href = "/admin/user_list">회원관리</a>


</body>
</html>