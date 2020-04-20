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
<title> 게시글 수정 </title>
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
		<div class="col-sm-2"></div>
		<div class="col-sm-10">
			<div class="card shadow">
				<div class="card-body">
					<form:form  method="post" modelAttribute="modifyContent">
						<div class="form-group">
							<input type="hidden" name="cnt" value="${modify.cnt}">
							<label for="board_writer_name">작성자</label>
							<input type="text" id="user_id" name="user_id" class="form-control" value="${modify.user_id}" readonly/>
						</div>
						<div class="form-group">
							<label for="board_date">작성날짜</label>
							<input type="text" id="regdate" name="regdate" class="form-control" value="${modify.regdate}" readonly/>
						</div>
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" id="title" name="title" class="form-control" value="${modify.title}"/>
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea id="content" name="content" class="form-control" rows="10" style="resize:none">${modify.content}</textarea>
						</div>
<!--						<div class="form-group">
 							<label for="board_file">첨부 이미지</label>
							<img src="${root }image/logo.png" width="100%"/>	
							<input type="file" name="board_file" id="board_file" class="form-control" accept="image/*"/>					
						</div> -->
						<div class="form-group">
							<div class="text-right">
								<input type="hidden" name="hit" value="${modify.hit}">
								<input type="hidden" name="recnt" value="${modify.recnt}">
								<button type="submit" class="btn btn-primary">수정완료</button>
								<a href="${root }board/read?content_cnt=${modify.cnt}" class="btn btn-info">취소</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
</div>

<c:import url="../import/footer.jsp"></c:import>
</body>
</html>
    