package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int result = dao.memberInsert(vo);
		String nextPage = null;
		
		if(result > 0) {
			// insert 성공
			PrintWriter out = response.getWriter();
			nextPage = "/MVC04/memberList.do";
		}
		else {
			// insert 실패 => 예외 객체를 만들어 WAS에게 던진다.
			throw new ServletException("not insert");
		}
		
		
		return nextPage;
	}

}
