<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
 
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script src="http://code.jquery.com/jquery.js"></script>
        <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    </head>
    
    <script>
    
    $(document).ready(function(){
    	
    	$("#submit").on("click", function(){
    		
    		var user_pw = $('#user_pw').val();
    		var user_pw2 = $('#user_pw2').val();
    		var idCheck = $("#idCheck").val();
    		if(user_pw!=user_pw2){
				alert("비밀번호가 일치하지 않습니다");
				$("#user_pw").focus();
				return false;
			}
			if(idCheck == "n"){
				alert("중복확인 버튼을 눌러주세요.");
				return false;
			}
			 else if(idCheck == "y"){
				$("#regForm").submit();
			} 
			
	
    		
    	});
    })

     function checkIdExist(){
    	
		var user_id = $("#user_id").val();
		
		if(user_id.length == 0){
			alert('아이디를 입력해주세요')
			return
		}
		//if(user_pw)
		
		/* $.ajax({
			url : '${root}checkIdExist?user_id=' + user_id,
			type : 'get',
			success : function(data){
				console.log('아아아'+data);
				if(data == 0){
					alert('중복된 아이디입니다')
					//$("#userIdExist").val('true')
				} else {
					alert('사용할 수 없는 아이디 입니다')
					//$("#dulcheck").val('false')
				}
			}
		}) */
		$.ajax({
			url : '${root}checkIdExist?user_id=' + user_id,
			type : "get",
			//dataType : "Integer",
			//data : {"user_id" : $("#user_id").val()},
			success : function(data){
				console.log("안되네");
				if(data == 1){
					alert("중복된 아이디입니다.");
				}else if(data == 0){
					$("#idCheck").attr("value", "y");
					alert("사용가능한 아이디입니다.");
				}
			},
			error : function(request,status,error){
				//console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+erro+"데이터값:"+data);
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

			
			},
		})
		
	}
	
	/*  function resetUserIdExist(){
		$("#dulcheck").val('false')
	}  
     */
    
    
    
    
    
    
    
    
    
    
    </script>
    
    
    <body>
    <c:import url="import/header.jsp"></c:import>
  <div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="card shadow">
				<div class="card-body">
 <!-- action="javascript:alert( 'success!' ); -->
 
            <form:form modelAttribute="joinform" class="form-horizontal"  id="regForm" method="post" action="/join">
                <div class="form-group">
                  <!-- <input type="hidden" name="dulcheck"> -->
                    <label for="inputId"class="col-lg-4 control-label" >아이디</label>
                    <div class="input-group">	
                   		<!-- <input type="text" class="form-control onlyAlphabetAndNumber" id="user_id" name="user_id" data-rule-required="true" placeholder="" maxlength="30">  -->                   	       
                   		<form:input path="user_id" class='form-control'/>
                   		<div class="input-group-append">
									<button type="button" class="btn btn-primary" id="idCheck" onclick='checkIdExist();'value="n">중복확인</button>
							</div>
                   		</div>
                    <form:errors path="user_id" style="color:red"/>

                    	</div>
                    	<!--<spring:hasBindErrors name="userInfo">
							<c:if test="${errors.hasFieldErrors('user_id') }">
								${errors.getFieldError('user_id').defaultMessage }<br/>
							</c:if>
						</spring:hasBindErrors>-->

                <div class="form-group" id="divPassword">
                    <label for="inputPassword"class="col-lg-4 control-label" >패스워드</label>    
                    <!-- <input type="password" class="form-control" id="user_pw" name="user_pw" data-rule-required="true" placeholder="" maxlength="30"> -->
                   	<form:password path="user_pw" class='form-control'/>
                   	<form:errors path="user_pw" style="color:red"/>    
                </div>
                <div class="form-group" id="divPasswordCheck">
                    <label for="inputPasswordCheck" class="col-lg-4 control-label">패스워드 확인</label>
                    <!-- <input type="password" class="form-control" id="user_pw2" name="user_pw2" data-rule-required="true" placeholder="" maxlength="30"> -->
                   	<form:password path="user_pw2" class='form-control'/>
                   	<form:errors path="user_pw2" style="color:red"/>
                </div>
                <div class="form-group" id="divName">
                    <label for="inputName"class="col-lg-4 control-label" >이름</label>
                    <!-- <input type="text" class="form-control onlyHangul" id="user_name" name="user_name" data-rule-required="true" placeholder="" maxlength="15"> -->
                   	<form:input path="user_name" class='form-control'/>
                   	<form:errors path="user_name" style="color:red"/>     
                </div>

                
                <div class="form-group" id="divEmail">
                    <label for="inputEmail"class="col-lg-4 control-label">이메일</label>
                    <!-- <input type="email" class="form-control" id="user_email" name="user_email" data-rule-required="true" placeholder="" maxlength="40"> -->
                    <form:input path="user_email" class='form-control'/>
                    <form:errors path="user_email" style="color:red"/>
                </div>              
                <div class="form-group">
                    <label for="inputPhoneNumber" class="col-lg-2 control-label">성별</label>
					<select class="form-control" id="user_gender" name="user_gender">
                            <option value="M">남</option>
                            <option value="F">여</option>
                        </select>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <button type="submit" id="submit" class="btn btn-primary">회원가입</button> <!-- onclick="DosignUp(); -->
                    </div>
                </div>
            </form:form>
            
            <script>
            /*  $(document).ready(function(){
                
                $("#btn-primary").click(function(){
                	var obj = new Object();            	        

                    obj.type = 'join';
                    obj.id = $('#user_id').val();
                    obj.password = $('#user_pw').val();
                    obj.password2= $('#user_pw2').val();
                    obj.name= $('#user_name').val();
                    obj.email= $('#user_email').val();

                    )
                 
                    if(obj.id == '' || obj.password == '' ||obj.password2==''
                    		|| obj.name==''||obj.email==''){
                    	alert('아이디 혹은 비밀번호를 입력하세요');
                    	 //str은 json에 변수명을 가지고 #은 아이디 찾는것 attr은 에트류뷰트의 
                        //placeholder를 찾는것
                        alert($("#" + str).attr("placeholder") + "를 입력해주세요.");
                        //이벤트 발생한 id or pw 에 커서 올려줌(#은 id)
                        $("#" + str).focus();
                        return;
                            
                            
                    }
       
                });
            });
             
            
             */
            
            </script>
      				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
</div>      
            

  <!-- <hr/> -->

       
        <c:import url="import/footer.jsp"></c:import>
    </body>
</html>
 
        