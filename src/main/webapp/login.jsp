<%--
  Created by IntelliJ IDEA.
  User: Levente_Lakatos
  Date: 2018. 01. 04.
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="POST" action="/login?req=${requestScope.req}">
    <div>
        <%String invalid = "Please log in";
            if (("true").equals(request.getSession().getAttribute("invalid"))){
                invalid = "Invalid login";
                }
        %>
        <h1><%=invalid%></h1>
        <input placeholder="Enter Username" name="uname" type="text">
        <input placeholder="Password" name="pw" type="text">
        <input type="submit">

    </div>

</form>
<form  method="POST" action="/register?req=${requestScope.req}">
    <h1>Register</h1>
    <input placeholder="Enter Username" name="uname" type="text">
    <input placeholder="Password" name="pw" type="text">
    <input type="submit">
</form>
</body>
</html>
