import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private  final  int SIZE = 320;
    private  final  int DOT_SIZE = 16;
    private  final  int ALL_DOTS = 400;
    private Image dot;
    private  Image apple;
    private int appleX;
    private int appleY;
    private  int[] x = new int[ALL_DOTS];
    private  int[] y = new int[ALL_DOTS];
    private  int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    public  GameField(){
        setBackground(Color.BLACK);
        loadImage();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public  void initGame(){
        dots = 2;
        for(int i = 0; i<dots; i++){
            x[i] = 48 - i*DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(250,this);
        timer.start();
        creatApple();
    }

    public void creatApple(){
        appleX = new Random().nextInt(20)*DOT_SIZE;
        appleY = new Random().nextInt(20)*DOT_SIZE;
    }
    public  void  loadImage(){
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame){
            g.drawImage(apple,appleX,appleY,this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot,x[i],y[i],this);
            }
        }
    }

    public void move(){
        for (int i = dots; i < 0; i--) {
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        if (left){
            x[0] -= DOT_SIZE;
        }
        if (right){
            x[0] += DOT_SIZE;
        }
        if (up){
            y[0] -= DOT_SIZE;
        }
        if (down){
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple(){
        if (x[0]==appleX && y[0] == appleY);
        dots++;
        creatApple();
    }

    public void checkColliasian() {
        for (int i = dots; i < 0; i--) {
            if (i>4 && x[0]==x[1] && y[0] == y[i]){
                inGame = false;
            }
        }
        if (x[0]>SIZE){
            inGame = false;
        }
        if (x[0]<0){
            inGame = false;
        }
        if (y[0]>SIZE){
            inGame = false;
        }
        if (y[0]<0){
            inGame = false;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkColliasian();
          move();

        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && !right){
                left = true;
                up = false;
                down = false;
            }


            if (key == KeyEvent.VK_RIGHT && !left){
                right = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_UP && !down){
                right = false;
                up = true;
                left = false;
            }
            if (key == KeyEvent.VK_DOWN && !up){
                right = false;
                down = true;
                left = false;
            }
        }
    }
}
