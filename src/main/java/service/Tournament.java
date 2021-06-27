package service;

import base.Player;
import entity.Match;
import entity.Team;
import factory.MatchFactory;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private List<Match> matchesList;

    public Tournament(List<String> inputSourceList) throws Exception {
        List<String[]> matchesRecordsList = extractMatchesRecords(inputSourceList);
        matchesList = MatchFactory.createMatchesList(matchesRecordsList);
    }

    public List<Player> rateMatchPlayers(Match match) throws Exception {
        Team winnerTeam = match.getMatchWinnerTeam();
        RewardSystem.addBonusPointsToWinnerTeam(winnerTeam, 10);
        match.setMatchWinnerTeam(winnerTeam);

        return new ArrayList<>(RatingSystem.rateMatchPlayers(match));
    }

    public List<Player> getPlayersOverallRate(List<Match> matchesList) throws Exception {
        List<Player> playersList = new ArrayList<>();
        for (Match match : matchesList) {
            playersList.addAll(rateMatchPlayers(match));
        }
        return RatingSystem.getPlayersOverallRate(playersList);
    }

    public void printMostValuablePlayerInfo() throws Exception {
        List<Player> playersWithOverallRating = getPlayersOverallRate(matchesList);
        Player mvp = RatingSystem.getPlayerWithHighestOverallRating(playersWithOverallRating);
        System.out.println(mvp.getPlayerName() + " Is The Most Valuable Player In The Tournament. \n");
        System.out.println("Player Information:- ");
        System.out.println("Name: " + mvp.getPlayerName());
        System.out.println("Nickname: " + mvp.getNickname());
        System.out.println("Number: " + mvp.getPlayerNumber());
        System.out.println("Overall Rating: " + mvp.getPlayerRating());
    }

    private List<String[]> extractMatchesRecords(List<String> inputSourceList) {
        List<String[]> matchesRecordsList = new ArrayList<>();
        for (String inputSourceRecord : inputSourceList) {
            matchesRecordsList.add(inputSourceRecord.split("\\n"));
        }

        return matchesRecordsList;
    }

    public List<Match> getMatchesList() {
        return matchesList;
    }
}
