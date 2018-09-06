/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierleague.Models;

/**
 *
 * @author phalanndwas
 */
public class Match {
  private String roundName;
  private int teamScore;
  private int opponentScore;

  @Override
  public String toString() {
    return "Match{" + "roundName=" + roundName + ", teamScore=" + teamScore + ", opponentScore=" + opponentScore + '}';
  }

  public String getRoundName() {
    return roundName;
  }

  public void setRoundName(String roundName) {
    this.roundName = roundName;
  }

  public int getTeamScore() {
    return teamScore;
  }

  public void setTeamScore(int teamScore) {
    this.teamScore = teamScore;
  }

  public int getOpponentScore() {
    return opponentScore;
  }

  public void setOpponentScore(int opponentScore) {
    this.opponentScore = opponentScore;
  }
  
}
