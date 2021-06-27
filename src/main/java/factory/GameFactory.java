package factory;

import base.Game;
import base.GameEnum;
import entity.BasketballGame;
import entity.HandballGame;

import java.util.HashMap;

public class GameFactory {
    private static HashMap<String, Game> gamesMap = new HashMap<>();

    static {
        gamesMap.put("BASKETBALL", new BasketballGame());
        gamesMap.put("HANDBALL", new HandballGame());
    }

    public static Game createGame(String sportName) throws Exception {
        Game game = gamesMap.get(sportName.toUpperCase());
        if (game == null) {
            throw new Exception(sportName + " is not a valid sport");
        }

        return game;
    }
}
