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
<script>
	function modifyReply(){
		
		var cnt = $("#cnt").val();
		var rno = $("#rno").val();
		
		$.ajax({
			url : '${root}reply/modify?content_cnt='+cnt'&reply_no='+rno,
			type : "get",
			success : function(data){
				if(data == 1){
					$("#modifyCheck").attr("value", "y");
					console.log('수정url 입구');
				}else if(data == 0){
					$("#modifyCheck").attr("value", "n");
					console.log('수정url X');
				}
			},
			error : function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

			
			},
		})
		
	}

</script>


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
      					  <form:form action="${root}reply/insert" method="post" modelAttribute="writeReply">
      					  	<textarea class="form-control" id="content" name="content" rows="3" cols="1"placeholder="댓글을 입력하세요"></textarea>
           					 <div class="form-group"></div>
           						<input type="hidden" name="cnt" value="${read.cnt}">
           						 <button type="submit" class="btn btn-primary" >등록</button>
       					 </form:form>
    					</div>
					</div>
					
					<div class="container" style="margin-topS:50px">
						<!--<div class="form-group">여기에 댓글</div>-->
						<b>&ensp;(${read.recnt})</b>
						<div class="card body">
							<!--  <h6 class="card-header">List:(없앨예정)</h6>-->
							<c:if test="${read.recnt==0 }">
							<div class="form-group text-right">등록된 댓글이 없습니다.</div>
							</c:if>
							<c:forEach var='obj' items="${replylist}">
								
								<div class="media text-muted pt-3" id="rid">
		                     	<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">		                
		                    	 <rect width="100%" height="100%" fill="#007bff"></rect>
		                    	 <text x="50%" fill="#007bff" dy=".3em">32x32</text> 
		                    	 </svg>
			                     <p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">
			                     <span class="d-block">
			                     <strong class="text-gray-dark"> &ensp;${obj.user_name}&ensp;</strong>
			                     <c:if test="${loginsession.user_id eq obj.user_id || loginsession.user_code eq 'admin' }">
				                     <span style="padding-left: 7px; font-size: 12pt">
				                     <!-- <a href="${root}reply/modify?content_cnt=${obj.cnt}&reply_no=${obj.rno}"  style="padding-right:5px">수정</a> -->
				                     
				                     <a href="javascript:void(0)" onclick="modifyReply();" id="modifyCheck">수정</a>
				                     
				                     <input type="hidden" name="cnt" value="${obj.cnt}">
			                    	 <input type="hidden" name="rno" value="${obj.rno}">
				                     <a href="${root}reply/delete?content_cnt=${obj.cnt}&reply_no=${obj.rno}"  >삭제</a>
				                     </span>
			                    </c:if>
			                     </span>
			                    	<c:choose>
			                    		<c:when test="${obj.up_no==1}">
			                    			<form:form modelAttribute="modifyReply" method="post" action="${root}reply/modify">
			                    				<textarea class="form-control" id="content" name="content" rows="3" cols="1">${modify.content}"</textarea>
			                    				<input type="hidden" name="cnt" value="${modify.cnt}">
			                    				<input type="hidden" name="rno" value="${modify.rno}">
			                    				<input type="hidden" name="user_id" value="${modify.user_id}">
			                    				<input type="hidden" name="user_name" value="${modify.user_name}">
			                    				<input type="hidden" name="regdate" value="${modify.regdate}">
			                    				<input type="hidden" name="up_regdate" value="${modify.up_regdate}">
			                    				<input type="hidden" name="up_no" value="${modify.up_no}">
			                    				
			                    				<button type="submit" id="submit" class="btn btn-primary">수정</button>
			                    				<a href="${root }reply/modifyCancel?content_cnt=${modify.cnt}&reply_no=${modify.rno}" class="btn btn-info">취소</a>
			                    			</form:form>			                    		
			                    		</c:when>
			                    		<c:otherwise>
			                    		&ensp;${obj.content}
			                    		</c:otherwise>
			                    	</c:choose>	
			                     </p>
			                    </div>
							
							
							</c:forEach>	
							
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
    