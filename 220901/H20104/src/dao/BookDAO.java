package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.JDBCUtil;

import vo.BookVO;

public class BookDAO {
	public BookDAO() {
		
	}
	
	public ArrayList<BookVO> getBookList() {
		ArrayList<BookVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM bookshop order by isbn";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setAuthor(rs.getString("author"));
				vo.setCompany(rs.getString("company"));
				vo.setPrice(rs.getInt("price"));
				
				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public int insertBookData(BookVO data) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO bookshop VALUES(?,?,?,?,?)";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getIsbn());
			pstmt.setString(2, data.getTitle());
			pstmt.setString(3, data.getAuthor());
			pstmt.setString(4, data.getCompany());
			pstmt.setInt(5, data.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return result;
	}
}
