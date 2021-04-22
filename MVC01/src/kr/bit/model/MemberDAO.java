package kr.bit.model;

// JDDBC -> myBatis, JPA로 바뀌면서 많이 사용 X
import java.sql.*;
import java.util.ArrayList;
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
		} finally {
			dbClose();
		}
		
		// 성공여부 (1 or 0) return 
		return cnt;
	}
	
	// 회원(VO) 전체 리스트(ArrayList) 가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL = "select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery(); // rs : 커서(결과 집합의 첫번째 컬럼 명을 가리킨다)
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				// MemberVO로 묶어서 ArrayList로 담는다. 
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}
	
	public int memberDelete(int num) {
		String SQL = "delete from member where num=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	// 데이터베이스 연결 끊기
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
