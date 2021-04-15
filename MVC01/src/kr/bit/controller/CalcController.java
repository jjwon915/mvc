package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트에서 넘어오는 Form Parameter 받기(num1, num2 : request에 담겨서 온다.)
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// 2. num1 ~ num2 사이의 합 구하기.
		int sum = 0;
		for(int i = num1; i <= num2; i++){
			sum += i;
		}
		
		PrintWriter out = response.getWriter();
		out.println("Sum : " + sum);
	}

}
