package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDbCheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// $.ajax()에서 오는 요청 처리.
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		String dbDouble = dao.memberDbCheck(id);
		
		// ajax의 callback 함수로 응답된다. : dbCheck 함수의 data 부분에 dbDouble이 입력된다.
		response.getWriter().print(dbDouble);
		
		return null;
	}

}
