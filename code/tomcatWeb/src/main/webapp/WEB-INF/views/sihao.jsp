<%@ page import="com.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: haodo
  Date: 2020/7/15
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=((User)request.getAttribute("user")).getName()%>
<%=((User)request.getAttribute("user")).getAge()%>

</body>
</html>
