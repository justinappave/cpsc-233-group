package gridgameplay;

public class TimePlay extends Gameplay {
    private long timeLimit;
    private long startTime;
    private long timeTaken;
    
    public TimePlay(int difficulty) {
        int size = 3;
        boolean winner = false;
        long amountTime;
        setStartTime(System.currentTimeMillis());
        if (difficulty == 1) {
            amountTime = getStartTime() + 300*1000;
            setTimeLimit(amountTime);
        }
        else if (difficulty == 2) {
            amountTime = getStartTime() + 120*1000;
            setTimeLimit(amountTime);
        }
        else {
            amountTime = getStartTime() + 60*1000;
            setTimeLimit(amountTime);
        }
        winner = Play(size);
        if (winner == true) {
            setTimeTaken();
            addNewHighscore(2);
        }
    }
    
    public void setTimeLimit(long time) {
        timeLimit = time;
    }
    
    public long getTimeLimit() {
        return timeLimit;
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public void setStartTime(long time) {
        startTime = time;
    }
    
    @Override
    public boolean checkTime() {
        long currentTime = System.currentTimeMillis();
        long timeTakenSec = 0;
        boolean haveTime = true;
        if ((currentTime > getTimeLimit())) {
            System.out.println("Out of time!");
            haveTime = false;
        }
        return haveTime;
    }
    
    @Override
    public void setTimeTaken() {
        long currentTime = System.currentTimeMillis();
        long startTime = getStartTime();
        timeTaken = currentTime - startTime;
    }
    
    @Override
    public int getTimeTaken() {
        int intTimeTaken = (int) timeTaken;
        return intTimeTaken;
    }
}