package kr.bit.model;
import java.io.IOException;
import java.io.InputStream;
// JDBC->myBatis, JPA
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	// 초기화 블럭 - 프로그램 실행 시 딱 한번만 실행되는 코드 영역
	static {
		try {
		// sqlSessionFactory는 config.xml에 담긴 정보들을 모두 알고있다. 
		// 따라서 Mapper파일이 어디에 있는지 또한 알고있다.
		String resource = "kr/bit/mybatis/config.xml";
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원 전제 리스트 보기
	public List<MemberVO> memberList() {
		// [Connection + Statement] => SQLSession
		SqlSession  session = sqlSessionFactory.openSession();
		List<MemberVO> list = session.selectList("memberList");
		// Connection POOL에 반납.
		session.close();
		return list;
	}
	
	// 회원가입
	public int memberInsert(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("SQL_ID", vo);
		session.commit(); // insert는 DB의 내용이 수정되기 때문에 commit을 꼭 해준다.
		session.close();
		return cnt;
	}
  
}


