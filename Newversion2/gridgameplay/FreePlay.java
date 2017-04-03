package gridgameplay;

public class FreePlay extends Gameplay {
    
    public FreePlay(int size) {
        boolean winner = false;
        winner = Play(size);
        if (winner == true) {
            addNewHighscore(1);
        }
    }
}