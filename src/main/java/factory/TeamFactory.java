package factory;

import base.Player;
import entity.Team;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamFactory {

    public static List<Team> createMatchTeams(List<Player> players) {
        List<Team> matchTeams = new ArrayList<>();
        List<Player> firstTeamPlayers = new ArrayList<>();
        List<Player> secondTeamPlayers = new ArrayList<>();
        List<String> teamNames = getTeamsName(players);
        String firstTeamName = teamNames.get(0);
        String secondTeamName = teamNames.get(1);

        for (Player player : players) {
            if (firstTeamName.equalsIgnoreCase(player.getTeamName())) {
                firstTeamPlayers.add(player);
            } else {
                secondTeamPlayers.add(player);
            }
        }
        matchTeams.add(new Team(firstTeamName, firstTeamPlayers));
        matchTeams.add(new Team(secondTeamName, secondTeamPlayers));

        return matchTeams;
    }

    private static List<String> getTeamsName(List<Player> players) {
        Set<String> teamsNameSet = new HashSet<>();
        for (Player player : players) {
            if (teamsNameSet.size() == 2) {
                break;
            }
            teamsNameSet.add(player.getTeamName());
        }
        return new ArrayList<>(teamsNameSet);
    }
}
