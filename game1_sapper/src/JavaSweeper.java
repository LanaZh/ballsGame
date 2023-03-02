
import java.awt.*;
import javax.swing.*;

public class JavaSweeper extends JFrame {
    private  final int imageSize = 50;
    private  final int cols = 15;
    private  final int rows = 1;

    private JPanel panel = new JPanel();

    public static void main(String[] arg) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        initPanel();
        initFrame();
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sapper");
        setLocation(200,230);
        setVisible(true);
        setResizable(false);
        pack();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
           protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("bomb"), 0, 0, this);
                g.drawImage(getImage("num1"), imageSize, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension
                (cols*imageSize,
                rows*imageSize));
        add (panel);
    }

    private  Image getImage (String name) {
        ImageIcon icon = new ImageIcon ("res/img/" + name +".png");
        return  icon.getImage();
    }
}
