package testGame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TimerTutorial extends JFrame{
	
	JLabel promptLabel, timerLabel;
	int counter;
	JTextField tf;
	JButton button;
	Timer timer; 
	
	public TimerTutorial(){
		setLayout(new GridLayout(2,2,5,5));
		
		promptLabel = new JLabel ("enter seconds:", SwingConstants.CENTER);
		add(promptLabel);
		
		tf = new JTextField(5);
		add(tf);
		
		button = new JButton("start timing");
		add(button);
		
		timerLabel = new JLabel("waiting...", SwingConstants.CENTER);
		add(timerLabel);
		
		event e = new event();
		button.addActionListener(e);
		
		
	}
	
	public class event implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int count = (int)(Double.parseDouble(tf.getText()));
			timerLabel.setText("time left: " + count);
			
			TimeClass tc = new TimeClass(count);
			timer = new Timer(1000, tc);
			timer.start();
		}
	}
	
	public class TimeClass implements ActionListener{
		int counter;
		
		public TimeClass(int counter){
			this.counter = counter;
		}
		
		public void actionPerformed ( ActionEvent tc){
			counter--;	
			
			if(counter >=1){
				timerLabel.setText("time left: " + counter);
			} else {
				timer.stop();
				timerLabel.setText("done!");
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
	
	public static void main (String[] args){
		TimerTutorial gui = new TimerTutorial();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(200,100);
		gui.setTitle("timer program");
		gui.setVisible(true);
		
	}
		 
}