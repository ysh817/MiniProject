<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<b><a href = "${root }user/logoutSuccess">로그아웃</a></b><b><a href = "${root }">   홈으로</a></b><hr> 
<!-- body와  foot에  import예정 -->

<h2> 게시판  /board/main</h2>
<p>세션정보:[ <%=session.getAttribute("LoginUser")%> ]</p>
<p>[ ${sessionScope.loginUser.user_name } ] 님 안녕하세요</p>
<p>[ ${sessionScope.loginsession.user_name } ] 님 안녕하세요</p>

<p>[ ${user_name } ] 님 안녕하세요</p>

<c:choose>
    <c:when test="${not empty sessionScope.loginUser}">
        <h2>로그인 성공 </h2>
        이름 : ${sessionScope.loginUser.user_name} 
        <a href="logout">로그아웃</a>
    </c:when>
    <c:otherwise>
        <p>Test: 세션이 비었음</p>        
    </c:otherwise>
</c:choose>


<!-- 게시글 리스트 -->
<div class="container" style="margin-top:100px">
	<div class="card shadow">
		<div class="card-body">
			<h4 class="card-title">.</h4>
			<table class="table table-hover" id='board_list'>
				<thead>
					<tr>
						<th class="text-center d-none d-md-table-cell">글번호</th>
						<th class="w-50">제목</th>
						<th class="text-center d-none d-md-table-cell">작성자</th>
						<th class="text-center d-none d-md-table-cell">작성날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='obj' items="${contentlist}">
					<tr>
						<td class="text-center d-none d-md-table-cell">${obj.cnt}</td>
						<td><a href='/board/read'>${obj.title}</a></td>
						<td class="text-center d-none d-md-table-cell">${obj.writer}</td>
						<td class="text-center d-none d-md-table-cell">${obj.regdate}</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="d-none d-md-block">
				<ul class="pagination justify-content-center">
				<!-- 이것도 c:로 할 예정 -->
					<li class="page-item">
						<a href="#" class="page-link">이전</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link">1</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link">2</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link">3</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link">4</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link">5</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link">다음</a>
					</li>
				</ul>
			</div>
			
			<div class="d-block d-md-none">
				<ul class="pagination justify-content-center">
					<li class="page-item">
						<a href="#" class="page-link">이전</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link">다음</a>
					</li>
				</ul>
			</div>
			
			<div class="text-right">
				<a href="/board/write" class="btn btn-primary">글쓰기</a>
			</div>
			
		</div>
	</div>
</div>

</body>
</html>






    