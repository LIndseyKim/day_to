package com.kodb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kodb.model.vo.User;
import com.kodb.util.DBUtil;

public class UserDao {
	
	public User selectUser(String userId){
		User user = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select userId, password, name, email from userinfo where userId = ?";
				
		try {
			// step2. db connect			
			conn = DBUtil.getConnection();
			
			// step3. create stream
			stmt = conn.prepareStatement(sql);
			
			// step4. bind data and run sql
			stmt.setString(1, userId);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return user;
	}
	
	public boolean selectUser(String userId, String pwd){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select userId, password, name, email from userinfo where userId = ? and password = ?";
				
		try {
			// step2. db connect			
			conn = DBUtil.getConnection();
			
			// step3. create stream
			stmt = conn.prepareStatement(sql);
			
			// step4. bind data and run sql
			stmt.setString(1, userId);
			stmt.setString(2, pwd);
			
			rs = stmt.executeQuery();
						
			if(rs.next()){
				return true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return false;
	}
	
	public ArrayList<User> selectUser(){
		ArrayList<User> users = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select userId, password, name, email from userinfo order by userId";
				
		try {
			// step2. db connect			
			conn = DBUtil.getConnection();
			
			// step3. create stream
			stmt = conn.prepareStatement(sql);
			
			// step4. run sql
			
			rs = stmt.executeQuery();
			
			
			while(rs.next()){
				users.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return users;
	}
	
	public void insertUser(User user){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "insert into userinfo values(?,?,?,?)";
				
		try {
			// step2. db connect			
			conn = DBUtil.getConnection();
			
			// step3. create stream
			stmt = conn.prepareStatement(sql);
			
			// step4. bind data and run sql
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getEmail());
			
			int count = stmt.executeUpdate();
			
			System.out.println("insert : "+count + "행이 처리되었습니다.");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
	}
	
	public void deleteUser(String userId){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "delete from userinfo where userId = ?";
				
		try {
			// step2. db connect			
			conn = DBUtil.getConnection();
			
			// step3. create stream
			stmt = conn.prepareStatement(sql);
			
			// step4. bind data and run sql
			stmt.setString(1, userId);
			
			int count = stmt.executeUpdate();
			
			System.out.println("delete : "+count + "행이 처리되었습니다.");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
	}
	
	public void updateUser(User user){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "update userinfo set password = ?, name = ?, email = ? where userId = ?";
				
		try {
			// step2. db connect			
			conn = DBUtil.getConnection();
			
			// step3. create stream
			stmt = conn.prepareStatement(sql);
			
			// step4. bind data and run sql
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getUserId());
			
			int count = stmt.executeUpdate();
			
			System.out.println("update : "+count + "행이 처리되었습니다.");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
	}
}
