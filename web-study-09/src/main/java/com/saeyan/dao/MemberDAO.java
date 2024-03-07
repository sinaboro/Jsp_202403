package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.dto.MemberVO;

//싱글톤.......
public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
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

	//ID중복체크 
	public int confirmID(String userid) {
		
		int result = -1;
		
		String sql = "select userid from member where userid = ?";
		
		try {
			
			//1. 연결
			con = getConnection();
			//2. sql문 전송
			pstmt = con.prepareStatement(sql);
			//3. 맵핑
			pstmt.setString(1, userid);
			//4. 실행 및 결과값 받기
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;  //ID 사용가능
			}else {
				result  = -1; //ID 중복 사용 불가
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int insertMember(MemberVO vo) {
		int result = -1;
		
		String sql = "insert into member values(?,?,?,?,?,?)";
		
		try {
			//1. 연결
			con = getConnection();
			//2. sql 구문 전송
			pstmt = con.prepareStatement(sql);
			//3. 맵핑
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			
			//4. 구문실행
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int userCheck(String userid, String pwd) {
		int result = -1;
		
		String sql = "select pwd from member where userid = ? ";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					result = 1; // 아이디 /비밀번호 일치
				}else {
					result = -1; //비빌번호 불일치
				}
			}else {
				result = 0; //아이디 불일치
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}



















