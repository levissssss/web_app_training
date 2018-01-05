package Snake;

import java.util.HashMap;
import java.util.Map;

public class Games {
    private Map<String, Game> ongoingGames;
    private Map<String, Game> pastGames;

    public Games() {
        ongoingGames = new HashMap<>();
        pastGames = new HashMap<>();
    }

    public Map<String, Game> getOngoingGames() {
        return ongoingGames;
    }

    public void setOngoingGames(Map<String, Game> ongoingGames) {
        this.ongoingGames = ongoingGames;
    }

    public Map<String, Game> getPastGames() {
        return pastGames;
    }

    public void setPastGames(Map<String, Game> pastGames) {
        this.pastGames = pastGames;
    }

    public void startGame(String gameId) {
        Game newGame = new Game();
        ongoingGames.put(gameId, newGame);
    }

    public void stopGame(String gameId) {
        Game toRemove = ongoingGames.get(gameId);
        if (toRemove != null) {
            ongoingGames.remove(gameId);
            pastGames.put(gameId, toRemove);
        }
    }

    public void addRecordToGame(String gameId, String playerName, int score) {
        ongoingGames.get(gameId).addRecord(playerName, score);
    }
}
