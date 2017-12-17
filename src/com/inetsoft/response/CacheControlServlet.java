package com.inetsoft.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CacheControlServlet
 */
@WebServlet("/CacheControlServlet")
public class CacheControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//	Expires: -1
	//	Cache-Control: no-cache  
	//	Pragma: no-cache
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setIntHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.getWriter().write(new Date().toLocaleString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
