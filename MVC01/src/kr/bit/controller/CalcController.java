package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MyCalc;

@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	// Tomcat이 생성 -> HttpServletRequest : 요청객체, HttpServlet Response : 응답객체를 만들고 client 식별 위해 packet의 헤더부분(client의 정보)를 저장한다. 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트에서 넘어오는 Form Parameter 받기(num1, num2 : request에 담겨서 온다.)
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		/*
		// 2. num1 ~ num2 사이의 합 구하기. --> Model로 분리
		int sum = 0;
		for(int i = num1; i <= num2; i++){
			sum += i;
		}
		*/
		
		MyCalc my = new MyCalc();
		int sum = my.sum(num1, num2);
		
		// 3. 응답.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='2'>");
		out.println("<tr>");
		out.println("<td>SUM</td>");
		out.println("<td>");
		out.println(sum);
		out.println("</td>");
		out.println("</body>");
		out.println("</html>");
	}

}
