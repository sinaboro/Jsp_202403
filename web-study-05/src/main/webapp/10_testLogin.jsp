<%@page import="unit01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = "test";
String pwd = "1234";
String name = "강원도";

MemberVO member = new MemberVO();

member.setId(id);
member.setName(name);
member.setPwd(pwd);

if (id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
	
	//session.setAttribute("loginUser", name);
	session.setAttribute("member", member);
	
	response.sendRedirect("10_main.jsp");
} else {
	response.sendRedirect("10_loginForm.jsp");
}
%>