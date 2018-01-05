<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Snake admin</title>
</head>
<body>
    <form method="post" action="/admin">
        <input placeholder="Enter game id" name="gameIdToStart" type="text">
        <input value="START" type="submit">
    </form>

    <form method="post" action="/admin">
        <input placeholder="Enter game id" name="gameIdToStop" type="text">
        <input value="STOP" type="submit">
    </form>

    <c:forEach var="game" items="${ongoingGames}">
        <tr>
            <td>${game}.player</td>
            <td>${game}.score</td>
        </tr>
    </c:forEach>
</body>
</html>
