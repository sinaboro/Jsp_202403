package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//싱글톤.......
public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user= "ezen";
		String password = "1234";
		
		//1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. DB연결		
		return DriverManager.getConnection(url, user, password);
	}
}
