package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.web.JdbcUtil;

public class MemberDAO {
	public  ArrayList<String> getMemberList() {
		ArrayList<String> list = new ArrayList<>();
		
		// DB 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT userid FROM member";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 회원추가 기능 구현
	public int insertMember(String userId, String userPwd) {
		int n = 0;
		
		// DB 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member VALUES(?, ?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	// 회원 패스워드 수정 기능 구현
	public int updateMember(String userId, String userPwd) {
		int n = 0;
		
		// DB 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET userpwd=? WHERE userid=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	// 회원 정보 삭제 기능 구현
	public int deleteMember(String userId) {
		int n = 0;
		
		// DB 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM member WHERE userid=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
