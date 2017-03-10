/** Work in progress...!
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
}
