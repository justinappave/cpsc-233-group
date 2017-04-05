import java.util.ArrayList;

public class HighScoresTest {
    public static void main(String[] args) {
        HighScores hs = new HighScores();
        hs.resetFiles();
        hs.writeFile("Scott", 15, 0);
        //hs.writeFile(String NAME, int SCORE, int STATE);
    }
}