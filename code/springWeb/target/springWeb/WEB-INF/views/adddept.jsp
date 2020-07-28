<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/15
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="/dept">
    <label>deptno</label>
    <input type="number" name="deptno"/>
    <br/>
    <label>dname</label>
    <input type="text" name="dname"/>
    <br/>
    <label>loc</label>
    <input type="text" name="loc"/>
    <br/>
    <label>photo</label>
    <input type="file" name="photo">
    <br/>
    <input type="submit">
</form>

</body>
</html>
