package com.magic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		if(session != null) {
			request.getRequestDispatcher("emplyees/mypage.jsp")
				.forward(request, response);
		}else {
			response.sendRedirect("login.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		
		EmployeesVO vo = new EmployeesVO();
		vo.setName(name);
		vo.setId(id);
		vo.setPass(pwd);
		vo.setGender(gender);
		vo.setPhone(phone);
		vo.setLev(lev);
		
		EmployeesDAO mDao = EmployeesDAO.getInstance();
		int result  = mDao.updateMember(vo);
		
		response.sendRedirect("login.do");
	}

}
