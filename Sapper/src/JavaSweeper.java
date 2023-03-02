import javax.swing.*;
import java.awt.*;

public class JavaSweeper  extends JFrame {

    JPanel panel;
    public static void main (String[] arg) {
        new JavaSweeper().setVisible(true);
    }

    public JavaSweeper () {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,300));
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         setTitle("Sapper");
         setLocation(null);
         setVisible(true);
         setResizable(false);
    }
}
