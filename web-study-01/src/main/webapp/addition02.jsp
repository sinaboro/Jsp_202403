<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%   
	
		int num1 = 10;
		int num2 = 20;
		int add = num1+num2;
	%>
	
	<%= num1 %> + <%= num2 %> = <b><%= add %></b>
	<br><hr>
	
	<%
		String name = "김대철";
		int age = 52;
		
		int ran = (int)(Math.random()*10)+1;
	%>
	
	이름 : <%=name %> <br>
	나이 : <%= age %> <br>
	랜덤 : <%= ran %>
	
</body>
</html>