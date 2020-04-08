<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>로그인</title>
    </head>
    <body>
        <h2>로그인</h2>
        <form action="/login" method="post">
	        <input type = "text" id = "user_id" name="user_id" placeholder="아이디"><br>
	        <input type = "password" id = "user_pw" name = "user_pw"placeholder="비밀번호"><br>
	        <button type="submit" class="login_process">로그인</button>
        </form>
        <p> <a href = "/join">회원가입</a></p>
        
        <!-- <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script> -->
        
        
        <script>
        $(document).ready(function(){
            //로그인 클릭시 실행
            $("#login_process").click(function(){
            	var obj = new Object();            	        

                obj.type = 'login';
                obj.id = $('#user_id').val();
                obj.password = $('#user_pw').val();
             
                if(obj.id == '' || obj.password == ''){
                        alert('아이디 혹은 비밀번호를 입력하세요');
                        return;
                }

            	
                var jsonData = JSON.stringify(obj);
                
                $.ajax({
                    type : "POST",
                    dataType : "json",
                    url : "/login",
                    data : {
                           json : jsonData
                    },
                    success : function(data) {
                           // data는 서버로부터 받은 결과JSON
                           if (data.answer == 'success') {
                                   alert(data.name + '님 환영합니다.');
                                   var map = new MapArray();
                                   postData('/board', map);
                           } else if (data.answer == 'fail') {
                                   alert('아이디와 비번이 일치하지 않습니다.');
                           } else if (data.answer == 'error') {
                                   alert('원활한 접속이 이루어 지지 못했습니다. 관리자에게 문의하십시오.');
                           }
                    },
                    error : function(e) {
                           alert("오류 발생 " + e);
                    }
            });

                

            	
            	
            	
                //json 객체를 생성
/*                 var json = {
                    //m_id의 이름을 가지고 m_id의 id를 가지는 태그의 벨류값을 가져옴 아래도 동일
                    user_id : $("#user_id").val(),
                    user_pw : $("#user_pw").val()
                };
                //json을 포이치문 돌림
                for(var str in json){
                    //길이가 0이면 아래 출력
                    if(json[str].length == 0){
                        //str은 json에 변수명을 가지고 #은 아이디 찾는것 attr은 에트류뷰트의 
                        //placeholder를 찾는것
                        alert($("#" + str).attr("placeholder") + "를 입력해주세요.");
                        //이벤트 발생한 id or pw 에 커서 올려줌(#은 id)
                        $("#" + str).focus();
                        return;
                    }
                } */
                /* $('input').val('helloworld); //input의 value 값에 helloworld라고 넣는다 
                $('input').val(); //input의 value값을 가져온다.
				 */
                //비동기 통신 선언 (아작스)
                /*  $.ajax({
                    type : "post", 
                    url : "/login", //login url로 요청
                    data : json, // json데이터를 전송, body에 데이터 실음
                    success : function(data) { //성공 하면 ==done
                        switch (Number(data)) { //위치문
                        case 0: // 0 일때
                            alert("아이디 또는 비밀번호가 일치하지 않습니다."); //경고 출력
                            break;
                        case 1: // 1 일떄
                            window.location.href = "/board/main"; //로그인 성공시 index페이지 이동
 
                        default:
                            break;
                        }
                    },
                    error : function(error) { //404 500등 오류 발생시 
                        alert("오류 발생"+ error);
                    }
                }); */
                
            });
        });
        </script>
    </body>
</html>
