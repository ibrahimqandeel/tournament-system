package entity;

import base.Player;

public class BasketballPlayer extends Player {

    private Integer scoredPoints;
    private Integer rebounds;
    private Integer assists;

    @Override
    public BasketballPlayer setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    @Override
    public BasketballPlayer setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @Override
    public BasketballPlayer setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
        return this;
    }

    @Override
    public BasketballPlayer setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    @Override
    public BasketballPlayer setPosition(String position) {
        this.position = position;
        return this;
    }

    @Override
    public BasketballPlayer setPlayerRating(Double playerRating) {
        this.playerRating = playerRating;
        return this;
    }

    public Integer getScoredPoints() {
        return scoredPoints;
    }

    public BasketballPlayer setScoredPoints(Integer scoredPoints) {
        this.scoredPoints = scoredPoints;
        return this;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public BasketballPlayer setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
        return this;
    }

    public Integer getAssists() {
        return assists;
    }

    public BasketballPlayer setAssists(Integer assists) {
        this.assists = assists;
        return this;
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "playerName='" + playerName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", playerNumber=" + playerNumber +
                ", teamName='" + teamName + '\'' +
                ", position='" + position + '\'' +
                ", scoredPoints=" + scoredPoints +
                ", rebounds=" + rebounds +
                ", assists=" + assists +
                ", playerRating=" + playerRating +
                '}';
    }
}
