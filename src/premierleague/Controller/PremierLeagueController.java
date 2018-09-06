/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierleague.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import premierleague.Models.Match;
import premierleague.Models.Ranking;
import premierleague.Models.Team;
import static premierleague.PremierLeague.delimiter;

/**
 *
 * @author phalanndwas
 */
public class PremierLeagueController {

  public static ArrayList<Ranking> getTeamRanking(ArrayList<Team> teams) {

    ArrayList<Ranking> teamRanking = new ArrayList<>();
    for (Team team : teams) {
      String teamName = team.getName();
      ArrayList<Match> matches = team.getMatch();
      int GamesPlayed = matches.size();
      int gamesWon = 0;
      int gamesDrawn = 0;
      int gamesLost = 0;
      int goalsFor = 0;
      int goalsAgainst = 0;
      int goalDifference = 0;
      int points = 0;

      for (Match match : matches) {
        //Win
        if (match.getTeamScore() > match.getOpponentScore()) {
          gamesWon++;
          points += 3;
        }
        //Draw
        if (match.getTeamScore() == match.getOpponentScore()) {
          gamesDrawn++;
          points++;
        }
        //Lost
        if (match.getTeamScore() < match.getOpponentScore()) {
          gamesLost++;
        }
        goalsFor += match.getTeamScore();
        goalsAgainst += match.getOpponentScore();
      }
      goalDifference = goalsAgainst - goalsFor;

      Ranking Ranking = new Ranking();
      Ranking.setTeamName(teamName);
      Ranking.setGamesPlayed(GamesPlayed);
      Ranking.setGamesWon(gamesWon);
      Ranking.setGamesDrawn(gamesDrawn);
      Ranking.setGamesLost(gamesLost);
      Ranking.setGoalsFor(goalsFor);
      Ranking.setGoalsAgainst(goalsAgainst);
      Ranking.setPoints(points);
      Ranking.setGoalDifference(goalDifference);

      teamRanking.add(Ranking);

    }
    Collections.sort(teamRanking, Ranking.pointsComparator);

    return teamRanking;
  }

  public static void displayRankings(ArrayList<Ranking> teamRanking) {

    System.out.println("--------------------------------------------------------------------------------------------------------------");
    System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s %10s", "TEAM NAME", "PLAYED", "WON", "DRAWN", "LOST", "FOR", "AGAINST", "DIFFERENCE", "POINTS");
    System.out.println();
    System.out.println("--------------------------------------------------------------------------------------------------------------");
    for (Ranking rank : teamRanking) {
      System.out.format("%-10s %10s %10s %10s %10s %10s %10s %10s %10s",
              rank.getTeamName(), rank.getGamesPlayed(), rank.getGamesWon(), rank.getGamesDrawn(), rank.getGamesLost(), rank.getGoalsFor(), rank.getGoalsAgainst(), rank.getGoalDifference(), rank.getPoints());
      System.out.println();
    }
    System.out.println("--------------------------------------------------------------------------------------------------------------");
  }

  public static ArrayList<Team> read(String csvFile) {
    ArrayList<Team> teams = new ArrayList<>();

    try {
      File file = new File(csvFile);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);

      String line = "";

      String[] tempArr;
      int rowCount = 0;
      while ((line = br.readLine()) != null) {
        ArrayList<Match> temaMatches = new ArrayList<>();
        tempArr = line.split(delimiter);
        Team team = new Team();
        int roundCount = 1;
        if (rowCount > 0) {
          team.setName(tempArr[0]);

          for (String scores : tempArr) {
            if (!scores.contains("Team")) {
              Match match = new Match();
              String[] score = scores.split("-");

              int teamScore = Integer.parseInt(score[0].trim());
              int opponentScore = Integer.parseInt(score[1].trim());
              match.setRoundName("Round " + roundCount);
              match.setTeamScore(teamScore);
              match.setOpponentScore(opponentScore);
              roundCount++;
              temaMatches.add(match);

            }
          }

          team.setMatch(temaMatches);
        }
        teams.add(team);
        rowCount++;

      }
      br.close();
      //System.out.println(teams.toString());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    teams.remove(0);
    return teams;
  }

  public static PremierLeagueController getInstance() {
    return new PremierLeagueController();
  }
}
