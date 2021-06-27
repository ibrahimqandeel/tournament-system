package entity;

import base.Game;
import base.Player;
import factory.PlayerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.Tournament;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketballGameTest {

    Game basketballGame = new BasketballGame();

    private static List<String> matchesInputSource = new ArrayList<>();
    private static List<Match> matchesList;
    private static Match match;
    private static Team firstTeam;
    private static Team secondTeam;

    @BeforeAll
    public static void buildMatchObject() {

        matchesInputSource.add("BASKETBALL\n" +
                "player 1;nick1;4;Team A;G;10;2;7\n" +
                "player 2;nick2;8;Team A;F;0;10;0\n" +
                "player 3;nick3;15;Team A;C;15;10;4\n" +
                "player 4;nick4;16;Team B;G;20;0;0\n" +
                "player 5;nick5;23;Team B;F;4;7;7\n" +
                "player 6;nick6;42;Team B;C;8;10;0");

        Tournament tournament = null;
        try {
            tournament = new Tournament(matchesInputSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert tournament != null;
        matchesList = tournament.getMatchesList();
        match = matchesList.get(0);
        firstTeam = match.getFirstTeam();
        secondTeam = match.getSecondTeam();
    }

    @Test
    void getWinnerTeam_test() throws Exception {
        Team winnerTeam = basketballGame.getWinnerTeam(firstTeam, secondTeam);
        assertEquals("Team B", winnerTeam.getTeamName());
    }

    @Test
    void getPlayerRate_test() {
    }
}