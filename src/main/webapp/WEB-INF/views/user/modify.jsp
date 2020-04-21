<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원정보수정</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<script>
	
$(document).ready(function(){
    	
    	$("#submit").on("click", function(){
    		
    		var user_pw = $('#user_pw').val();
    		var user_pw2 = $('#user_pw2').val();
    		
    		if(user_pw!=user_pw2){
				alert("비밀번호가 일치하지 않습니다");
				$("#user_pw").focus();
				return false;
			}
    	});
})


</script>
<body>

<c:import url="../import/header.jsp"></c:import>

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form modelAttribute="modifyUser" method="post">
					
					<div class="form-group">
						<label for="user_name">이름</label>
						<input type="text" id="user_name" name="user_name" class="form-control" value="${modify.user_name}"/>
					</div>
					<div class="form-group">
						<label for="user_id">아이디</label>
						<input type="text" id="user_id" name="user_id" class="form-control" value="${modify.user_id}" readonly="readonly"/>
					</div>
					<div class="form-group">
						<label for="user_pw">비밀번호</label>
						<input type="password" id="user_pw" name="user_pw" class="form-control" value="${modify.user_pw}" />
					</div>
					<div class="form-group">
						<label for="user_pw2">비밀번호 확인</label>
						<input type="password" id="user_pw2" name="user_pw2" class="form-control"value="${modify.user_pw2}" />
					</div>
					<div class="form-group">
						<input type="hidden" name="user_gender" value="${modify.user_gender}">
						<input type="hidden" name="user_code" value="${modify.user_code}">
						<input type="hidden" name="user_email" value="${modify.user_email}">
						<input type="hidden" name="crt_dt" value="${modify.crt_dt}">
						<input type="hidden" name="idx" value="${modify.idx}">
						<div class="text-right">
							<button type="submit" id="submit"class="btn btn-primary">정보수정</button>
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