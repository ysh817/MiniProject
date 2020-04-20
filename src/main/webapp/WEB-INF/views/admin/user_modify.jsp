<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> 회원정보 수정 </title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../import/header.jsp"></c:import>

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form  method="post" modelAttribute="adminModifyUser">
						<div class="form-group">
							<label for="user_id">ID</label>
							<input type="text" id="user_id" name="user_id" class="form-control" value="${usermodify.user_id}" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label for="user_name">이름</label>
							<input type="text" id="user_name" name="user_name" class="form-control" value="${usermodify.user_name}"/>
						</div>
						<div class="form-group">
							<label for="user_pw">비밀번호</label>
							<input type="text" id="user_pw" name="user_pw" class="form-control" value="${usermodify.user_pw}"/>
						</div>
						<div class="form-group">
							<label for="user_code">계정</label>
							<input type="text" id="user_code" name="user_code" class="form-control" value="${usermodify.user_code}"/>
						</div>

						<div class="form-group">
						<input type="hidden" name="user_gender" value="${usermodify.user_gender}">
						<input type="hidden" name="user_email" value="${usermodify.user_email}">
						<input type="hidden" name="crt_dt" value="${usermodify.crt_dt}">
						<input type="hidden" name="user_pw2" value="${usermodify.user_pw2}">
						<input type="hidden" name="idx" value="${usermodify.idx}">
						
							<div class="text-right">
								<button type="submit" class="btn btn-primary">수정완료</button>
								<a href="${root }admin/user_list" class="btn btn-info">취소</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
<c:import url="../import/footer.jsp"></c:import>

</body>
</html>
    