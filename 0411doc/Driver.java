import java.awt.*;
import javax.swing.*;

/*
This class acts as a base to run the program, after each time a new menu is requested
or the player finishes a game, its comes back here to decide what to do
*/

public class Driver {
    
     //Initialize mainmenu and leaderboardmenu to static
    static MainMenu MMenu = new MainMenu();
    static LeaderboardMenu LMenu = new LeaderboardMenu();

    //Main method (runs game and displays main menu)
	public static void main(String[] args) {
        	MMenu.setVisible(true);
	}
    
    //Main menu frame (shows the main menu)
	public void MainMenu() {
        	MMenu.setVisible(true);
        	LMenu.setVisible(false);
	}
    
    //Leaderboard menu frame (shows the leaderboard menu)
	public void LeaderboardMenu() {
        	MMenu.setVisible(false);
        	LMenu.setVisible(true);
	}
    
    //PicturePlay frame (starts picture gametype)
	public void PicturePlay() {
		PicturePlay getMode = new PicturePlay(3);
        	MMenu.setVisible(false);
	}
    
    //Freeplay frame (starts move count gametype)
	public void FreePlay() {
		FreePlay getMode = new FreePlay(3);
        	MMenu.setVisible(false);
	}
    
    //TimePlay frame (starts time count gametype)
    public void TimePlay() {
        TimePlay time = new TimePlay(3);
        MMenu.setVisible(false);
    }
}
