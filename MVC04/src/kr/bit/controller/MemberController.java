package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

// 6개의 POJO가 해야할 일을 1개의 POJO로 변경한 것!
public class MemberController{
	
	// MemberContentController
	@RequestMapping("/memberContent.do")
	public String memberContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.memberContent(num);
		
		request.setAttribute("vo", vo);
		
		return "memberContent"; // View의 이름만 return (경로가 바뀌면 모두 수정해야 하니까)
		//return "/WEB-INF/member/memberContent.jsp";
	}
	
	// MemberDeleteController
	@RequestMapping("/memberDelete.do")
	public String memberDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int number = Integer.parseInt(request.getParameter("num"));
		
		String ctx = request.getContextPath();
		String nextPage = null;
		MemberDAO dao = new MemberDAO();
		int result = dao.memberDelete(number);
		
		if(result > 0) {
			nextPage = "redirect:" +  ctx + "/memberList.do";
		} 
		else {
			throw new ServletException("not delete");
		}
		
		return nextPage;
	}
	
	// MemberInsertController
	@RequestMapping("/memberInsert.do")
	public String memberInsert(HttpServletRequest request, HttpServletResponse response)
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
		String ctx = request.getContextPath();
		String nextPage = null;
		
		if(result > 0) {
			// insert 성공
			PrintWriter out = response.getWriter();
			nextPage = "redirect:" + ctx + "/memberList.do";
		}
		else {
			// insert 실패 => 예외 객체를 만들어 WAS에게 던진다.
			throw new ServletException("not insert");
		}
		
		
		return nextPage;
	}
	
	// MemberListController
	@RequestMapping("/memberList.do")
	public String memberList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Model 연동
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// 2. 객체바인딩까지.
		request.setAttribute("list", list);
		
		// member/memberList.jsp에게 list를 줘야한다.
		// 3. 다음 페이지로 넘어가는 정보를 return 해준다.
		
		return "memberList";
		
	}
	
	// MemberRegister
	@RequestMapping("/memberRegister.do")
	public String memberRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "memberRegister";
	}
	
	// MemberUpdate
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response)
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
		
		String ctx = request.getContextPath();
		String nextPage = null;
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(vo);
		if(cnt > 0) {
			// update 성공
			nextPage = "redirect:" + ctx + "/memberList.do";
		}
		else {
			// update 실패 => 예외 객체를 만들어 WAS에게 던진다.
			throw new ServletException("not update");
		}
		
		return nextPage;
	}
	
}
