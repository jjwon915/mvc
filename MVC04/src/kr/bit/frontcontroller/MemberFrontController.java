package kr.bit.frontcontroller;

import java.io.IOException;
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
		
		// 1. Client가 어떤 요청을 했는지 파악 : 요청 경로도 request(ex : memberList.do)에 담아져 오기 때문에 어떤 요청인지 알 수 있다.
		String url = request.getRequestURI();
		
		// Context 가져오기. : 여기서는 /MVC04가 가져와진다.
		String ctx = request.getContextPath();
		
		// 실제로 요청한 명령이 무엇인지 파악.(client가 요청한 실제 요청 : command)
		String command = url.replaceAll(ctx, "");
		System.out.println(command);
		
		// 요청에 따른 분기 작업
		if(command.equals("/memberList.do")) {
			System.out.println("member");
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.memberList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberList.jsp");
			rd.forward(request, response);
		}
		else if(command.equals("/memberInsert.do")) {
			
		}
		else if(command.equals("/memberRegister.do")) {
			
		}
		else if(command.equals("/memberContent.do")) {
			
		}
		else if(command.equals("/memberUpdate.do")) {
			
		}
		else if(command.equals("/memberDelete.do")) {
			
		}
		
	}

}
