<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

function goRegister() {
	location.href="/make/register.do";
	
}
function login() {
	location.href="/make/login.do"
}
function logout() {
	location.href="<c:url value='/logout.do'/>";
}
function chatRoom() {
	location.href="<c:url value='/enterChatRoom.do'/>";
}
$(document).ready(function() {
   $("#makeRoom")
});
</script>

</head>
<body>
안녕하세요 홈입니다.
<input type="button" id="register" value="회원가입" onclick="goRegister()">
<c:if test="${sessionScope.userId==null || sessionScope.userId==''}">
<input type="button" id="login" value="로그인" onclick="login()">	
</c:if>
<c:if test="${sessionScope.userId !=null && sessionScope.userId !=''}">
  <div>${sessionScope.userName}님 반갑습니다.
 <button type="button" class="btn btn-default" onclick="logout()">로그아웃</button>
 <button type="button" id="makeRoom" onclick="chatRoom()">채팅방입장하기</button>
 

   
 </div>
</c:if>
</body>
</html>