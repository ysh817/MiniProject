<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- 익플 지원 안함  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--   <form:form modelAttribute="joinformm">
		<form:label path="user_id">아이디 </form:label>
		<form:input path="user_id" readonly="true" />
		<form:errors path="user_id" style="color:red" />

		<hr>
		<form:label path="user_pw">비밀번호 </form:label>
		<form:password path="user_pw" />
		<form:errors path="user_pw" style="color:red" />

		<hr>

		<form:label path="user_pw2">비밀번호 확인 </form:label>
		<form:password path="user_pw2" />
		<form:errors path="user_pw2" style="color:red" />

		<hr>

		<form:label path="user_name">이름 </form:label>
		<form:input path="user_name" />
		<form:errors path="user_name" style="color:red" />

		<hr>

		<form:label path="user_email">이메일 </form:label>
		<form:input path="user_email" />
		<form:errors path="user_email" style="color:red" />

	
		<hr>
		<button type="submit">가입</button>
	</form:form>-->

	<form:form method='post'
		modelAttribute="joinformm">
		<div class="form-group">
			<form:label path="user_name">이름</form:label>
			<form:input path="user_name" class='form-control' />
			<form:errors path="user_name" style='color:red' />
		</div>
		<div class="form-group">
			<form:label path="user_id">아이디</form:label>
			<div class="input-group">
				<form:input path="user_id" class='form-control' />
				<div class="input-group-append">
					<button type="button" class="btn btn-primary">중복확인</button>
				</div>
			</div>
			<form:errors path="user_id" style='color:red' />
		</div>
		<div class="form-group">
			<form:label path="user_pw">비밀번호</form:label>
			<form:password path="user_pw" class='form-control' />
			<form:errors path='user_pw' style='color:red' />
		</div>
		<div class="form-group">
			<form:label path="user_pw2">비밀번호 확인</form:label>
			<form:password path="user_pw2" class='form-control' />
			<form:errors path='user_pw2' style='color:red' />
		</div>
		<div class="form-group">
			<div class="text-right">
				<form:button class='btn btn-primary'>회원가입</form:button>
			</div>
		</div>
	</form:form>

</body>
</html>