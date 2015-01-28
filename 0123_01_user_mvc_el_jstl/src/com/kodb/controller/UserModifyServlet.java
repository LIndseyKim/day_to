package com.kodb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodb.model.service.UserService;
import com.kodb.model.vo.User;

/**
 * Servlet implementation class UserModifyServlet
 */
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		UserService service = new UserService();
		service.modifyUser(new User(userId, password, name, email));
		
		//redirect는 get방식
		response.sendRedirect(request.getContextPath() + "/controller/user_list.do");
		//response.sendRedirect("controller/user_list.do");
		return;
	}

	
	
	
}
