<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script type="text/javascript">

	function ajaxs() {
		
		$.ajax({
			
			url:"/Ajax/winAndLose",
			type:"post",
		
			data:{
				"winner":"jang",
				"loser":"won"
			},
			success:function(data){
				
			}
			
		})
	}


</script>

</head>
<body>
<button onclick="ajaxs()">버튼</button>
</body>
</html>