package entity;

import base.Player;

public class HandballPlayer extends Player {

    private int goalsMade;
    private int goalsReceived;

    @Override
    public HandballPlayer setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    @Override
    public HandballPlayer setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @Override
    public HandballPlayer setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
        return this;
    }

    @Override
    public HandballPlayer setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    @Override
    public HandballPlayer setPosition(String position) {
        this.position = position;
        return this;
    }

    @Override
    public HandballPlayer setPlayerRating(Double playerRating) {
        this.playerRating = playerRating;
        return this;
    }

    public int getGoalsMade() {
        return goalsMade;
    }

    public HandballPlayer setGoalsMade(int goalsMade) {
        this.goalsMade = goalsMade;
        return this;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public HandballPlayer setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
        return this;
    }

    @Override
    public String toString() {
        return "HandballPlayer{" +
                "playerName='" + playerName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", playerNumber=" + playerNumber +
                ", teamName='" + teamName + '\'' +
                ", position='" + position + '\'' +
                ", goalsMade=" + goalsMade +
                ", goalsReceived=" + goalsReceived +
                ", playerRating=" + playerRating +
                '}';
    }
}
