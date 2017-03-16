import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimerFrame {
    private static JFrame frame = new JFrame();

    public static void main(String[] args) {
        TimerFrame timerFrame = new TimerFrame();
        timerFrame.frame.setVisible(true);
        timerFrame.frame.setSize(400,400);
        new Timer().schedule(new TimerTask(){

            int second = 10;
            @Override
            public void run() {
                frame.setTitle("Application will close in " + second-- + " seconds.");
                
                if(second == -2){
                	frame.dispose();
                }
            }
        },0, 1000);
    }
}