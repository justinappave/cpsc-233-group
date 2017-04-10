import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScores {
    static int timeScoreEntries = 0;
    static int moveScoreEntries = 0;

    
    //Opens and reads the file, puts each line into a arrayList. The names are first, then the score
    //The first name corresponds to the first score etc.
    public ArrayList<String> readFile(int moveOrTime){
        FileReader fr;
        BufferedReader br;
        ArrayList<String> fileContents = new ArrayList();
        int counter = 0;

        try {
            String fileName;
            if (moveOrTime == 0) {
                fileName = "TimeScore.txt";
            }
            else {
                fileName = "MoveScore.txt";
            }
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null) {
                fileContents.add(line);
                counter++;
                line = br.readLine();
            }
            fr.close();
        }
        catch(FileNotFoundException fileException) {
            System.out.println("Could not find file.");
        }
        catch(IOException fileException) {
            System.out.println("Could not read from file.");
        }
        return fileContents;
    }

    
    //This method sorts the scores with the lowest score coming first. Also keeps the names
    //in with the correct scores
    public ArrayList sortScores(ArrayList<String> scores) {
        int amountScores = scores.size();
        ArrayList<Integer> justScores = new ArrayList<Integer>();
        ArrayList<String> justNames = new ArrayList<String>();
        for (int i = amountScores/2; i < amountScores; i++) {
            int tempScore = Integer.parseInt(scores.get(i));
            justScores.add(tempScore);
        }
        Collections.sort(justScores);
        for (int j = 0; j < amountScores/2; j++) {
            for (int k = amountScores/2; k < amountScores; k++) {
                if (justScores.get(j) == Integer.parseInt(scores.get(k))) {
                    justNames.add(scores.get(k-(amountScores/2)));
                }
            }
        }
        ArrayList sorted = new ArrayList();
        for (int m = 0; m < justNames.size(); m++) {
            sorted.add(justNames.get(m));
        }
        for (int n = 0; n < justScores.size(); n++) {
            sorted.add(justScores.get(n));
        }
        return sorted;
    }

    //This method will read what is already in the file, add the new highscore, sort it, then overwrite
    //the file with the new values.
    public void writeFile(String name, int score, int moveOrTime){
        PrintWriter pw;
        ArrayList<String> highscores = readFile(moveOrTime);
        int highscoreSize = highscores.size();
        highscores.add(highscoreSize/2, name);
        highscores.add("" + score);
        highscores = sortScores(highscores);
        try {
            String fileName;
            if (moveOrTime == 0) {
                fileName = "TimeScore.txt";
            }
            else {
                fileName = "MoveScore.txt";
            }
            Scanner keyboard = new Scanner(System.in); // Open file we are going to write to
            pw = new PrintWriter(new FileOutputStream(fileName, false));
            for (int i = 0; i < highscores.size(); i++) {
                Object line = highscores.get(i);
                pw.println(line);
            }
            pw.close();                            // Closes file once finished writing
        }
        catch(FileNotFoundException fileException) {
            System.out.println("Could not find file.");
        }
    }
    
    //This method will reset the highscores to the "default" values.
    public void resetFiles() {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("TimeScore.txt", false));
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
        try {
            pw = new PrintWriter(new FileOutputStream("MoveScore.txt", false));
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