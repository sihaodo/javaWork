<%--
  Created by IntelliJ IDEA.
  User: haodo
  Date: 2020/3/25
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>deptno</td>
        <td>dname</td>
        <td>loc</td>
    </tr>
    <tr>
        <td>${dept.deptno}</td>
        <td>${dept.dname}</td>
        <td>${dept.loc}</td>
    </tr>
</table>
</body>
</html>
