package com.inetsoft.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CustomerInfo")
public class CustomerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = request.getRequestURL().toString();
		System.out.println(url);
		
		String uri = request.getRequestURI().toString();
		System.out.println(uri);
		
		String params = request.getQueryString();
		System.out.println(params);
		
		String method = request.getMethod();
		System.out.println(method);
		
		String addr = request.getRemoteHost() + request.getRemotePort() + request.getRemoteAddr() +
			"==user=" + request.getRemoteUser();
		System.out.println("addr: " + addr);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
