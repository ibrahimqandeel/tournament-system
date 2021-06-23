package base;

import entity.Team;

public interface Game {
    Team getWinnerTeam(Team firstTeam, Team secondTeam);

    Double getPlayerRate(Player player);
}
