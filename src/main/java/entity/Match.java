package entity;

import base.Game;

public class Match {
    private Team firstTeam;
    private Team secondTeam;
    private Game game;

    public Match(Team firstTeam, Team secondTeam, Game game) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.game = game;
    }

    public Team getMatchWinnerTeam() {
        Team winnerTeam = game.getWinnerTeam(this.firstTeam, this.secondTeam);
        return winnerTeam;
    }

    public void setMatchWinnerTeam(Team winnerTeam) {
        if (winnerTeam.getTeamName().equalsIgnoreCase(this.firstTeam.getTeamName())) {
            this.setFirstTeam(winnerTeam);
        } else {
            this.setSecondTeam(winnerTeam);
        }
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
