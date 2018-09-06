/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierleague;

import premierleague.Models.Ranking;
import premierleague.Models.Match;
import premierleague.Models.Team;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import premierleague.Controller.PremierLeagueController;

/**
 *
 * @author phalanndwas
 */
public class PremierLeague {

  /**
   * @param args the command line arguments
   */
  public static final String delimiter = ",";

  public static void main(String[] args) {

    ClassLoader loader = PremierLeague.class.getClassLoader();  
    String csvFile = new File("src/premierleague/input.csv").getAbsolutePath();
    PremierLeagueController controller = PremierLeagueController.getInstance();
    ArrayList<Team> teams = controller.read(csvFile);
    ArrayList<Ranking> teamRanking = controller.getTeamRanking(teams);
    controller.displayRankings(teamRanking);
  }
    

  
}
