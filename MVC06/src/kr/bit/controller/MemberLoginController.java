package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPass(password);
		
		MemberDAO dao = new MemberDAO();
		String user_name = dao.memberLogin(vo);
		// user_name에 값이 존재하면 인증에 성공한 것이고, user_name에 값이 존재하지 않으면 회원인증이 실패한 경우.
		
		if(user_name != null && !"".equals(user_name)) {
			// 인증 성공 -> 객체 바인딩(다른 페이지들이 회원 인증에 성공했다는 사실을 알기 위해.)
			HttpSession session = request.getSession();
			session.setAttribute("userId", user_id);
			session.setAttribute("userName", user_name);
		} else {
			// 실패
			request.getSession().setAttribute("userId", "");
			request.getSession().setAttribute("userName", "");
			request.getSession().setAttribute("msg", "ID 또는 비밀번호가 틀렸거나 없는 정보 입니다.");
		}
		
		return "redirect:"+ctx+"/memberList.do";
	}

}
