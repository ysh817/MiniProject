<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg">
	<a class="navbar-brand" href="${root }">WEB PROJECT</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
	        data-target="#navMenu">
		<span class="navbar-toggler-icon"></span>        
	</button>
	<div class="collapse navbar-collapse" id="navMenu">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a href="${root }about" class="nav-link">ABOUT</a>
			</li>
			<c:if test="${loginsession.user_code eq 'admin' }">
			<li class="nav-item">
					<a href="${root }admin/user_list" class="nav-link">ADMIN</a>
			</li>
				</c:if>
			<c:if test="${loginsession.userlogin == true }">
			<li class="nav-item">
				<a href="${root }board/main" class="nav-link">게시판</a>
			</li>
			
			
			</c:if>
		</ul>
		
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${loginsession.userlogin == false}">
					<li class="nav-item">
						<a href="${root }login" class="nav-link">로그인</a>
					</li>
					<li class="nav-item">
						<a href="${root }join" class="nav-link">회원가입</a>
					</li>
				</c:when>
				<c:otherwise>
					<c:if test="${loginsession.userlogin == true }">
						<li class="nav-item">
							<a href="${root }user/modify" class="nav-link">정보수정</a>
						</li>
						<li class="nav-item">
							<a href="${root }user/logoutSuccess" class="nav-link">로그아웃</a>
						</li>
					</c:if>
				</c:otherwise>
			</c:choose>
			
			
		</ul>
	</div>
</nav>