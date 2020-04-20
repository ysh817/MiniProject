<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


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
<c:import url="../import/header.jsp"></c:import>


<div class="container" style="margin-top:100px">
	<div class="card shadow">
		<div class="card-body">
			<h4 class="card-title">회원관리</h4>
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
				<c:choose>
					<c:when test="${paging.prevPage <= 0 }">
						<li class="page-item disabled">
							<a href="#" class="page-link">이전</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a href="${root }admin/user_list?page=${paging.prevPage}" class="page-link">이전</a>
						</li>
					</c:otherwise>
				</c:choose>
					
					
					<c:forEach var='idx' begin="${paging.min }" end='${paging.max }'>
						<c:choose>
							<c:when test="${idx == paging.currentPage }">
								<li class="page-item active">
									<a href="${root }admin/user_list?page=${idx}" class="page-link">${idx }</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a href="${root }admin/user_list?page=${idx}" class="page-link">${idx }</a>
								</li>
							</c:otherwise>
						</c:choose>
					
					</c:forEach>
					
					<c:choose>
						<c:when test="${paging.max >= paging.pageCnt }">
							<li class="page-item disabled">
								<a href="#" class="page-link">다음</a>
							</li>
						</c:when>
						
						<c:otherwise>
							<li class="page-item">
								<a href="${root }admin/user_list?page=${paging.nextPage}" class="page-link">다음</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			
			<div class="text-right">
				
			</div>
			
		</div>
	</div>
</div>
<hr />

<c:import url="../import/footer.jsp"></c:import>

</body>
</html>