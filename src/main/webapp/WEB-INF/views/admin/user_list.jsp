<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
 <title>admin 사용자 관리 페이지</title>
</head>
<body>

<div id="root">
 <header>
  <h1>admin 사용자 관리 페이지</h1>
 </header>
<hr /> 
 <nav>처음화면 - 글쓰기 - 로그인</nav>
<hr />

 <section id="container">
  <h2>글 목록</h2><br>
  <h1>${ user_list.user_id}님 안녕하세요</h1>
  <table>
   <tr><th>글 번호</th><th>글 제목</th><th>작성자</th><th>작성일자</th></tr>
   
   <!-- 목록 시작 -->
   <c:forEach items="${userList}" var="list">
   <tr>
    <td>${userList.bno}</td><td>${userList.title}</td><td>${userList.writer}</td>
    <td>${userList.regDate}"</td>
   </tr>
   <hr>
   </c:forEach>
   <!-- 목록 끝 -->
   
  </table>

 </section>

<hr />

 <footer>
  <p>dddd</p>  
 </footer>

</div>

</body>
</html>