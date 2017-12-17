package com.inetsoft.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getBytes() 使用平台默认的编码方式
		//response.getOutputStream().write("中国".getBytes("utf-8"));
		
		//getOutputStream 和 getWriter 只能调用一个
		//response.setCharacterEncoding("utf-8");//通知服务器发送数据时使用utf-8编码
		//通知浏览器接受数据时使用utf-8解码
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().write("北京" + new Date().toLocaleString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
