<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(()=>{
	$("#list").click(()=>{
		
		location.href="<c:url value='/list.do'/>";
	});
	$("#remove").click(()=>{
		
		location.href="<c:url value='/remove.do'/>?bno=${board.idx}";
	});
	
});

</script>

</head>
<body>
 
<div class="container">
<h2>Board Modify Page</h2>
  <div class="panel panel-default">

    <div class="panel-heading">Board Modify Page</div>
    <div class="panel-body">
  
   <form action="<c:url value='modify.do'/>" method="post">
  
  <div class="form-group">
    <label>Bno</label>
    <input type="text" class="form-control" id="idx" name="idx" value="${board.idx}" readonly="readonly">
  </div>
  
  
  <div class="form-group">
    <label>Title</label>
    <input type="text" class="form-control" id="title" name="title" value="${board.title}">
  </div>
  <div class="form-group">
    <label>Text area</label>
   <textarea class="form-control" rows=3 name="contents" >${board.contents}</textarea>
  </div>
  <div class="form-group">
    <label>Writer</label>
    <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" readonly="readonly">
  </div>
  <button type="submit" class="btn btn-default">Modify</button>
  <button id="remove" type="button" class="btn btn-default">Remove</button>
  <button id="list" type="button" class="btn btn-info">List</button>
</form>
    </div>
    <div class="panel-footer"></div>
  </div>
</div>

</body>
</html>