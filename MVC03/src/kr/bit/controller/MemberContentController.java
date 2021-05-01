package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.memberContent(num);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");		 
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
		out.println("<style type='text/css'>"); 
		out.println("</style>"); 
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='/MVC01/memberUpdate.do' method='post'>");
		out.println("<input type='hidden' name='num' value='"+vo.getNum()+"'/>");
		out.println("<table class='table table-bordered'>");
		if(vo != null) {
			out.println("<tr>");
			out.println("<td colspan='2'>" + vo.getName() + "회원님의 회원정보입니다.</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>번호</td>");
			out.println("<td>" + vo.getNum() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>아이디</td>");
			out.println("<td>" + vo.getId() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>비밀번호</td>");
			out.println("<td>" + vo.getPass() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이름</td>");
			out.println("<td>" + vo.getName() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>나이</td>");
			out.println("<td><input type='text' name='age' value='" + vo.getAge() + "'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이메일</td>");
			out.println("<td><input type='text' name='email' value='" + vo.getEmail() + "'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>전화번호</td>");
			out.println("<td><input type='text' name='phone' value='" + vo.getPhone() + "'/></td>");
			out.println("</tr>");
			
		} else {
			// 회원 정보가 없음.
			out.println("<script>alert('일치하는 회원정보가 없습니다.');</script>");
			out.flush();
			 
			out.close();
			response.sendRedirect("/MVC01/memberList.do");
		}
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' class='btn btn-success' value='수정하기'/>");
		out.println("<input type='reset' class='btn btn-danger' value='취소'/>");
		out.println("<button class='btn btn-info'><a href='/MVC01/memberList.do' style='text-decoration:none;color:white'>리스트</a></button>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
