package tilePuzzle;

import java.util.*;
import java.io.*;

public class HighscoreManager {
  // Array list of type score that will store the scores in
  private ArrayList<Score> moveScore;
  private ArrayList<Score> timerScore;
  private int fileState = 0;

  // Name of the files that the scores will be stored in, will create new files if they do not exist
  private static final String MOVESCORE_FILE = "moveScore.txt";
  private static final String TIMESCORE_FILE = "timeScore.txt";

  // For input and output of the text files
  ObjectOutputStream outputStream = null;
  ObjectInputStream inputStream = null;

  //Creates 2 new array lists, one for move leaderboard and one for timer leaderboard
  public HighscoreManager() {
      moveScore = new ArrayList<Score>();
      timerScore = new ArrayList<Score>();
  }

  /* This method calls the loadScoreFile() method which opens the text file and adds the new name
   * and score to the text file*/
  public void addScore(String name, int score, int state) {
      fileState = state;
	  loadScoreFile();
	  if(fileState == 1){
		  moveScore.add(new Score(name, score));
	  }
	  else if(fileState == 2){
		  timerScore.add(new Score(name, score));
	  }
	  updateScoreFile();
  }

  // Opens the correct file depending on the state
  public void loadScoreFile() {
      try {
    	  if(fileState == 1){
    		  inputStream = new ObjectInputStream(new FileInputStream(MOVESCORE_FILE));
    		  moveScore = (ArrayList<Score>) inputStream.readObject();
    		  }
    	  else if(fileState == 2){
    		  inputStream = new ObjectInputStream(new FileInputStream(TIMESCORE_FILE));
    		  timerScore = (ArrayList<Score>) inputStream.readObject();
          }

      } catch (FileNotFoundException e) {
          //System.out.println("[Laad] FNF Error: " + e.getMessage());
      } catch (IOException e) {
          //System.out.println("[Laad] IO Error: " + e.getMessage());
      } catch (ClassNotFoundException e) {
          //System.out.println("[Laad] CNF Error: " + e.getMessage());
      } finally {
          try {
              if (outputStream != null) {
                  outputStream.flush();
                  outputStream.close();
              }
          } catch (IOException e) {
              //System.out.println("[Laad] IO Error: " + e.getMessage());
          }
      }
  }

  // This method will take the opened text file and write the new name and score to that file
  public void updateScoreFile() {
    try {
    	if(fileState == 1){
    		outputStream = new ObjectOutputStream(new FileOutputStream(MOVESCORE_FILE));
    		outputStream.writeObject(moveScore);
    		}
    	else if(fileState == 2){
    		outputStream = new ObjectOutputStream(new FileOutputStream(TIMESCORE_FILE));
    		outputStream.writeObject(timerScore);
        }

    } catch (FileNotFoundException e) {
        System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
    } catch (IOException e) {
        System.out.println("[Update] IO Error: " + e.getMessage());
    } finally {
        try {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException e) {
            System.out.println("[Update] Error: " + e.getMessage());
        }
    }
  }

  /* Method that will call the loadScoreFile() and sort() methods, depending on the fileState the correct
   * leaderboard will be returned */
  public ArrayList<Score> getScores(int state) {
	  fileState = state;
	  ArrayList<Score> score = null;
      loadScoreFile();
      sort();
      if(fileState == 1){
    	  score = moveScore;
      }
      else if(fileState == 2){
    	  score = timerScore;
      }
      return score;
  }

  /* This method will create a new instance of the ScoreComparator class which will compare the current score and
   * the previous highest score in the array */
  private void sort() {
      ScoreComparator comparator = new ScoreComparator();
      if(fileState == 1){
    	  Collections.sort(moveScore, comparator);
      }
      else if(fileState == 2){
    	  Collections.sort(timerScore, comparator);
      }
  }

  /* readHighscore() method is called whenever the leaderboard needs to be displayed. The state (1 or 2) will
   * be passed through depending on what leaderboard needs to be displayed. The loadScoreFile() method is
   * called after the state is specified and will then print out each score*/
  public String readHighscore(int state){
	 String highscoreString = "";
	 ArrayList<Score> scores;
	 int i = 0;
	 fileState = state;

	 if(fileState == 1){
		scores = getScores(1);
		int x = scores.size();
		loadScoreFile();
		System.out.println("Move Score leaderboard:");
		System.out.println("#\tName:\t\tScore:");
		while (i < x) {
			highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
		    i++;
		}
	 }
	 else if(fileState == 2){
		scores = getScores(2);
		int x = scores.size();
		loadScoreFile();
		System.out.println("Timer Score Leaderboard");
		System.out.println("#\tName:\t\tScore:");
		while (i < x) {
			highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
			i++;
		}
	 }
	return highscoreString;
  }
}