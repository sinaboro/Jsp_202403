package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("init Method...........");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy Method...........");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
//		response.setContentType("text/plain");
		
		PrintWriter out =  response.getWriter();
		out.println("<html><body><h1>");
		out.println("Hello Servlet<br>");
		out.println("헬로우 서블릿<br>");
		out.println("</h1></body></html>");
		System.out.println("doGet Method...........");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

}
