package Snake;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("SnakeGame/player_landing.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("playerName");
        int score = Integer.parseInt(req.getParameter("score"));
        String gameId = req.getParameter("gameId");

        synchronized (req.getServletContext()) {
            Games games = (Games) req.getServletContext().getAttribute("games");
            games.addRecordToGame(gameId, playerName, score);
        }
        doGet(req, resp);
    }


}
