package com.inetsoft.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("美女.jpg"));
InputStream in = new FileInputStream(this.getServletContext().getRealPath("美女.jpg"));
OutputStream out = response.getOutputStream();
byte[] bytes = new byte[1024];
int len = -1;
while(-1 != (len = in.read(bytes))) {
	out.write(bytes, 0, len);
}
in.close();
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
