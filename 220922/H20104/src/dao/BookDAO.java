package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.BookVO;

public class BookDAO {
	public BookDAO() {
		
	}
	
	public ArrayList<BookVO> getBookList(String key) {
		ArrayList<BookVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		String str = "%" + key + "%";
		
		try {
			conn = JdbcUtil.getConnection();
				
			if(key.equals("all")) {
				sql = "SELECT * FROM lib_book ORDER BY book_no ASC";
				pstmt = conn.prepareStatement(sql);
			} else {
				sql = "SELECT * FROM lib_book WHERE title like ? ORDER BY book_no ASC";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, str);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookNo(rs.getInt("book_no"));
				vo.setTitle(rs.getString("title"));
				vo.setAuthor(rs.getString("author"));
				vo.setCompany(rs.getString("company"));
				vo.setPrice(rs.getInt("price"));
				vo.setRentaled(rs.getString("rentaled"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("lib_book 테이블 데이터 조회 실패");
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int setRentalField(int BookNo, String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE lib_book SET rentaled=? WHERE book_no=?";
		int result = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, BookNo);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return result;
	}
}
