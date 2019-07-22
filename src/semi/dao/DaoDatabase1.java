package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import semi.dto.DtoDatabase1;

public class DaoDatabase1 extends JDBCTemplate{
	/*
	 * 관리자 기능
	 * 1. 회원 전체 정보(탈퇴한 회원 포함)
	 * 2. 가입된 회원의 전체 정보(myenabled = Y)
	 * 3. 회원의 등급 조정
	 * */
	
	/*
	 * 유저 기능
	 * 1. 로그인
	 * 2. 회원가입 -> 아이디 중복체크 
	 * 3. 정보 조회
	 * 4. 정보 수정(주소, 비밀번호, 전화번호, 이메일)
	 * 5. 회원 탈퇴(UPDATE MYENABLED='N')
	 * */
	
	public DtoDatabase1 login(String myid, String mypw) {
		
		Connection con = getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;		
		DtoDatabase1 dto = new DtoDatabase1();
		
		String sql = "SELECT * FROM LOGINBOARD WHERE MYID = ? AND MYPW = ? AND MYENABLED = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, myid);
			psmt.setString(2, mypw);
			psmt.setString(3, "Y");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));

			}
		} catch (SQLException e) {
			System.out.println("로그인 오류");
		}finally {
			close(con, psmt, rs);
		}
		
		return dto;
	}
	
	public String idChk(String myid) {
		
		Connection con = getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String res = null;
		
		String sql = " SELECT MYID FROM LOGINBOARD WHERE MYID = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, myid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				res = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, psmt, rs);
		}
		
		return res;
	}

	public int update(DtoDatabase1 dto) {
		Connection con = getConnection();
		PreparedStatement psmt = null;
		String sql = " UPDATE LOGINBOARD SET MYADDR = ?, MYPW = ?, MYPHONE = ?, MYEMAIL = ? WHERE MYNO = ?";
		int res = 0;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getMyaddr());
			psmt.setString(2, dto.getMypw());
			psmt.setString(3, dto.getMyphone());
			psmt.setString(4, dto.getMyemail());
			psmt.setInt(5, dto.getMyno());
			
			res = psmt.executeUpdate();
			
			if(res > 0) {
				commit(con);
			}
			else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, psmt);
		}
		
		return res;
	}

	public int deleteUser(int myno) {
		Connection con = getConnection();
		PreparedStatement psmt = null;
				
		int res = 0;
		
		String sql = " UPDATE LOGINBOARD SET MYENABLED = 'N' WHERE MYNO = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, myno);
			
			res = psmt.executeUpdate();
			
			if(res >0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, psmt);
		}
		
		return res;
	}
	
	public int insert(DtoDatabase1 dto) {
		Connection con = getConnection();
		PreparedStatement psmt = null;
		String sql = " INSERT INTO LOGINBOARD VALUES(MEMBERBOARDSEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		int res = 0;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getMyid());
			psmt.setString(2, dto.getMypw());
			psmt.setString(3, dto.getMyname());
			psmt.setString(4, dto.getMyaddr());
			psmt.setString(5, dto.getMyphone());
			psmt.setString(6, dto.getMyemail());
			psmt.setString(7, "Y");
			psmt.setString(8, "USER");
			
			res = psmt.executeUpdate();
			
			if(res > 0) {
				commit(con);
			}
			else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, psmt);
		}
		
		return res;
	}

	public List<DtoDatabase1> alluser(){
		Connection con = getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;
		List<DtoDatabase1> list = new ArrayList<DtoDatabase1>();
		String sql = "SELECT * FROM LOGINBOARD ORDER BY MYENABLED DESC";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				DtoDatabase1 dto = new DtoDatabase1(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, stmt, rs);
		}
		
		return list;
	}

	public List<DtoDatabase1> enableduser(){
		Connection con = getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;
		List<DtoDatabase1> list = new ArrayList<DtoDatabase1>();
		String sql = "SELECT * FROM LOGINBOARD WHERE MYENABLED = 'Y' ORDER BY MYNO";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				DtoDatabase1 dto = new DtoDatabase1(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				
				
				list.add(dto);
			}
		} catch (SQLException e) {
		}finally {
			close(con,stmt,rs);
		}
		
		return list;
	}
	
	public int createuser(){
		Connection con = getConnection();
		Statement stmt = null;
		
		int res = 0;
		
		String sql = "INSERT INTO LOGINBOARD VALUES(MEMBERBOARDSEQ.NEXTVAL, MEMBERBOARDSEQ.CURRVAL,'test','유저1','서울',MEMBERBOARDSEQ.CURRVAL,MEMBERBOARDSEQ.CURRVAL,'Y','USER')";
		
		try {
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
			
			if(res >0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
		}finally {
			close(con,stmt);
		}
		return res;
	}
	
	public int updaterole(int myno, String myrole) {
		Connection con = getConnection();
		PreparedStatement psmt = null;
		String sql = " UPDATE LOGINBOARD SET MYROLE = ? WHERE MYNO = ?";
		int res = 0;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, myrole);
			psmt.setInt(2, myno);
			
			res = psmt.executeUpdate();
			
			if(res > 0) {
				commit(con);
			}
			else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, psmt);
		}
		return res;
	}

}
