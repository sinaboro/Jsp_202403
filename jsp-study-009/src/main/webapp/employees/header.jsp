<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	td{
		border: 1px solid black;
		width: 200px;
		text-align: center;  
	}
</style>


</head>
<body>
	<table>
		<c:if test="${empty loginUser}">
			<tr>
				<td></td><td></td>
				<td><a href="login.do" style="text-decoration: none;">로그인</a></td>
				<td width="250px">
					사원등록<br>
					<span style="color: red">(관리자로 로그인 후 사용 가능)</span>
				</td>
				<td>
					마이페이지<br>
					<span style="color: red">(로그인 후 사용가능)</span>
				</td>
			</tr>
		</c:if>
	</table>
</body>
</html>














