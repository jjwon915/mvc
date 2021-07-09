package kr.bit.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/*
 * 확장자가 .do로 끝나는 모든 요청은 FrontController에게 온다.
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 1. Client가 어떤 요청을 했는지 파악 : 요청 경로도 request(ex : memberList.do)에 담아져 오기 때문에 어떤 요청인지 알 수 있다.
		String url = request.getRequestURI();
		
		// Context 가져오기. : 여기서는 /MVC04가 가져와진다.
		String ctx = request.getContextPath();
		
		// 실제로 요청한 명령이 무엇인지 파악.(client가 요청한 실제 요청 : command)
		String command = url.replaceAll(ctx, "");
		System.out.println(command);
		
		// 요청에 따른 분기 작업
		if(command.equals("/memberList.do")) {
			
			// 회원 리스트
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.memberList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberList.jsp");
			rd.forward(request, response);
			
		}
		else if(command.equals("/memberInsert.do")) {
			
			// 회원 가입(SQL 저장)
			
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
			
			System.out.println(vo.toString());
			
			MemberDAO dao = new MemberDAO();
			int result = dao.memberInsert(vo);
			if(result > 0) {
				// insert 성공
				PrintWriter out = response.getWriter();
				//out.println("insert success");
				response.sendRedirect("/MVC04/memberList.do");
			}
			else {
				// insert 실패 => 예외 객체를 만들어 WAS에게 던진다.
				throw new ServletException("not insert");
			}
			
			
		}
		else if(command.equals("/memberRegister.do")) {
			
			// 회원 가입 페이지
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberRegister.html");
			rd.forward(request, response);
			
		}
		else if(command.equals("/memberContent.do")) {
			
			int num = Integer.parseInt(request.getParameter("num"));
			MemberDAO dao = new MemberDAO();
			
			MemberVO vo = dao.memberContent(num);
			
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response);
			
			
		}
		else if(command.equals("/memberUpdate.do")) {
			
			// parameter 수집
			int num = Integer.parseInt(request.getParameter("num"));
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			MemberVO vo = new MemberVO();
			vo.setNum(num);
			vo.setAge(age);
			vo.setEmail(email);
			vo.setPhone(phone);
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.memberUpdate(vo);
			if(cnt > 0) {
				// update 성공
				response.sendRedirect("/MVC04/memberList.do");
			}
			else {
				// update 실패 => 예외 객체를 만들어 WAS에게 던진다.
				throw new ServletException("not update");
			}
			
			
		}
		else if(command.equals("/memberDelete.do")) {
			
			int number = Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao = new MemberDAO();
			int result = dao.memberDelete(number);
			// System.out.println(result);
			if(result > 0) {
				response.sendRedirect("/MVC04/memberList.do");
			} 
			else {
				throw new ServletException("not delete");
			}
			
		}
		
	}

}
