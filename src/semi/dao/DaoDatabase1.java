package semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import semi.dao.SqlMapConfig;
import semi.dto.DtoDatabase1;

public class DaoDatabase1 extends SqlMapConfig {
	private String namespace = "muldelmapper.";
	private SqlSession session = null;
	
	public DtoDatabase1 login(String myid, String mypw) {
		
		DtoDatabase1 dto = new DtoDatabase1();
		
		try {
			session = getSqlSessionFactory().openSession(false);
			dto = session.selectOne(namespace+"login");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	
	public String idChk(String myid) {
		String res = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne(namespace+"idcheck",myid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	public int update(DtoDatabase1 dto) {

		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"update",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	public int deleteUser(int myno) {
		
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"deleteuser",myno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	public int insert(DtoDatabase1 dto) {
		
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insert",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	public List<DtoDatabase1> alluser(){
		
		List<DtoDatabase1> list = new ArrayList<DtoDatabase1>();

		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"alluser");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	public List<DtoDatabase1> enableduser(){

		List<DtoDatabase1> list = new ArrayList<DtoDatabase1>();
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"enableduser");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
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
