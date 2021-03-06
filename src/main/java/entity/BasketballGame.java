package entity;

import base.Player;
import base.Game;
import entity.BasketballPlayer;
import entity.Team;

import java.util.HashMap;
import java.util.Map;

public class BasketballGame implements Game {

    public static final int SCORED_POINTS_INDEX = 0;
    public static final int REBOUND_INDEX = 1;
    public static final int ASSIST_INDEX = 2;

    private static Map<String, int[]> gamePointsSystem = new HashMap<>();

    static {
        gamePointsSystem.put("G", new int[]{2, 3, 1});
        gamePointsSystem.put("F", new int[]{2, 2, 2});
        gamePointsSystem.put("C", new int[]{2, 1, 3});
    }


    @Override
    public Team getWinnerTeam(Team firstTeam, Team secondTeam) throws Exception {
        int firstTeamPoints = calculateTeamTotalPoints(firstTeam);
        int secondTeamPoints = calculateTeamTotalPoints(secondTeam);
        if (firstTeamPoints > secondTeamPoints) {
            return firstTeam;
        } else if (secondTeamPoints > firstTeamPoints) {
            return secondTeam;
        } else {
            throw new Exception("Invalid Match Input. The Match dose not have a winner team.");
        }
    }

    @Override
    public Double getPlayerRate(Player player) {
        BasketballPlayer basketballPlayer = (BasketballPlayer) player;
        int[] pointsSystem = gamePointsSystem.get(player.getPosition());
        Double currentRating = basketballPlayer.getPlayerRating();
        if (currentRating == null) {
            currentRating = 0.0;
        }
        currentRating += basketballPlayer.getScoredPoints() * pointsSystem[SCORED_POINTS_INDEX]
                + basketballPlayer.getRebounds() * pointsSystem[REBOUND_INDEX]
                + basketballPlayer.getAssists() * pointsSystem[ASSIST_INDEX];
        return currentRating;
    }

    private int calculateTeamTotalPoints(Team team) {
        int teamTotalPoints = 0;
        for (Player player : team.getPlayers()) {
            teamTotalPoints += ((BasketballPlayer) player).getScoredPoints();
        }
        return teamTotalPoints;
    }
}
