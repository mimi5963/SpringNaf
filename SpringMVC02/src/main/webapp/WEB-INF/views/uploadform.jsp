<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<script type="text/javascript">

var cnt=1;

function delUploadDiv(data){
	
	$("#f"+data+"").remove();
	$("#c"+data+"").remove();
	
	cnt--;
	
}
function file_add(){
	
	//파일 추가 버튼 누를때 마다 file 넣을 수 있는 칸 생김
	$("#d_file").append("<input type='file' id='f"+cnt+"' name='file"+cnt+"'/>"+"<input type='button' id='c"+cnt+"' value='삭제' onclick = 'delUploadDiv("+cnt+")'>"+"<br>");
	//파라미터에 데이터 넣어두면, 당시 데이터가 들어가는게 아니라, 이거 만들어졌을때 cnt기억하고 있음
	cnt++;
	
	
}




</script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
  <h2>다중파일업로드</h2>
  <div class="panel panel-default">
    <div class="panel-heading">스프링 이용한 다중 파일 업로드 구현 </div>
    <div class="panel-body">Panel Content
    <!-- 파일업로드를 위한 설정 인코딩타입 -->
    <form class="form-horizontal" action="<c:url value='/upload.do'/>" enctype="multipart/form-data" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="id">아이디:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="id" name="id" placeholder="Enter id" style="width: 30%">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">이름:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
    </div>
  </div>
 <div class="form-group">
    <label class="control-label col-sm-2" for="">파일추가:</label>
    <div class="col-sm-10">
      <input type="button" value="파일 추가" onclick="file_add()"><br>
      <div id="d_file"></div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">업로드</button>
    </div>
  </div>
</form>
    
    </div>
    <div class="panel-footer">나프2탄고</div>
  </div>
</div>


</body>
</html>