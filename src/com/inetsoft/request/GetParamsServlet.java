package com.inetsoft.request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 通过 request 对象获取请求参数 
 * @Warning: 
 * @Author DreamLi
 * @Package Day04-Response-Request  --  com.inetsoft.request.GetParamsServlet
 * @Date: 2017年12月20日 下午9:18:47
 * @Version: 1.0.0
 */
@WebServlet("/GetParamsServlet")
public class GetParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//只能解决 POST 请求的请求参数乱码问题(GET请求的请求参数在url后面)
//			
		
		//如果上面的方式不能解决GET请求的乱码问题, 可以自行对其解码
		String userName = request.getParameter("username");
		userName =  new String(userName.getBytes("ISO8859-1"), "UTF-8");
		System.out.println(userName);
		
		Object attr = request.getAttribute("attr");
		request.setAttribute("key", "value");
		request.removeAttribute("attr");
		Enumeration<String> attributeNames = request.getAttributeNames();
		
		
		Map<String, String[]> params = request.getParameterMap();
		for (String name : params.keySet()) {
			String value = request.getParameter(name);
			System.out.println("name=" + name + ", value=" + value);
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
