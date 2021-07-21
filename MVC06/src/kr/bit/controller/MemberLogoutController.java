package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 세션을 가져와서 세션 제거하기
		 * 세션을 제거하는 3가지 방법
		 * 1. 강제로 종료
		 * 2. 브라우저를 종료하는 것(JSESSIONID가 브라우저의 쿠키에 저장되어 있기 때문)
		 * 3. 세션이 종료될때까지 기다리는 것.(세션 타임아웃 : 30분)
		 * */
		
		// 강제로 종료하는 방법.
		String ctx = request.getContextPath();
		request.getSession().invalidate();
		
		return "redirect:" + ctx + "/memberList.do";
	}

}
