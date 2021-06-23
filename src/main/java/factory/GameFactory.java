package factory;

import base.Game;
import base.GameEnum;
import service.BasketballGame;
import service.HandballGame;

public class GameFactory {

    public static Game createGame(String sportName) {
        Game game = null;
        if (sportName.equalsIgnoreCase(GameEnum.BASKETBALL.name())) {
            game = new BasketballGame();
        } else if (sportName.equalsIgnoreCase(GameEnum.HANDBALL.name())) {
            game = new HandballGame();
        }

        return game;
    }
}
