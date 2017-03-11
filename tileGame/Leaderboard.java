/**Work in progress still
**/

import java.util.*;
import java.io.*;

public class Leaderboard{
    Scanner read;
    PrintWriter write;

    private String playerid;
    private int playerscore;

    int x = 0;
    ArrayList<String> n = new ArrayList<String>();
    ArrayList<Integer> s = new ArrayList<Integer>();
    ArrayList <Leaderboard>players = new ArrayList<Leaderboard>();

    public Leaderboard(String name, int score){
        playerid = name;
        playerscore = score;
    }
    public String getName(){
        return playerid;
    }

    public int getScore(){
        return playerscore;
    }

    public String toString (){
        return playerid+"\t "+playerscore;
    }
    
    public void loadScores() throws FileNotFoundException{
    	read = new Scanner(new FileReader("scores.txt"));
    	while(read.hasNext()){
    		n.add(read.next());
    		s.add(read.nextInt());
    	}
    }
    
    public void evaluateScores(){
    	int u;
    	n.add(playerid);
    	s.add(playerscore);
    	
    	for(u = 0; u < n.size(); ++u){
    		players.add(new Leaderboard(n.get(u), s.get(u)));
    	}
    }
    
    public void writeScores() throws FileNotFoundException{
    	write = new PrintWriter("scores.rtf");
    	for(int z = 0; z <n.size(); ++z){
    		write.print(n.get(z)+" ");
    		write.println(s.get(z));
    	}
    	write.close();
    }
    
    //Testing
    public static void main(String[] args){
    	Leaderboard player1 = new Leaderboard("Justin", 100);
    	
    }
}
