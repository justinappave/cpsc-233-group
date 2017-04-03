package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("quickplay")) {
            System.out.println("going to quickplay");
        }
        else if(e.getActionCommand().equals("mainmenu")) {
            System.out.println("going to mainmenu");
            MainMenuGUI mainMenu = new MainMenuGUI();
        }
        else if(e.getActionCommand().equals("quit")) {
            System.exit(0);
        }
        else if(e.getActionCommand().equals("freeplay")) {
            System.out.println("going to freeplay");
        }
        else if(e.getActionCommand().equals("timeplay")) {
            System.out.println("going to timeplay");
        }
        else if(e.getActionCommand().equals("leaderboards")) {
            System.out.println("going to leaderboards");
            LeaderboardMenu leaderboards = new LeaderboardMenu();
        }
        else if(e.getActionCommand().equals("backtomenu")) {
            System.out.println("backtomenu");
            MenuGUI start = new MenuGUI();
        }
        else if(e.getActionCommand().equals("backtomainmenu")) {
            System.out.println("backtomainmenu");
            MainMenuGUI mainMenu = new MainMenuGUI();
        }
    }
}