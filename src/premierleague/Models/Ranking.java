/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierleague.Models;

import java.util.Comparator;

/**
 *
 * @author phalanndwas
 */
public class Ranking {
      private String teamName;
      private int GamesPlayed ;
      private int gamesWon = 0;
      private int gamesDrawn = 0;
      private int gamesLost = 0;
      private int goalsFor = 0;
      private int goalsAgainst = 0;
      private int goalDifference = 0;
      private int points = 0;

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public int getGamesPlayed() {
    return GamesPlayed;
  }

  public void setGamesPlayed(int GamesPlayed) {
    this.GamesPlayed = GamesPlayed;
  }

  public int getGamesWon() {
    return gamesWon;
  }

  public void setGamesWon(int gamesWon) {
    this.gamesWon = gamesWon;
  }

  public int getGamesDrawn() {
    return gamesDrawn;
  }

  public void setGamesDrawn(int gamesDrawn) {
    this.gamesDrawn = gamesDrawn;
  }

  public int getGamesLost() {
    return gamesLost;
  }

  public void setGamesLost(int gamesLost) {
    this.gamesLost = gamesLost;
  }

  public int getGoalsFor() {
    return goalsFor;
  }

  public void setGoalsFor(int goalsFor) {
    this.goalsFor = goalsFor;
  }

  public int getGoalsAgainst() {
    return goalsAgainst;
  }

  public void setGoalsAgainst(int goalsAgainst) {
    this.goalsAgainst = goalsAgainst;
  }

  public int getGoalDifference() {
    return goalDifference;
  }

  public void setGoalDifference(int goalDifference) {
    this.goalDifference = goalDifference;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  @Override
  public String toString() {
    return "Ranking{" + "teamName=" + teamName + ", GamesPlayed=" + GamesPlayed + ", gamesWon=" + gamesWon + ", gamesDrawn=" + gamesDrawn + ", gamesLost=" + gamesLost + ", goalsFor=" + goalsFor + ", goalsAgainst=" + goalsAgainst + ", goalDifference=" + goalDifference + ", points=" + points + '}'+"\n";
  }

    public static Comparator<Ranking> pointsComparator = new Comparator<Ranking>() {

    @Override
	public int compare(Ranking s1, Ranking s2) {

	   int points1 = s1.getPoints();
	   int points2 = s2.getPoints();
       
	   return points2 - points1;
   }};
      
      
}
