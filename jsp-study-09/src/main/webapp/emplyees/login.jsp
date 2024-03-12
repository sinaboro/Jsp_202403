<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 td{
 	border: 1px solid;black;
 	width: 200px;
 /* 	text-align: center; */
 }
</style>

</head>
<body>
	<form action="login.do" method="post" name="frm">
		<table align="center">
			<tr>
				<td colspan="2" > 로그인</td>
			</tr>
			<tr>
				<td >아이디</td>
				<td><input type="text" name="id" value="test"></td>
			</tr>
			<tr>
				<td >비밀번호</td>
				<td><input type="password" name="pwd" value="1234"></td>
			</tr>
			<tr>
				<td >레벨</td>
				<td><select name="admin">
					<option value = "A">운영자</option>
					<option value = "B">일반회원</option>
				</select></td>
			</tr>
			<tr >
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
				</td>
			</tr>			
		</table>
		<div  align="center"> ${message} </div>
	</form>
</body>
</html>