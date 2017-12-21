package com.inetsoft.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description: 请求转发 
 * @Warning: 
 * @Author DreamLi
 * @Package Day04-Response-Request  --  com.inetsoft.request.DispatcherTest1
 * @Date: 2017年12月21日 下午7:00:39
 * @Version: 1.0.0
 */
@WebServlet("/DispatcherTest1")
public class DispatcherTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("from 1");
//		response.getWriter().flush();
//		request.getRequestDispatcher("/DispatcherTest2").include(request, response);
//		this.getServletContext().getRequestDispatcher("/DispatcherTest2").forward(request, response);

		response.sendRedirect(request.getContextPath() + "/DispatcherTest2");
		response.sendRedirect(request.getContextPath() + "/DispatcherTest2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
