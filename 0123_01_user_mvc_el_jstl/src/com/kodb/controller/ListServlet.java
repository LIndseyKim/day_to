package com.kodb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodb.model.service.UserService;
import com.kodb.model.vo.User;

public class ListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		UserService userService = new UserService();
		List <User> userList = userService.getAllUser();
		req.setAttribute("userList", userList);
		
//		req.getRequestDispatcher("../user_list.jsp").forward(req, resp);
		req.getRequestDispatcher("/user_list.jsp").forward(req, resp);

		return;

	}
	




}
