package com.inetsoft.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Description: 用于输出验证码图片的Servlet 
 * @Warning: 
 * @Author DreamLi
 * @Package Day04-Response-Request  --  com.inetsoft.response.ValidServlet
 * @Date: 2017年12月17日 下午4:51:22
 * @Version: 1.0.0
 */
@WebServlet("/ValidServlet")
public class ValidServlet extends HttpServlet {
	
	private static final long serialVersionUID = -70985881600765636L;

	private Random rand = new Random();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置响应头让浏览器不再缓存验证码图片
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//创建验证码图片
		//1.创建一张图片到内存中
		int width = 120;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//2.获取该图片上的画笔
		Graphics2D g = (Graphics2D) img.getGraphics();
		//3.设置背景色以及图片边框
		g.setColor(new Color(199,237,204));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);

		//4.设置干扰线
		int lineNum = randNumber(3,7);//干扰线的条数
		for(int i = 0;i < lineNum;i++){
			g.setColor(new Color(randNumber(0,255),randNumber(0,255),randNumber(0,255)));
			g.drawLine(randNumber(0,width), randNumber(0,height),randNumber(0,width), randNumber(0,height) );
		}

		//5.设置验证码内容
		int row = 10;
		int col = 22;
		g.setFont(new Font("黑体", Font.BOLD, 20));
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i < 4;i++){
			g.setColor(new Color(randNumber(0,255),randNumber(0,255),randNumber(0,255)));
			double theta = Math.toRadians(randNumber(-50, 50)); 
			g.rotate(theta, row, col);
			int num = randNumber(0, 9);
			buffer.append(num);
			g.drawString(num+"", row, col);
			g.rotate(0-theta, row, col);
			row += 30;
		}
		//将验证码加入到session
		request.getSession().setAttribute("valid", buffer.toString());
		System.out.println(buffer);
		//6.写入到输出流中
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	/**
	 * 产生一个区间里面的随机数
	 * @param left 区间左值
	 * @param right 区间右值
	 * @return 区间里面的一个随机数
	 */
	private int randNumber(int left,int right){
		return  rand.nextInt(right - left) + left;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
