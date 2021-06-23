import base.Player;
import entity.Match;
import service.Tournament;

import java.util.ArrayList;
import java.util.List;

public class RunClass {


    public static void main(String[] args) throws Exception {
        List<String> matchesInputSource = new ArrayList<>();
        matchesInputSource.add("BASKETBALL\n" +
                "player 1;nick1;4;Team A;G;10;2;7\n" +
                "player 2;nick2;8;Team A;F;0;10;0\n" +
                "player 3;nick3;15;Team A;C;15;10;4\n" +
                "player 4;nick4;16;Team B;G;20;0;0\n" +
                "player 5;nick5;23;Team B;F;4;7;7\n" +
                "player 6;nick6;42;Team B;C;8;10;0");

        matchesInputSource.add("HANDBALL\n" +
                "player 1;nick1;4;Team A;G;0;20\n" +
                "player 2;nick2;8;Team A;F;15;20\n" +
                "player 3;nick3;15;Team A;F;10;20\n" +
                "player 4;nick4;16;Team B;G;1;25\n" +
                "player 5;nick5;23;Team B;F;12;25\n" +
                "player 6;nick6;42;Team B;F;8;25");

        Tournament tournament = new Tournament();

        try {
            List<String[]> matchesRecordsList = tournament.extractMatchesRecords(matchesInputSource);

            tournament.validateMatches(matchesRecordsList);
            tournament.validatePlayers(matchesRecordsList);

            List<Match> matchesList = tournament.buildTournamentMatches(matchesRecordsList);
            List<Player> tournamentPlayers = tournament.ratePlayersForMatch(matchesList);
            List<Player> tournamentPlayersWithOverallRating = tournament.getPlayersOverallRate(tournamentPlayers);

            tournament.printMostValuablePlayerInfo(tournamentPlayersWithOverallRating);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
//            ex.printStackTrace();
        }
    }
}
