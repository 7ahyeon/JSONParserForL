<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>예약 요청</title>
</head>
<body>
<input type="button" value="예약 요청" onclick="sendData()">
<script>

	// 카테고리 ajax 처리
	function sendData() {
		$.ajax({
			  type:'POST',
			  url:'sendJson.do',
			  data:"",
			  dataType : "json",
			  success: function(args) {

			  },
			  error : function(jqXHR, textStatus, errorThrown) {
			  }
		});

	}
</script>
</body>

</html>