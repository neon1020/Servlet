package test8_board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {
	
	// 1. DB 접속을 수행하는 getConnection() 메소드 정의
	// => 파라미터 : 없음   리턴타입 : java.sql.Connection(con)
	public static Connection getConnection() {
		// DBCP 를 활용한 Connection 객체 리턴하기
		Connection con = null;
		
		// -------------------------------------------------------------------------------------------
		try {
			// context.xml 에 설정된 DBCP(커넥션풀) 로부터 Connection 객체 가져오기
			// 1.
			Context initCtx = new InitialContext();
			
			// 2.
			// Context envCtx = (Context)initCtx.lookup("java:comp/env");
			
			// 3.
			// DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQL");
			
			// 2번과 3번 작업 하나로 결합
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/MySQL");
			
			// 4.
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// -----------------------------------------------------------------------------------------------
	
	// 2. DB 자원 반환을 수행하는 close() 메소드 정의
	// => 반환해야하는 대상 객체 : Connection, PreparedStatement, ResultSet
	// => 메소드 이름은 close() 로 통일하고, 파라미터 타입만 다르게 하는 오버로딩 활용하여 정의
	public static void close(Connection con) {
		try {
			if(con != null) { con.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null) { pstmt.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) { rs.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}