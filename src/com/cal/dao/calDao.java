package com.cal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cal.dto.calDto;
import common.JDBCTemplate;

public class calDao extends JDBCTemplate{
	
	public List<calDto> getCalList(String id, String yyyyMMdd){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<calDto> list = new ArrayList<calDto>();
		
		String sql = " SELECT SEQ,ID,TITLE,CONTENT,MDATE,REGDATE FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE,1,8) = ? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				calDto dto = new calDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("쿼리문 오류"+sql);
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		
		return list;
	}
	
	public int insertCalBoard(calDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO CALBOARD VALUES(CALBOARDSEQ.NEXTVAL,?,?,?,?,SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getMdate());
			
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			System.out.println("쿼리문 실행 오류"+sql);
			e.printStackTrace();
		} finally {
			close(pstm, con);
		}
		
		
		return res;
	}
	
	public int deleteCalBoard(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM CALBOARD WHERE SEQ = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			System.out.println("쿼리문 실행 오류"+sql);
			e.printStackTrace();
		} finally {
			close(pstm, con);
		}
		
		return res;
	}
	
	public List<calDto> getCalViewList(String id, String yyyyMM){
		
		List<calDto> list = new ArrayList<calDto>();	
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM(SELECT (ROW_NUMBER() OVER(PARTITION BY SUBSTR(MDATE,1,8) ORDER BY MDATE)) RN, "
				+ " SEQ, ID, TITLE, CONTENT, MDATE, REGDATE FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE,1,6) = ?) "
				+ " WHERE RN BETWEEN 1 AND 3 ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMM);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
							// 1번 INDEX에는 ROW_NUMBER(RN)이 들어 있기때문에 2번부터 시작 !!
				calDto dto = new calDto(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("쿼리문 오류"+sql);
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		
		return list;
	}
	
	public int getCalViewCount(String id, String yyyyMMdd) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		String sql = " SELECT COUNT(*) FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE,1,8) = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, yyyyMMdd);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("sql 자료 가져오기 실패");
			e.printStackTrace();
		}
		
		return count;
	}

}
