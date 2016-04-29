package com.netease.server;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class imgServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("��֤�����");
		BufferedImage bi=new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g=bi.getGraphics();
		Color c=new Color(200,150,255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);
		
		char [] ch ="ABCDEFGHIJKLMNOPQRSTUVWXYX0123456789".toCharArray();
		Random r=new Random();
		int len=ch.length,index;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<4;i++){
			index=r.nextInt(len);
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			g.drawString(ch[index]+"",(i*15)+4,18);
			sb.append(ch[index]);
			
		}
		req.getSession().setAttribute("piccode",sb.toString());
		ImageIO.write(bi, "JPG", resp.getOutputStream());
		
	}
	
}
