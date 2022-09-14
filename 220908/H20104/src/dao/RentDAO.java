package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.BookVO;
import vo.RentVO;

public class RentDAO {
	public RentDAO() {
		
	}
	
	public ArrayList<RentVO> getRentalList(String userId) {
		ArrayList<RentVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sqlAll = "SELECT * FROM rent_book ORDER BY rent_no ASC";
		String sqlId = "SELECT * FROM rent_book WHERE member_id=? ORDER BY rent_no ASC";
		
		try {
			conn = JdbcUtil.getConnection();
			if(userId.equals("admin")) {
				pstmt = conn.prepareStatement(sqlAll);
			} else {
				pstmt = conn.prepareStatement(sqlId);
				pstmt.setString(1, userId);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RentVO vo = new RentVO();
				vo.setRentNo(rs.getInt("rent_no"));
				vo.setMemberId(rs.getString("member_id"));
				vo.setBookNo(rs.getInt("book_no"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setBookTitle(rs.getString("title"));
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("rent_book 테이블 데이터 조회 실패");
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public RentVO makeRentData(String userId, int bookNo) {
		RentVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT a.member_name, b.title FROM lib_member a, lib_book b WHERE a.member_id=? AND b.book_no=?";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, bookNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RentVO();
				vo.setMemberId(userId);
				vo.setBookNo(bookNo);
				vo.setMemberName(rs.getString("member_name"));
				vo.setBookTitle(rs.getString("title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rent_book 테이블 데이터 조회 실패");
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public int rentBook(RentVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO rent_book VALUES(rent_seq.nextval, ?, ?, ?, ?)";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setInt(2, vo.getBookNo());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getBookTitle());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return result;
		
	}
	
	public int deleteRent(int bookNo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM rent_book WHERE book_no=?";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		return result;
	}
}
