package factory;

import base.GameEnum;
import base.Player;
import entity.BasketballPlayer;
import entity.HandballPlayer;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

    public static List<Player> createMatchPlayers(String[] matchInfoList) {
        List<Player> playersList = new ArrayList<>();
        String sportName = matchInfoList[0];
        for (int i = 1; i < matchInfoList.length; i++) {
            if (sportName.equalsIgnoreCase(GameEnum.BASKETBALL.name())) {
                playersList.add(createBasketballPlayer(matchInfoList[i]));
            } else if (sportName.equalsIgnoreCase(GameEnum.HANDBALL.name())) {
                playersList.add(createHandballPlayer(matchInfoList[i]));
            }
        }
        return playersList;
    }

    private static BasketballPlayer createBasketballPlayer(String playerInfo) {
//        player name;nickname;number;team name;position;scored points;rebounds;assists
        String[] playerInfoArray = playerInfo.split(";");
        BasketballPlayer basketballPlayer = new BasketballPlayer();
        basketballPlayer.setPlayerName(playerInfoArray[0])
                .setNickname(playerInfoArray[1])
                .setPlayerNumber(Integer.valueOf(playerInfoArray[2]))
                .setTeamName(playerInfoArray[3])
                .setPosition(playerInfoArray[4])
                .setScoredPoints(Integer.valueOf(playerInfoArray[5]))
                .setRebounds(Integer.valueOf(playerInfoArray[6]))
                .setAssists(Integer.valueOf(playerInfoArray[7]));
        return basketballPlayer;
    }

    private static HandballPlayer createHandballPlayer(String playerInfo) {
//        player name;nickname;number;team name;position;goals made;goals received
        String[] playerInfoArray = playerInfo.split(";");
        HandballPlayer handballPlayer = new HandballPlayer();
        handballPlayer.setPlayerName(playerInfoArray[0])
                .setNickname(playerInfoArray[1])
                .setPlayerNumber(Integer.valueOf(playerInfoArray[2]))
                .setTeamName(playerInfoArray[3])
                .setPosition(playerInfoArray[4])
                .setGoalsMade(Integer.valueOf(playerInfoArray[5]))
                .setGoalsReceived(Integer.valueOf(playerInfoArray[6]));
        return handballPlayer;
    }
}