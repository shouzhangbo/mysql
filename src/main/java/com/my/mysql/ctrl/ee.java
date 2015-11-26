package com.my.mysql.ctrl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ee {

	//图片的宽度
	private static int WIDTH = 100;
	//图片的高度
	private static int HEIGHT = 40;
	//验证码上字符数
	private static int NUM = 4;
	private InputStream is;
	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
	   'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
	   'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
	   '9' };
	public static void main(String[] args) {
		System.out.println(new ee().randomImage());
	}
	private Color randomColor(Random r) {
		  return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		}
	/**
	  * 生成图片
	  * @return
	  */
	private byte[] randomImage() {
	  Random r = new Random();

	  // 图片的内存映像
	  BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
	    BufferedImage.TYPE_INT_RGB);

	  // 获得画笔对象
	  Graphics g = image.getGraphics();
	  g.setColor(randomColor(r));
	  g.fillRect(0, 0, WIDTH, HEIGHT);
	  g.setColor(new Color(0, 0, 0));

	  // 用于存储随机生成的验证码
	  StringBuffer number = new StringBuffer();

	  // 绘制验证码
	  for (int i = 0; i < NUM; i++) {
	   g.setColor(randomColor(r));
	   int h = (int) ((HEIGHT * 60 / 100) * r.nextDouble() + (HEIGHT * 30 / 100));
	   g.setFont(new Font(null, Font.BOLD | Font.ITALIC, h));
	   String ch = String.valueOf(seq[r.nextInt(seq.length)]);
	   number.append(ch);
	   g.drawString(ch, i * WIDTH / NUM * 90 / 100, h);
	  }

	  //将验证码打印到控制台方便查看调试，但是当程序真正上线的时候一定要删掉哦
	  System.out.println(number.toString());
	  //将验证码放入到session中
//	  session.put("code", number.toString());

	  // 绘制干扰线，这里绘制12条，如果感觉太乱，可以减少点
	  for (int i = 0; i <= 12; i++) {
	   g.setColor(randomColor(r));
	   g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r
	     .nextInt(HEIGHT));

	  }

	  ByteArrayOutputStream os = new ByteArrayOutputStream();

	  JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

	  // 把BufferedImage对象中的图像信息编码后
	  // 向创建该对象(encoder)时指定的输出流输出
	  try {
	   encoder.encode(image);
	   return os.toByteArray();
	  } catch (Exception e) {
	   throw new RuntimeException(e);
	  }
	}
}
