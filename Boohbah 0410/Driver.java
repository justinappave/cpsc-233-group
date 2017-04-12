import java.awt.*;
import javax.swing.*;

/*
names...
explain what class does...
parameters, returns
*/

public class Driver {

  //Initialize mainmenu and leaderboardmenu to static
  static MainMenu MMenu = new MainMenu();
  static LeaderboardMenu LMenu = new LeaderboardMenu();

  //Main method (runs game and displays main menu)
  public static void main(String[] args) {
    MMenu.setVisible(true);
  }
  //Main menu frame
  public void MainMenu() {
    MMenu.setVisible(true);
    LMenu.setVisible(false);
  }
  //Leaderboard menu frame
  public void LeaderboardMenu() {
    MMenu.setVisible(false);
    LMenu.setVisible(true);
  }
  //PicturePlay frame
  public void PicturePlay() {
    PicturePlay getMode = new PicturePlay(3);
    MMenu.setVisible(false);
  }
  //Freeplay frame
  public void FreePlay() {
    FreePlay getMode = new FreePlay(3);
    MMenu.setVisible(false);
  }
  //TimePlay frame
  public void TimePlay() {
    TimePlay time = new TimePlay(3);
    MMenu.setVisible(false);
  }
}
