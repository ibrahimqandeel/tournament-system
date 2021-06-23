package service;

import base.Player;
import entity.Match;

import java.util.*;

public class RatingSystem {

    public static List<Player> rateMatchPlayers(Match match) {
        List<Player> matchPlayersList = new ArrayList<>();
        matchPlayersList.addAll(match.getFirstTeam().getPlayers());
        matchPlayersList.addAll(match.getSecondTeam().getPlayers());

        Double currentPlayerRating;
        for (int i = 0; i < matchPlayersList.size(); i++) {
            currentPlayerRating = match.getGame().getPlayerRate(matchPlayersList.get(i));
            matchPlayersList.get(i).setPlayerRating(currentPlayerRating);
        }

        return matchPlayersList;
    }

    public static List<Player> getPlayersOverallRate(List<Player> playersWithOverallRating) {
        HashMap<String, Player> playersRatingMap = new HashMap<>();
        Player player;

        for (Player playerFromList : playersWithOverallRating) {
            if (playersRatingMap.containsKey(playerFromList.getPlayerName())) {
                player = playersRatingMap.get(playerFromList.getPlayerName());
                player.setPlayerRating(player.getPlayerRating() + playerFromList.getPlayerRating());
            } else {
                playersRatingMap.put(playerFromList.getPlayerName(), playerFromList);
            }
        }

        // Getting Collection of values from HashMap
        Collection<Player> playersRatingMapValues = playersRatingMap.values();
        // Creating an ArrayList of values
        playersWithOverallRating = new ArrayList<>(playersRatingMapValues);
        return playersWithOverallRating;
    }

    public static Player getPlayerWithHighestOverallRating(List<Player> playersList) {
        Player mvp = playersList.stream().max(Comparator.comparing(player -> player.getPlayerRating())).get();
        return mvp;
    }
}
