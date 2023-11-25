<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: red;
	}
	.
</style>
</head>
<body>

	
	<c:if test="${error != null && error.hasGlobalErrors()}">
			<c:forEach var="error" items="${error.getGlobalErrors()}">
				${error.getDefaultMessage()}
			</c:forEach>
	</c:if>
	
	
	<form:form modelAttribute="itemVO" method="POST">
		
		이름 :<form:input path="name"/><br>
			<form:errors path="name" cssClass="error" /> <br>
		가격:<form:input path="price"/><br>
			<form:errors path="price" cssClass="error"/><br>
		수량:<form:input path="quen"/><br>
			<form:errors path="quen" cssClass="error"/><br>
		<form:button value="제출">제출</form:button>
	</form:form>




	
	
	
</body>
</html>