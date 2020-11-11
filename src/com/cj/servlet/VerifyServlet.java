package com.cj.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VerifyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("gbk");
        //1、读取Session中的验证码
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        System.out.println("Session中验证码："+checkCode);
        //2、获取前端传回的验证码
        String code = request.getParameter("checkCode");
        System.out.println("前端返回验证码："+code);
        //3、检测验证码，返回结果
        PrintWriter writer = response.getWriter();
//        response.setContentType("text/html;charset=UTF-8");
        if(code.equalsIgnoreCase(checkCode)){
            System.out.println("验证码输入正确!");
            writer.println("验证码输入正确!");
        }else{
            System.out.println("验证码输入错误!!!");
            writer.println("验证码输入错误!!!");
        }
        writer.flush();
        writer.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }
}
