package entity;

import base.Player;
import base.Game;
import entity.HandballPlayer;
import entity.Team;

import java.util.HashMap;
import java.util.Map;

public class HandballGame implements Game {

    private static Map<String, int[]> gamePointsSystem = new HashMap<>();
    public static final int INITIAL_RATING_POINTS_INDEX = 0;
    public static final int GOALS_MADE_INDEX = 1;
    public static final int GOALS_RECEIVED_INDEX = 2;

    static {
        gamePointsSystem.put("G", new int[]{50, 5, -2});
        gamePointsSystem.put("F", new int[]{20, 1, -1});
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
        HandballPlayer handballPlayer = (HandballPlayer) player;
        int[] pointsSystem = gamePointsSystem.get(player.getPosition());
        Double currentRating = handballPlayer.getPlayerRating();
        if (currentRating == null) {
            currentRating = 0.0;
        }
        currentRating += pointsSystem[INITIAL_RATING_POINTS_INDEX]
                + (handballPlayer.getGoalsMade() * pointsSystem[GOALS_MADE_INDEX])
                + (handballPlayer.getGoalsReceived() * pointsSystem[GOALS_RECEIVED_INDEX]);
        return currentRating;
    }

    private int calculateTeamTotalPoints(Team team) {
        int teamTotalPoints = 0;
        for (Player player : team.getPlayers()) {
            teamTotalPoints += ((HandballPlayer) player).getGoalsMade();
        }
        return teamTotalPoints;
    }
}
