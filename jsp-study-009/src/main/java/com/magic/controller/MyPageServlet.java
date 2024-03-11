package com.magic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;


@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeesVO emp = (EmployeesVO)session.getAttribute("loginUser");
		
		if(emp != null) {
			request.getRequestDispatcher("employees/mypage.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.do");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		EmployeesVO vo = new EmployeesVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setGender(Integer.parseInt(request.getParameter("gender")));
		vo.setPhone(request.getParameter("phone"));
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		HttpSession session = request.getSession();
		String url = null;
		int result = eDao.updateEmployee(vo);
		
		if(result == 1) {
			vo = eDao.getMember(vo.getId());
			request.setAttribute("message", "회원 정보가 수정되었습니다");
			request.setAttribute("member", vo);
			
			session.setAttribute("loginUser", vo);
			
			result =eDao.userCheck(vo.getId(), vo.getPass(), vo.getLev()); //레벨 체크하기위해서...
			request.setAttribute("result", result);
			
			url = "employees/joinsuccess.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
