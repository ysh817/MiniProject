<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!-- <c:import url="/WEB-INF/views/top_menu.jsp"/> 로 추가 -->

<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
	        data-target="#navMenu">
		<span class="navbar-toggler-icon"></span>        
	</button>
	<div class="collapse navbar-collapse" id="navMenu">
		<!-- <ul class="navbar-nav">
			<c:forEach var='obj' items='${topMenuList }'>
			<li class="nav-item">
				<a href="board/main?board_info_idx=${obj.board_info_idx}" class="nav-link">${obj.board_info_name }</a>
			</li>
			</c:forEach>
		</ul> -->
		
		<ul class="navbar-nav ml-auto">
<%-- 			<c:choose>
				<c:when test="${not empty sessionScope.userLoginInfo}"><!-- loginUser.userLogin == true --> --%>
					<!-- <li class="nav-item">
						<a href="/user/modify" class="nav-link">정보수정</a>
					</li> -->
					<li class="nav-item">
						<a href="#" class="nav-link">로그아웃</a>
					</li>
<%-- 				</c:when>
				<c:otherwise> --%>
					<li class="nav-item">
						<a href="#" class="nav-link">로그인</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link">회원가입</a>
					</li>
<%-- 				</c:otherwise>
			</c:choose> --%>
			
			
		</ul>
	</div>
</nav>