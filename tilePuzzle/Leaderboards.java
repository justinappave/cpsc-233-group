package tilePuzzle;

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;

public class Leaderboards extends JFrame{
	public void Leaderboards(){
		JPanel panel = new JPanel(new FlowLayout());
		//panel.setLayout(null);
		
		//getContentPane().add(panel);
		
        // The name of the file to open.
        String fileName = "timeScore.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	System.out.println(line);
                //JLabel text = new JLabel(line);
                //add(text);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
	{
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Leaderboards");
		//panel.setBackground(Color.BLACK);
	}
}