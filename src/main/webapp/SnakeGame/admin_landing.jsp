<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Snake admin</title>
</head>
<body>
<h2>Welcome admin!</h2>
<br>
    <form method="post" action="/admin">
        <input placeholder="Enter game id" name="gameIdToStart" type="text">
        <input value="START" type="submit">
    </form>

    <form method="post" action="/admin">
        <input placeholder="Enter game id" name="gameIdToStop" type="text">
        <input value="STOP" type="submit">
    </form>

<h1>ONGOING GAMES:</h1>

<c:forEach var="game" items="${games.ongoingGames}">
    <b> ${game.key}</b>
    <table>
        <tr>
            <th>Player</th>
            <th>Score</th>
        </tr>
        <c:forEach var="record" items="${game.value.records}">
            <tr>
                <td>${record.player}</td>
                <td>${record.score}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
</c:forEach>


<h1>PAST GAMES</h1>
<c:forEach var="game" items="${games.pastGames}">
    <b> ${game.key}</b>
    <table>
        <tr>
            <th>Player</th>
            <th>Score</th>
        </tr>
        <c:forEach var="record" items="${game.value.records}">
            <br>
            <tr>
                <td>${record.player}</td>
                <td>${record.score}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    </c:forEach>

</body>
</html>
