<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>예약 요청</title>
</head>
<body>
<input type="button" value="예약 신청 요청" onclick="location.href='sendJson.do?select=1' ">
<input type="button" value="예약 수정 요청" onclick="location.href='sendJson.do?select=2' ">
<input type="button" value="예약 취소 요청" onclick="location.href='sendJson.do?select=3' ">
<input type="button" value="예약 기간 조회 요청" onclick="location.href='sendJson.do?select=4' ">
</body>

</html>