package kr.or.ddit.basic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimpleGame implements ActionListener {
  
  private static final int WIDTH = 300;
  private static final int HEIGHT = 200;
  private static final int GAME_TIME = 10;
  
  private JFrame frame;
  private JPanel panel;
  private JButton button;
  private JLabel label;
  private Timer timer;
  private int remainingTime;
  private int clickCount;
  
  public SimpleGame() {
    frame = new JFrame("Click the Button");
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    
    panel = new JPanel();
    frame.add(panel, BorderLayout.CENTER);
    
    button = new JButton("Click me!");
    button.addActionListener(this);
    panel.add(button);
    
    label = new JLabel("Time: " + GAME_TIME);
    panel.add(label);
    
    timer = new Timer(1000, this);
    timer.start();
    
    remainingTime = GAME_TIME;
    clickCount = 0;
    
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
      clickCount++;
    } else if (e.getSource() == timer) {
      remainingTime--;
      label.setText("Time: " + remainingTime);
      if (remainingTime == 0) {
        gameOver();
      }
    }
  }
  
  public void gameOver() {
    button.setEnabled(false);
    timer.stop();
    label.setText("Game over! You clicked the button " + clickCount + " times.");
  }
  
  public static void main(String[] args) {
    new SimpleGame();
  }
}