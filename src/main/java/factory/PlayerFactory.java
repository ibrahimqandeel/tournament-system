package factory;

import base.GameEnum;
import base.Player;
import entity.BasketballPlayer;
import entity.HandballPlayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PlayerFactory {

    public static List<Player> createMatchPlayers(String[] matchInfoList) throws Exception {
        HashSet<Player> playersSet = new HashSet<>();
        String sportName = matchInfoList[0];
        Player player = null;
        for (int i = 1; i < matchInfoList.length; i++) {
            if (sportName.equalsIgnoreCase(GameEnum.BASKETBALL.name())) {
                player = createBasketballPlayer(matchInfoList[i]);
            } else if (sportName.equalsIgnoreCase(GameEnum.HANDBALL.name())) {
                player = createHandballPlayer(matchInfoList[i]);
            }
            if (player != null && playersSet.contains(player)) {
                throw new Exception("Invalid Match Input. A Player (" + player.getNickname() + ") Can not Be Presented More Than One Time In The Same Match");
            }
            playersSet.add(player);
        }
        return new ArrayList<>(playersSet);
    }

    private static BasketballPlayer createBasketballPlayer(String playerInfo) throws Exception {
//        player name;nickname;number;team name;position;scored points;rebounds;assists
        String[] playerInfoArray = playerInfo.split(";");
        if (playerInfoArray.length < 8) {
            throw new Exception("Invalid Basketball Player Info.");
        }
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

    private static HandballPlayer createHandballPlayer(String playerInfo) throws Exception {
//        player name;nickname;number;team name;position;goals made;goals received
        String[] playerInfoArray = playerInfo.split(";");
        if (playerInfoArray.length < 7) {
            throw new Exception("Invalid Handball Player Info.");
        }
        HandballPlayer handballPlayer = new HandballPlayer();
        handballPlayer.setPlayerName(playerInfoArray[0])
                .setNickname(playerInfoArray[1])
                .setPlayerNumber(Integer.valueOf(playerInfoArray[2]))
                .setTeamName(playerInfoArray[3])
                .setPosition(playerInfoArray[4])
                .setGoalsMade(Integer.parseInt(playerInfoArray[5]))
                .setGoalsReceived(Integer.parseInt(playerInfoArray[6]));
        return handballPlayer;
    }
}