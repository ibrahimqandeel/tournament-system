package factory;

import base.Game;
import base.Player;
import entity.Match;
import entity.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchFactory {

    public static List<Match> createMatchesList(List<String[]> matchesRecordsList) throws Exception {
        List<Match> matchesList = new ArrayList<>();
        List<Player> matchPlayers;
        Game game;
        String sportName;
        for (String[] matchInfo : matchesRecordsList) {
            sportName = matchInfo[0];

            //Create Game
            game = GameFactory.createGame(sportName);

            //Create Match Players
            matchPlayers = PlayerFactory.createMatchPlayers(matchInfo);

            //Create Match Teams
            List<Team> matchTeams = TeamFactory.createMatchTeams(matchPlayers);

            //Create Match
            matchesList.add(new Match(matchTeams.get(0), matchTeams.get(1), game));
        }
        return matchesList;
    }
}
