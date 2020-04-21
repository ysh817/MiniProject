<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/"/> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>로그인</title>
        <!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        
    </head>
    
    
    
    <body>
    <c:import url="import/header.jsp"></c:import>

<div class="container" style="margin-top:100px">
	<div class="row">
	<hr/>
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
		
			<div class="card shadow">		
				<div class="card-body">
					<div class="form-group text-center">
						<br>
					</div>
					<form:form action="/login" method='post' modelAttribute="LoginUserInfo">
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<form:input path="user_id" class='form-control'/>
							<form:errors path='user_id' style='color:red'/>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class='form-control'/>
							<form:errors path='user_pw' style='color:red'/>
						</div>
						<div class="form-group text-right">
							<form:button class='btn btn-primary'>로그인</form:button>
							
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
</div>
<c:import url="import/footer.jsp"></c:import>


    </body>
</html>
