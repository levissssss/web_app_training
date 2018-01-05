package Snake;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    private void startGame(String gameIdToStart, ServletContext context) {
        synchronized (context) {
            Games games = (Games) context.getAttribute("games");
            games.startGame(gameIdToStart);
        }
    }

    private void stopGame(String gameIdToStop, ServletContext context) {
        synchronized (context) {
            Games games = (Games) context.getAttribute("games");
            games.stopGame(gameIdToStop);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gameIdToStart = req.getParameter("gameIdToStart");
        String gameIdToStop = req.getParameter("gameIdToStop");

        if (gameIdToStart != null) {
            startGame(gameIdToStart, req.getServletContext());
        }
        if (gameIdToStop != null) {
            stopGame(gameIdToStop, req.getServletContext());
        }
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("SnakeGame/admin_landing.jsp").forward(req, resp);
    }
}
