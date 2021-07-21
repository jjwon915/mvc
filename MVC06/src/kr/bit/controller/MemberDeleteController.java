package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int number = Integer.parseInt(request.getParameter("num"));
		
		String ctx = request.getContextPath();
		String nextPage = null;
		MemberDAO dao = new MemberDAO();
		int result = dao.memberDelete(number);
		
		if(result > 0) {
			request.getSession().invalidate();
			nextPage = "redirect:" +  ctx + "/memberList.do";
		} 
		else {
			throw new ServletException("not delete");
		}
		
		return nextPage;
	}

}
