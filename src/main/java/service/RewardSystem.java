package service;

import entity.Team;

public class RewardSystem {

    public static Team addBonusPointsToWinnerTeam(Team winnerTeam, int bonusPoints) {
        for (int i = 0; i < winnerTeam.getPlayers().size(); i++) {
            winnerTeam.getPlayers().get(i).setPlayerRating(new Double(bonusPoints));
        }
        return winnerTeam;
    }
}
