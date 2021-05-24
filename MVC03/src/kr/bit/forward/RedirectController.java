package kr.bit.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = "jewon";
		int age = 25;
		String email = "admin@gmail.com";
		// View Page(result.jsp)로 데이터를 전달하여 View Page에서 출력.
		// controller에서 View로 페이지를 전환하는 방법 두 가지 => 1. redirect 2. forward
		// 1. redirect
		// request.setAttribute("data", data);
		response.sendRedirect("view/result.jsp?name="+name+"&age="+age+"&email="+email);
	}

}
