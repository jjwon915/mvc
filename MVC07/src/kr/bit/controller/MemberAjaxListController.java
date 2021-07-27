package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberAjaxListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		
		// json 형태로 응답해야 하기 때문에 Gson API를 사용해 List 객체를 json 형태로 변환.
		Gson g = new Gson();
		String json = g.toJson(list);
		System.out.println(json);
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json);
		
		return null;
	}

}
