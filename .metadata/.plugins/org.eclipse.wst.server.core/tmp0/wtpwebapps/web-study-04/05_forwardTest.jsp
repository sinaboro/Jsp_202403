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
	//문자열을 정수로 변환
	int age = Integer.parseInt(request.getParameter("age"));

	if(age<=19){
%>
    <!-- 자바스크립트 코드 기입 -->
    
    <script type="text/javascript">
    	alert("19세 미만은 입장 불가능");
    	history.go(-1);
    </script>
    
    
<%
	}else{
		request.setAttribute("name", "홍길동");
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("05_forwardResult.jsp");
		dispatcher.forward(request, response);
	}

%>

</body>
</html>