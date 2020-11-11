package com.cj.servlet;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1、定义BufferedImage的对象（宽:高=68:22）
        BufferedImage bufferedImage = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        //2、获取Graphics对象
        Graphics graphics = bufferedImage.getGraphics();
        //2.1 绘制方框
        Color color = new Color(200, 150, 255);
        graphics.setColor(color);
        graphics.fillRect(0,0,68,22);
        //3、使用Random随机生成验证码信息
        char[] strs = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789".toCharArray();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (int i = 0; i < 4; i++) {
            index = random.nextInt(strs.length);
            //4、使用Graphics绘制图片
            graphics.setColor(new Color(random.nextInt(88),
                                        random.nextInt(188),
                                        random.nextInt(255)));
            graphics.drawString(strs[index] + "",i * 15 + 5,14);
            sb.append(strs[index]);
        }
        //5、将验证码信息存储到Session中以便验证时使用
        request.getSession().setAttribute("checkCode",sb.toString());
        //6、将生成的图片输出（发送到前端）
        ImageIO.write(bufferedImage,"JPG",response.getOutputStream());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }
}
