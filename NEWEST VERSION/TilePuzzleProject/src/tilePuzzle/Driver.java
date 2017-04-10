package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class Driver {

	public static void main(String[] args) {
		MainMenu game = new MainMenu("TILE PUZZLE");
		game.setSize(800,800);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.pack();
		game.setVisible(true);
	}
	public void MainMenu() {
		MainMenu getMenu = new MainMenu("TILE PUZZLE");
		getMenu.setSize(800,800);
		getMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMenu.setVisible(true);
	}
	public void LeaderboardMenu() {
		LeaderboardMenu getMenu = new LeaderboardMenu("LEADERBOARDS");
		getMenu.setSize(800,800);
		getMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMenu.pack();
		getMenu.setVisible(true);
	}
	public void PicturePlay() {
		PicturePlay getMode = new PicturePlay(3);
	}
	public void FreePlay() {
		FreePlay getMode = new FreePlay(3);
	}
}
