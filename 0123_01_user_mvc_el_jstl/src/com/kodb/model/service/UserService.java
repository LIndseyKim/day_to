package com.kodb.model.service;

import java.util.ArrayList;

import com.kodb.model.dao.UserDao;
import com.kodb.model.vo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	
	public void registerUser(User user){
		
		System.out.println("[registerUser]");
		// 아이디에 일치하는 회원정보 조회 : select
		User member = userDao.selectUser(user.getUserId());
		// 회원이 없다면 회원정보 저장 : insert
		if(member == null){
			userDao.insertUser(user);
		}
	}
	
	public User getUser(String userId){
		System.out.println("[getUser]");
		// 아이디에 일치하는 회원정보 조회 : select
		return userDao.selectUser(userId);
	}
	
	// 아이디에 일치하는 회원 삭제
	public void removeUser(String userId){
		System.out.println("[removeUser]");
		User member = userDao.selectUser(userId);
		if(member != null){
			userDao.deleteUser(userId);
		} else{
			System.out.println(userId + " 회원은 존재하지 않습니다.");
		}
	}
	
	// 아이디에 해당하는 회원정보 수정
	public void modifyUser(User user){
		System.out.println("[modifyUser]");
		
		User member = userDao.selectUser(user.getUserId());
		if(member != null){
			userDao.updateUser(user);
		} else{
			System.out.println(user.getUserId() + " 회원은 존재하지 않습니다.");
		}
	}
	
	// 회원 전체 리스트 조회하여 리턴
	public ArrayList<User> getAllUser(){
		System.out.println("[getAllUser]");

		return userDao.selectUser();
	}
	
	// 로그인 성공시 true, 로그인 실패시 false 리턴
	public boolean login(String userId,String password){
		System.out.println("[login]");
		
		 return userDao.selectUser(userId, password); 
	}
	
}







