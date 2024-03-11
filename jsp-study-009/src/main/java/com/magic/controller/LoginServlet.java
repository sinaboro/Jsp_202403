package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("employees/login.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		String url = "employees/login.jsp";
		/*
		 * -1 : 아이디 틀림 비밀번호 틀림
		 *  0 : 비밀번호 틀림
		 *  1 : 등급 상이
		 *  2 : 아이디/비밀번호/A 
		 *  3 : 아이디/비밀번호/B
		 */
		int result = eDao.userCheck(id,pwd,lev);
		
		if(result == 2 || result == 3) {
			
			EmployeesVO vo =  eDao.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			session.setAttribute("result", result);
			url = "employees/main.jsp";
			
		}else {
			if(result == 1) {
				request.setAttribute("message", "레벨 등급을 확인하세요.");
			}else if(result == -1) {
				request.setAttribute("message", "존재하지 않는 아이디입니다.");
			}else if(result == 0) {
				request.setAttribute("message", "비밀번호가 틀립니다.");
			}
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}













