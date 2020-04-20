<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value='${pageContext.request.contextPath}/'/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판 글</title>
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
					<div class="form-group">
						<label for="board_writer_name">작성자</label>
						<input type="text" id="writer" name="writer" class="form-control" value="${read.user_id}" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_date">작성날짜</label>
						<input type="text" id="regdate" name="regdate" class="form-control" value="${read.regdate}" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_subject">제목</label>
						<input type="text" id="title" name="title" class="form-control" value="${read.title}" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_content">내용</label>
						<textarea id="content" name="content" class="form-control" rows="10" style="resize:none" disabled="disabled"><c:out value="${read.content}" /></textarea>
					</div>
					<!-- <div class="form-group">
						<label for="board_file">첨부 이미지</label>
						이미지경로 수정해야하
						<img src="/image/*.img" width="100%"/>						
					</div> -->
					<div class="form-group">
						<div class="text-right">
							<c:choose>
								<c:when test="${loginsession.user_code eq 'admin' }">
									<p>admin</p>
									<a href="/board/main" class="btn btn-primary">목록보기</a>
									<a href="/board/modify?content_cnt=${read.cnt}" class="btn btn-info">수정하기</a>
									<a href="/board/delete?content_cnt=${read.cnt}" class="btn btn-danger">삭제하기</a>
								</c:when>
								<c:when test="${loginsession.user_id eq read.user_id }">
									<p>작성자</p>
									<a href="/board/main" class="btn btn-primary">목록보기</a>
									<a href="/board/modify?content_cnt=${read.cnt}" class="btn btn-info">수정하기</a>
									<a href="/board/delete?content_cnt=${read.cnt}" class="btn btn-danger">삭제하기</a>
								</c:when>
								<c:otherwise>
									<a href="/board/main" class="btn btn-primary">목록보기</a>
								</c:otherwise>
							</c:choose>
						
						
						</div>
					</div>
					<div class="card body">
					<h5 class="card-header">Leave a Comment:</h5>
    					<div class="card-body">
      					  <form:form method="post" modelAttribute="writeReply">
      					  	<textarea class="form-control" id="cotent" name="content" rows="3" cols="1"placeholder="댓글을 입력하세요"></textarea>
           					 <div class="form-group">{{ 여기에댓글? }}</div>
           						 <button type="submit" class="btn btn-primary">Submit</button>
       					 </form:form>
    					</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
</div>
<c:import url="../import/footer.jsp"></c:import>
</body>
</html>
    