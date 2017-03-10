//timer runs for amount of seconds set
//numbers do not show countdown yet

import java.awt.*;
import java.util.Timer; //schedule thread to execute at certain time
import java.util.TimerTask; //runnable interface, extend to add own timer

public class TimerDemo {
  Toolkit toolkit;

  Timer timer;

  public TimerDemo(int seconds) {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new setTask(), seconds * 1000); //time in milliseconds
  }

  class setTask extends TimerTask {
    public void run() {
      System.out.println("Time's up!");
      toolkit.beep();//add sound when timers up
      System.exit(0);//exit when seconds reach 0
    }
  }

  public static void main(String args[]) {
    System.out.println("Starting easy mode...");
    new TimerDemo(5); //set amount of seconds to timer
    System.out.println("Start!");
  }
}  