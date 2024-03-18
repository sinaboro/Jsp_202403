package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		String url = null;
		
		BoardVO vo = BoardDAO.getInstance().
				checkPassWord(pass, Integer.parseInt(num));
		
		System.out.println("vo >> " + vo);
		if(vo.getPass() == pass) {
			url= "/board/checkSuccess.jsp";
		}else {
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "로그인 실패했습니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
