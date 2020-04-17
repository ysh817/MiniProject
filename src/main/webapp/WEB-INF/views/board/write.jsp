<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- 수정예정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판 글쓰기</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action='/board/write' method='post' modelAttribute="writeContent">
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" class='form-control' id="title" name="title" placeholder="제목을 입력하세요" />
							<form:errors path='title' style='color:red' />
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea id="content" name="content" class="form-control" rows="10" placeholder="내용을 입력하세요"></textarea>
							<form:errors path='content' style='color:red'/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<button type="submit" class='btn btn-primary'>작성하기</button>
							</div>
						</div>
					
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
<!-- body와  foot에  import예정 -->


</body>
</html>
    