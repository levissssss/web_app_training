<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Snake player</title>
</head>
<body>

<h2>Welcome ${username}!</h2>
<br>
<h1>ONGOING GAMES:</h1>
<c:forEach var="game" items="${games.ongoingGames}">
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

    <form method="post" action="/player" id="record">
        <input value="${username}" name="playerName" type="hidden">
        <input placeholder="Score" name="score" type="number">
        <input name="gameId" type="hidden" value="${game.key}">
        <input value="Add score" type="submit">
    </form>
    <br>
</c:forEach>

<h1>PAST GAMES</h1>
<c:forEach var="game" items="${games.pastGames}">
    <b> ${game.key}</b>
    <c:forEach var="record" items="${game.value.records}">
        <br>
        <tr>
            <td>${record.player}</td>
            <td>${record.score}</td>
        </tr>
    </c:forEach>
    <br>
</c:forEach>

</body>
</html>