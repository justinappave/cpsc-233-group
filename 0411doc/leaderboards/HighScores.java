package leaderboards;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScores {
    //Constructor which will set the fileName that will be read and written to
    public HighScores(int moveOrTime) {
        if (moveOrTime == 0) {
            setFileName("leaderboards/TimeScore.txt");
        }
        else {
            setFileName("leaderboards/MoveScore.txt");
        }
    }
    
    //Initialize fileName variable
    private String fileName;
    //Setter and getter methods for fileName
    public void setFileName(String newFileName) {
        fileName = newFileName;
    }
    public String getFileName() {
        return fileName;
    }

/*  This method reads the file, using buffered reader, either for the move leaderboard or the time 
leaderboard and returns the entries as an ArrayList<String>
*/
    public ArrayList<String> readFile(){
        //Initialize readers, list and counter for the lines in the file
        FileReader fr;
        BufferedReader br;
        ArrayList<String> fileContents = new ArrayList();
        int counter = 0;
        
        //try to open and read file and add each line to the ArrayList
        try {
            fr = new FileReader(getFileName());
            br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null) {
                fileContents.add(line);
                counter++;
                line = br.readLine();
            }
            //close file
            fr.close();
        }
        //catch exceptions
        catch(FileNotFoundException fileException) {
            System.out.println("Could not find file reading.");
        }
        catch(IOException fileException) {
            System.out.println("Could not read from file.");
        }
        return fileContents;
    }

    
    /**This method takes an ArrayList<String> parameter, it splits it into two parts, only names
    and only scores. It sorts the scores, putting lowest first, then sorts the names according to
    how it sorted the scores.*/
    public ArrayList sortScores(ArrayList<String> scores) {
        //Initialize list for only names and only scores, also variable for the amount of items in the list
        int amountScores = scores.size();
        ArrayList<Integer> justScores = new ArrayList<Integer>();
        ArrayList<String> justNames = new ArrayList<String>();
        
        //Put scores in list and sort using Collections.sort()
        for (int scoreItem = amountScores/2; scoreItem < amountScores; scoreItem++) {
            int tempScore = Integer.parseInt(scores.get(scoreItem));
            justScores.add(tempScore);
        }
        Collections.sort(justScores);
        
        //Put names in list according to where the corresponding score moved to if it was moved
        for (int name = 0; name < amountScores/2; name++) {
            for (int score = amountScores/2; score < amountScores; score++) {
                if (justScores.get(name) == Integer.parseInt(scores.get(score))) {
                    justNames.add(scores.get(score-(amountScores/2)));
                }
            }
        }
        
        //Add the sorted scores and names to a new list and return the list
        ArrayList sorted = new ArrayList();
        for (int nameItem = 0; nameItem < justNames.size(); nameItem++) {
            sorted.add(justNames.get(nameItem));
        }
        for (int scoreItem = 0; scoreItem < justScores.size(); scoreItem++) {
            sorted.add(justScores.get(scoreItem));
        }
        return sorted;
    }

    /**This method will read what is already in the file, add the new highscore, sort it, then overwrite
    the file with the new values.*/
    public void writeFile(String name, int score){
        //Intitialize file writer, list to add new score to, and int for the size of the list
        PrintWriter pw;
        ArrayList<String> highscores = readFile();
        int highscoreSize = highscores.size();
        
        //Add new name and score to list then sort the scores
        highscores.add(highscoreSize/2, name);
        highscores.add("" + score);
        highscores = sortScores(highscores);
        
        //Try to open file and overwrite contents with the new sorted highscores
        try {
            pw = new PrintWriter(new FileOutputStream(getFileName(), false));
            for (int item = 0; item < highscores.size(); item++) {
                Object line = highscores.get(item);
                pw.println(line);
            }
            //Close the file
            pw.close();
        }
        //Catch exception
        catch(FileNotFoundException fileException) {
            System.out.println("Could not find file while writing.");
        }
    }
    
    //This method will reset the highscores to the "default" values.
    public void resetFiles(int mode) {
        //Initialize writer
        PrintWriter pw;
        
        //Set default values for TimeScore
        if (mode == 0) {
        	try {
        		pw = new PrintWriter(new FileOutputStream("leaderboards/TimeScore.txt", false));
        		pw.println("Expert");
        		pw.println("Advanced");
        		pw.println("Average");
        		pw.println("Beginner");
        		pw.println("20");
        		pw.println("40");
        		pw.println("80");
            	pw.println("150");
            	pw.close();
        	}
        	catch(FileNotFoundException fileException) {
        		System.out.println("Could not find file.");
        	}
        }
        
        //Set default values for MoveScore
        else {
        	try {
                pw = new PrintWriter(new FileOutputStream("leaderboards/MoveScore.txt", false));
                pw.println("Expert");
                pw.println("Advanced");
                pw.println("Average");
                pw.println("Beginner");
                pw.println("20");
                pw.println("40");
                pw.println("80");
                pw.println("150");
                pw.close();
            }
            catch(FileNotFoundException fileException) {
                System.out.println("Could not find file.");
            }
        }
    }
}