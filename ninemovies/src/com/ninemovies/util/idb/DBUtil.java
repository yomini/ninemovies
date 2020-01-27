package com.ninemovies.util.idb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe"; //xe버전...
	private static final String id = "java14"; //집에서.. C##안붙음..
	private static final String pw = "java14";
	
	private static boolean checkDriver = false;
	
	//static block{} - 클래스 초기화 블럭. 클래스 메모리에 처음 로딩할 때 한번만 실행 
	// 드라이버 로딩 
	static {
		try {
			Class.forName(driver); // ()정보를 로드해줌
			checkDriver = true;
 		} catch (ClassNotFoundException e) {  //driver 정보가 없으면
 			checkDriver = false;
 			e.printStackTrace();
		}
	}

	//connection 연결객체생성 - DriverManager를 통해서.
	public static Connection getConnection() throws SQLException {
		if(checkDriver) //True면, 즉 driver정보 있으면
			return DriverManager.getConnection(url, id, pw);
		throw new SQLException("Driver doesn't exist:/");
	}
	
	public static void close(Connection con, PreparedStatement pstmt) throws SQLException{
		close(con, pstmt);
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException{
		close(con, pstmt, rs);
	}
	
}//end DBUtil{}
