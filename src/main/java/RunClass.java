import service.Tournament;

import java.util.ArrayList;
import java.util.List;

public class RunClass {


    public static void main(String[] args) {
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
                "player 4;nick4;16;Team B;G;10;25\n" +
                "player 5;nick5;23;Team B;F;10;25\n" +
                "player 6;nick6;42;Team B;F;10;25");


        try {
            Tournament tournament = new Tournament(matchesInputSource);

            tournament.printMostValuablePlayerInfo();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
//            ex.printStackTrace();
        }
    }
}
