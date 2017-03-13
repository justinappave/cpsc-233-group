package highscores;

public class Main{
	public static void main(String[] args) {
	  HighscoreManager hm = new HighscoreManager();
	  hm.addScore("Justin",1000);
	
	  System.out.print(hm.getHighscoreString());
	}
}
