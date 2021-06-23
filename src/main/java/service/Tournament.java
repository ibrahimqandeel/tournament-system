package service;

import base.Player;
import base.Game;
import entity.Match;
import entity.Team;
import factory.GameFactory;
import factory.PlayerFactory;
import factory.TeamFactory;
import validator.MatchValidator;
import validator.PlayerValidator;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    public List<String[]> extractMatchesRecords(List<String> inputSourceList) {
        List<String[]> matchesRecordsList = new ArrayList<>();
        for (String inputSourceRecord : inputSourceList) {
            matchesRecordsList.add(inputSourceRecord.split("\\n"));
        }

        return matchesRecordsList;
    }

    public void validateMatches(List<String[]> inputSourceList) throws Exception {
        boolean validMatchRecord;
        for (String[] matchRecord : inputSourceList) {
            validMatchRecord = MatchValidator.validateMatchRecord(matchRecord);
            if (!validMatchRecord) {
                throw new Exception("Invalid Match Record Format!");
            }
        }
    }

    public void validatePlayers(List<String[]> inputSourceList) throws Exception {
        boolean validPlayerRecord;
        for (String[] matchRecord : inputSourceList) {
            validPlayerRecord = PlayerValidator.validateMultiplePlayers(matchRecord);
            if (!validPlayerRecord) {
                throw new Exception("Invalid Player Record Format!");
            }
        }
    }

    public List<Player> ratePlayersForMatch(List<Match> matchesList) {
        List<Player> playersRateForEachMatch = new ArrayList<>();
        Team winnerTeam;
        for (Match match : matchesList) {
            winnerTeam = match.getMatchWinnerTeam();
            winnerTeam = RewardSystem.addBonusPointsToWinnerTeam(winnerTeam, 10);
            match.setMatchWinnerTeam(winnerTeam);
            playersRateForEachMatch.addAll(RatingSystem.rateMatchPlayers(match));
        }

        return playersRateForEachMatch;
    }

    public List<Player> getPlayersOverallRate(List<Player> playersWithOverallRating) {
        return RatingSystem.getPlayersOverallRate(playersWithOverallRating);
    }

    public List<Match> buildTournamentMatches(List<String[]> inputSourceList) {
        List<Match> matchesList = new ArrayList<>();
        List<Player> matchPlayers = null;
        Game game = null;
        String sportName = "";
        for (String[] matchInfo : inputSourceList) {
            sportName = matchInfo[0];

            //Create Match Players
            matchPlayers = createPlayersForMatch(matchInfo);

            //Create Game
            game = createMatchGameType(sportName);

            //Create Match Teams
            List<Team> matchTeams = createMatchTeams(matchPlayers);

            //Create Match
            matchesList.add(createMatch(matchTeams.get(0), matchTeams.get(1), game));
        }
        return matchesList;
    }

    public void printMostValuablePlayerInfo(List<Player> playersWithOverallRating) {
        Player mvp = RatingSystem.getPlayerWithHighestOverallRating(playersWithOverallRating);
        System.out.println(mvp.getPlayerName() + " Is The Most Valuable Player In The Tournament. \n");
        System.out.println("Player Information:- ");
        System.out.println("Name: " + mvp.getPlayerName());
        System.out.println("Nickname: " + mvp.getNickname());
        System.out.println("Number: " + mvp.getPlayerNumber());
        System.out.println("Overall Rating: " + mvp.getPlayerRating());
    }

    private List<Player> createPlayersForMatch(String[] matchInfo) {
        return PlayerFactory.createMatchPlayers(matchInfo);
    }

    private Game createMatchGameType(String sportName) {
        return GameFactory.createGame(sportName);
    }

    private List<Team> createMatchTeams(List<Player> matchPlayers) {
        return TeamFactory.createMatchTeams(matchPlayers);
    }

    private Match createMatch(Team firstTeam, Team secondTeam, Game game) {
        return new Match(firstTeam, secondTeam, game);
    }
}
