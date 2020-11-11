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
    <script type="text/javascript">
      function reload() {
        var time = new Date();//使url发生变化，刷新页面
        document.getElementById("img_code").src="<%=request.getContextPath()%>/image?time="+time;
      }
    </script>
  </head>
  <body>
    <div>
      验证码：
      <input type="text" name="checkCode"/>
      <img alt="验证码" id="img_code" src="<%=request.getContextPath()%>/image"/>
      <a href="javascript:reload()">看不清楚</a>
    </div>
<%--    <button>确认</button>--%>
<%--    <button>重置</button>--%>
  </body>
</html>
