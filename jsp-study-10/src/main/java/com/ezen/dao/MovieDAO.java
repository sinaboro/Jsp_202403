package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.ezen.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	
	private static MovieDAO instance = new MovieDAO();
	
	private MovieDAO() {}
	
	public static MovieDAO getInstance() {
		return instance;
	}
	
	//전체 리스트 가져오기
	public List<MovieVO> movieList() {
		String sql = "select * from movie";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(rs, pstmt, con);
		}
		
		return null;
	}
	
	//한 영화 가져오기
	public MovieVO getOneMovie(int code) {
		
		return null;
	}
	
	//영화 수정
	public void updateMovie(MovieVO vo) {
		
	}
	
	//영화 저장
	public void insertMoive(MovieVO vo) {
		
	}
	
	//영화 삭제
	public void deleteMoive(int code) {
		
	}
	
}
