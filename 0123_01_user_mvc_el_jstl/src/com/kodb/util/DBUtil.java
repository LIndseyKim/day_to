package com.kodb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

/*	private static final String URL = "jdbc:oracle:thin:@128.134.42.68:1521:xe";
	private static final String USER_NAME = "scott";
	private static final String USER_PASSWORD = "tiger";
	
	// static initializer
	static {
		// step1. driver loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
*/
	//Connection Interface에서 상속받은 원래쓰던 Connection, 새로 배운PooledConnection
	//앞의 close(), 뒤의 close() 의미 다르지만 재정의?하기 때문에 고칠 필요 없다!
	//앞은 connect 끊기, 뒤는 반납!
	
	//Connection pool -> 드라이버 로딩 context.xml에서 이미 함 (META-INF)
	private static DataSource ds = null;
	
	static{	
		try {
			Context initContext = new InitialContext();
			
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			
			ds = (DataSource)envContext.lookup("jdbc/OracleDB");
			
			//ds = (DataSource)envContext.lookup("java:/comp/env/jdbc/OracleDB");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		//return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
		return ds.getConnection();
	}
	
	
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();//pool에 반납
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	
	
}








