package com.kodb.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kodb.model.service.UserService;
import com.kodb.util.ParameterUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//post방식 한글 깨지지 않게(post는 body부에)
		request.setCharacterEncoding("utf-8");
		//get은 server.xml에서 고쳐(URL)
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		
		System.out.println(userId+"/"+password);
		
		HashMap<String, String> errors = new HashMap<String, String>();
		
		if(ParameterUtil.isEmpty(userId)){
			errors.put("idError", "아이디를 반드시 입력하세요");
		}
		if(ParameterUtil.isEmpty(password)){
			errors.put("pwError", "비밀번호를 반드시 입력하세요");
		}
		
		if(errors.size()>0){
			request.setAttribute("fieldErrors", errors);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;//페이지를 이동하는 부분은 return. 안그러면 밑에부분 실행됌
		}

		UserService userService = new UserService();
		boolean flag = userService.login(userId, password);
		
		//로그인 성공
		if(flag){
			System.out.println("로그인 성공");
			
			/*Cookie c= new Cookie("userId", userId);
			//5초
			c.setMaxAge(10*60);
			response.addCookie(c);*/
			
			//session version
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(10);
			session.setAttribute("userId", userId);
			response.sendRedirect("main.jsp");
			return;
			//로그인 실패	
		}else{
			System.out.println("로그인 실패");
			request.setAttribute("message", "아이디나 비밀번호가 일치하지 않습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			//response.sendRedirect("login.jsp"); 이거 안댐
			return;
		}
		
		
		
		
		
	}
	


}
