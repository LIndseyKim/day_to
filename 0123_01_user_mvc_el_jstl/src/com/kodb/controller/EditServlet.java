package com.kodb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodb.model.service.UserService;
import com.kodb.model.vo.User;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");

		UserService userService = new UserService();
		User user = userService.getUser(userId);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("user_edit.jsp").forward(request, response);
		return;
	}

}
