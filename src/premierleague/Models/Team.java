/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierleague.Models;

import java.util.ArrayList;

/**
 *
 * @author phalanndwas
 */
public class Team {
  private String name;
  private ArrayList<Match> match;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Match> getMatch() {
    return match;
  }

  @Override
  public String toString() {
    return "Team{" + "name=" + name + ", match=" + match + '}'+"\n";
  }

  public void setMatch(ArrayList<Match> matchRound) {
    this.match = matchRound;
  }
  
}
