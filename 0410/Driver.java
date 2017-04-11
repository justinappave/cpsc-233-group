

import java.awt.*;
import javax.swing.*;

public class Driver {
    static MainMenu MMenu = new MainMenu();
    static LeaderboardMenu LMenu = new LeaderboardMenu();

	public static void main(String[] args) {
        MMenu.setVisible(true);
	}
	public void MainMenu() {
        MMenu.setVisible(true);
        LMenu.setVisible(false);
	}
	public void LeaderboardMenu() {
        MMenu.setVisible(false);
        LMenu.setVisible(true);
	}
	public void PicturePlay() {
		PicturePlay getMode = new PicturePlay(3);
        MMenu.setVisible(false);
	}
	public void FreePlay() {
		FreePlay getMode = new FreePlay(3);
        MMenu.setVisible(false);
	}
    public void TimePlay() {
        TimePlay time = new TimePlay(3);
        MMenu.setVisible(false);
    }
}
