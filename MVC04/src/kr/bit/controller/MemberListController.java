package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Model 연동
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// 2. 객체바인딩까지.
		request.setAttribute("list", list);
		
		// member/memberList.jsp에게 list를 줘야한다.
		// 3. 다음 페이지로 넘어가는 정보를 return 해준다.
		
		return "member/memberList.jsp";
		
	}

}
