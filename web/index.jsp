<%--
  Created by IntelliJ IDEA.
  User: Wangcj
  Date: 2020/11/11
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>验证码</title>
  </head>
  <>
    验证码：
    <input type="text" name="checkCode"/>
    <img alt="验证码" src="<%request.getContextPath()%>"/>
  </body>
</html>
