package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("driver 연결 오류");
			e.printStackTrace();
		}
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("계정 연결 오류");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstm, Connection con) {
		try {
			con.close();
			pstm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("close 오류");
			e.printStackTrace();
		}
		
	}
	
	public static void close(PreparedStatement pstm, Connection con) {
		try {
			pstm.close();
			con.close();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
	}
	
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
