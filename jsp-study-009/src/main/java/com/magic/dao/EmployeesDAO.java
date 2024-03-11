package com.magic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private EmployeesDAO() {}
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ezen";
		String password = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, password);
	}

	//로그인 체크
	public int userCheck(String id, String pwd, String lev) {
		String sql = "select * from employees where id = ?";
		int result = -1;
		
		try {
			con = getConnection();
		    pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(pwd.equals(rs.getString("pass"))) {
					if(lev.equals(rs.getString("lev"))) {
						result = lev.equals("A") ? 2 : 3;
					}else {
						result = 1; //등급 상이
					}
				}else {
					result = 0; //비밀번호 상이
				}
				
			}else {
				result = -1;  //아이디 상이
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if( rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	//id 해당하는 전체 데이타 가져오기
	public EmployeesVO getMember(String id) {
		String sql = "select * from employees where id = ?";
		EmployeesVO vo = new EmployeesVO();
		
		try {
			con = getConnection();
		    pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//      rs.getString("여기이름은 데이타베이스 필드명"
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getDate("enter"));  //날짜
				vo.setGender(Integer.parseInt(rs.getString("gender")));
				vo.setPhone(rs.getString("phone"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if( rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	//직원 정보 수정
	public int updateEmployee(EmployeesVO vo) {
		String sql = "update EMPLOYEES set pass=?, name=?, lev=?, gender=? "
				+ ", phone=? where id=?";
		int result = -1;
	
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getLev());
			pstmt.setString(4, String.valueOf(vo.getGender()));
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if( pstmt != null) pstmt.close();
				if( con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result; 
	}
}


/*
 String sql = "select * from employees where id = ?";
		int result = -1;
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if( rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result; 
 */













