package tilePuzzle;

public class HighscoreManagerTest{
	public void HighscoreManagerTest() {
	  HighscoreManager hm = new HighscoreManager();
	  //1 for moveScore | 2 for timerScore
	  hm.addScore("travis", 100, 2);
	  System.out.print(hm.readHighscore(2));
	}
}