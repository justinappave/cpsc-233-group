package swing;

//Template for changing button location on JFrame
//TODO: Implement button location into Menu

import javax.swing.*;
import java.awt.*;
public class ButtonLocationDemo extends JFrame{

 private JButton quickButton;
 public ButtonLocationDemo(){
      JPanel panel = new JPanel();
      quickButton = new JButton("QuickPlay");
      panel.setLayout(null);
      //button.setBounds(x,y,width,height);
      quickButton.setBounds(115,50,200,50);
      panel.add(quickButton);

      getContentPane().add(panel);
      //setLayout(null);
      //Frame Properties
      setDefaultCloseOperation(3);
      setSize(500,500);
      setVisible(true);

     }
   public static void main(String...args){
       new ButtonLocationDemo();
       }
}
