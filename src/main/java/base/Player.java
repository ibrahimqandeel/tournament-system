package base;

import java.util.Objects;

public abstract class Player {

    protected String playerName;
    protected String nickname;
    protected Integer playerNumber;
    protected String teamName;
    protected String position;
    protected Double playerRating;

    public String getPlayerName() {
        return playerName;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getPosition() {
        return position;
    }

    public Double getPlayerRating() {
        return playerRating;
    }

    public abstract Player setPlayerName(String playerName);

    public abstract Player setNickname(String nickname);

    public abstract Player setPlayerNumber(Integer playerNumber);

    public abstract Player setTeamName(String teamName);

    public abstract Player setPosition(String position);

    public abstract Player setPlayerRating(Double playerRating);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return nickname.equals(player.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
