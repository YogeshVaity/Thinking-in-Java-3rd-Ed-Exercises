/* Modify Progress.java so that it does not share models, but 
 * instead uses a listener to connect the slider and progress bar.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import com.bruceeckel.swing.*;

public class Progress extends JApplet {
  private JProgressBar pb = new JProgressBar();
  private JSlider sb =
    new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(2,1));
    sb.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        pb.setValue(sb.getValue());
      }
    });
    cp.add(pb);
    sb.setValue(0);
    sb.setPaintTicks(true);
    sb.setMajorTickSpacing(20);
    sb.setMinorTickSpacing(5);
    sb.setBorder(new TitledBorder("Slide Me"));
    
    //pb.setModel(sb.getModel()); // Share model
    cp.add(sb);
  }
  public static void main(String[] args) {
    Console.run(new Progress(), 300, 200);
  }
} ///:~
