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
<nav>
<c:choose>
    <c:when test="${not empty sessionScope.loginsession}">
        [ ${user_name } ] 님 환영합니다 &emsp;<br>
        <b><a href = "${root }">홈으로</a></b>&emsp;|&emsp;
        <b><a href = "${root }user/modify_enter">회원정보수정</a></b>&emsp;|&emsp;
        <b><a href = "${root }user/logoutSuccess">로그아웃</a></b>
    </c:when>
    <c:otherwise>
    	로그인 하세요&emsp;<br>
    	<b><a href = "${root}login">로그인</a></b>&nbsp;|&nbsp;<b><a href = "${root }">홈으로</a></b>      
    </c:otherwise>
</c:choose>
 
<!-- body와  foot에  import예정 -->
</nav>
<hr>
<h3> 게시판  /board/main</h3>

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
						<th class="text-center d-none d-md-table-cell">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='obj' items="${contentlist}">
					<tr>
						<td class="text-center d-none d-md-table-cell">${obj.cnt}</td>
						<td><a href='/board/read?content_cnt=${obj.cnt}'>${obj.title}</a></td>
						<td class="text-center d-none d-md-table-cell">${obj.user_id}</td>
						<td class="text-center d-none d-md-table-cell">${obj.regdate}</td>
						<td class="text-center d-none d-md-table-cell">${obj.hit}</td>
			
						
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






    