package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		String nextPage = null;
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(vo);
		if(cnt > 0) {
			// update 성공
			nextPage = "/MVC04/memberList.do";
		}
		else {
			// update 실패 => 예외 객체를 만들어 WAS에게 던진다.
			throw new ServletException("not update");
		}
		
		return nextPage;
	}

}
