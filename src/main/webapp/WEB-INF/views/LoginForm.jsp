<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
    integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
    crossorigin="anonymous">
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
    integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
    crossorigin="anonymous"></script>
    
<title>Home</title>
 
<meta charset="UTF-8">
<style type="text/css">
    .login-box{
        background-color: lime;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="login-box">
                    <form role="form">
                        <legend>Login</legend>
                        <div class="form-group">
                            <label>아이디</label> <input type="text" class="form-control"
                                placeholder="아이디를 입력하세요">
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label> <input type="password" class="form-control"
                                placeholder="비밀번호를 입력하세요">
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-default btn-login-submit"
                                value="login"> <a href="#" class="btn btn-primary">회원가입</a>
                        </div>
 
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
 
