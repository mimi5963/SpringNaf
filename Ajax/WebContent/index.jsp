<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Insert title here</title>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript">
	function ajaxList(name) {
		$.ajax({
			type : 'post',
			url : "<c:url value='/getMemberList.do'/>",
			dataType:'JSON',
			data : {'name': name},
			success : function(result){
				$("#members").html("");
				var member = result;
				var html ="";
				member.forEach(function(index){
					console.log(index);
					
					html += "<tr><td>"+index["userName"]+"</td>"
					html += "<td>"+index.win+"</td>"
					html += "<td>"+index.lose+"</td>"
					html += "<td>"+index.rank+"</td></tr>"
					
				})
				$("#members").html(html);
				console.log(html);
			}
			
		});
	}
		
	window.onload = function(){
			ajaxList("");
		$(".form-control").keyup(function () {
			const name = $(".form-control").val();
			ajaxList(name);
		
		});
	};

</script>
</head>
<body>
	<br>
	<div class="container">
		<div class="form-group row pull-right">
		  <div class=col-xs-8>
		  	<input class="form-control" type="text" size="20" value=""/>
		  </div>
		  <div class=col-sx-2>
		  	<button class="btn btn-primary" type="button">검색</button>
		  </div>
		</div>
		<table class="table" style="text-align:center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #fafafa; text-align: center;">
						이름
					</th>
					<th style="background-color: #fafafa; text-align: center;">
						승리
					</th>
					<th style="background-color: #fafafa; text-align: center;">
						패배
					</th>
					<th style="background-color: #fafafa; text-align: center;">
						랭킹
					</th>
				</tr>
			</thead>
			<tbody id="members">
				<tr>
					
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>