package kr.bit.model;

// JDDBC -> myBatis, JPA로 바뀌면서 많이 사용 X
import java.sql.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB 연결객체 생성(TEST DB 접속 URL, user, password 필요)
	public void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password ="1234";
		
		// MySQL Driver Memory에 Loading
		try {
			// 동적 로딩(실행 시점에 메모리에 로딩)
			Class.forName("com.mysql.jdbc.Driver"); 
			// MySQL DB 접속 시도 후 성공시 연결 정보를 Connection 객체인 conn에 넘겨준다. 실패시 예외 발생.
			conn = DriverManager.getConnection(URL, user, password); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
