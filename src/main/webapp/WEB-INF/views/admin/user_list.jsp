<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
 <title>admin 사용자 관리 페이지</title>
 <!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
 
</head>
<body>

<div id="root">
 <header>
  <h1>admin 사용자 관리 페이지</h1>
 </header>

<div class="container" style="margin-top:100px">
	<div class="card shadow">
		<div class="card-body">
			<h4 class="card-title">.</h4>
			<table class="table table-hover" id='user_list'>
				<thead>
					<tr>
						<th class="text-center d-none d-md-table-cell">ID</th>
						<th class="text-center d-none d-md-table-cell">이름</th>
						<th class="text-center d-none d-md-table-cell">계정</th>
						<th class="text-center d-none d-md-table-cell">이메일</th>
						<th class="text-center d-none d-md-table-cell">성별</th>
						<th class="text-center d-none d-md-table-cell">생성날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='obj' items="${userlist}">
					<tr>
						<td class="text-center d-none d-md-table-cell">${obj.user_id}</td>
						<td><a href='/admin/user_modify?user_id=${obj.user_id}'>${obj.user_name}</a></td>
						<td class="text-center d-none d-md-table-cell">${obj.user_code}</td>
						<td class="text-center d-none d-md-table-cell">${obj.user_email}</td>
						<td class="text-center d-none d-md-table-cell">${obj.user_gender}</td>
						<td class="text-center d-none d-md-table-cell">${obj.crt_dt}</td>	
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
				
			</div>
			
		</div>
	</div>
</div>
<hr />

</div>

</body>
</html>