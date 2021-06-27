package base;

import entity.Team;

public interface Game {
    Team getWinnerTeam(Team firstTeam, Team secondTeam) throws Exception;

    Double getPlayerRate(Player player);
}
