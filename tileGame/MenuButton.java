import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MenuButton extends JFrame
{
JButton jb,jb1,jb2;
JPopupMenu menu;
JMenuItem m1,m2,m3,m4;

    public MenuButton()
    {
        createAndShowGUI();
    }
    
    private void createAndShowGUI()
    {
        // Set frame properties
        setTitle("Tile Puzzle Game");
        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Create JButtons
        jb=new JButton("Quickplay");
        jb1=new JButton("Main Menu");
		jb2=new JButton("Quit");
        
        // Create a JPopupMenu
        menu=new JPopupMenu();
        
        // Create JMenuItems
        m1=new JMenuItem("Item 1");
        m2=new JMenuItem("Item 2");
        m3=new JMenuItem("Item 3");
        m4=new JMenuItem("Item 4");
        
        // Add JMenuItems to JPopupMenu
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.add(m4);
        
        // Create an ActionListener which
        // will be used by two buttons (in common)
        ActionListener a1=new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                // Call the showPopup method
                // This takes ActionEvent to get
                // the event source
                showPopup(ae);
            }
        };
        
        // Add ActionListener to JButtons
        jb.addActionListener(a1);
        jb1.addActionListener(a1);
		jb2.addActionListener(a1);
        
        // Add the JButtons
        add(jb);
        add(jb1);
		add(jb2);
        
        // Set some size and show
        setSize(600,200);
        setVisible(true);
    }
    
    
    // This method does it all!
    private void showPopup(ActionEvent ae)
    {
        // Get the event source
        Component b=(Component)ae.getSource();
        
        // Get the location of the point 'on the screen'
        Point p=b.getLocationOnScreen();
        
        // Show the JPopupMenu via program
        
        // Parameter desc
        // ----------------
        // this - represents current frame
        // 0,0 is the co ordinate where the popup
        // is shown
        menu.show(this,0,0);
        
        // Now set the location of the JPopupMenu
        // This location is relative to the screen
        menu.setLocation(p.x,p.y+b.getHeight());
    }
    
    public static void main(String args[])
    {
        new MenuButton();
    }
}