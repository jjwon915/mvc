package kr.bit.model;

// JDDBC -> myBatis, JPA로 바뀌면서 많이 사용 X
import java.sql.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB 연결(Connection)객체 생성(TEST DB 접속 URL, user, password 필요)
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
	
	// insert
	public int memberInsert(MemberVO vo) {
		String SQL = "insert into member(id, pass, name, age, email, phone) values (?,?,?,?,?,?)";
		getConnect();
		int cnt = -1;
		
		// SQL 문장을 전송하는 객체 생성
		try {
			// 미리 Compile
			ps = conn.prepareStatement(SQL);
			// Setting
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			
			// 성공한 row의 수가 넘어온다. 성공시 1, 실패시 0
			cnt = ps.executeUpdate(); // 전송(실행)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 성공여부 (1 or 0) return 
		return cnt;
	}
}
