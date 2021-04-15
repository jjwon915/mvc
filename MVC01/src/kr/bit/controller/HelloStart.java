package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloStart
 */
@WebServlet("/h.do")
public class HelloStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloStart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 서블릿에 모두 담당하게 하면 응답이 느리기 때문에 for문과 같은 Logic은 Model로, PrintWriter 부분은 View(jsp)로 나누어 구현한다.
		// 1. 클라이언트의 요청을 받는 작업(parameter 수집) -> Controller(servlet)
		// 2. 처리하는 작업(business logic) -> Model(java class)
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		//3. 요청한 클라이언트에게 응답하는 작업 -> View(jsp)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>" + sum + "</h1></body>");
		out.println("</html>");
		out.close();
	}

}
