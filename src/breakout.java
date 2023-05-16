import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class breakout extends Canvas implements Runnable{
    private BufferStrategy bs   ;

    private boolean running = false;
    private Thread thread;

    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private int paddelX = 260;
    private int paddelY = 350;

    private int paddelVX = 0;

    private int bollX = 290;
    private int bollY = 340;

    private int bollVX = 0;

    private int bollVY = 0;

    private ArrayList<Integer> brickXs = new ArrayList<>();

    private ArrayList<Integer> brickYs = new ArrayList<>();

    public breakout() {
        brickXs.add(15);
        brickYs.add(30);
        brickXs.add(80);
        brickYs.add(30);
        brickXs.add(145);
        brickYs.add(30);
        brickXs.add(210);
        brickYs.add(30);
        brickXs.add(275);
        brickYs.add(30);
        brickXs.add(340);
        brickYs.add(30);
        brickXs.add(405);
        brickYs.add(30);
        brickXs.add(470);
        brickYs.add(30);
        brickXs.add(535);
        brickYs.add(30);
        setSize(600,400);
        JFrame frame = new JFrame();
        frame.add(this);
        frame.addKeyListener(new MyKeyListener());
        this.addMouseMotionListener(new MyMouseMotionListener());
        this.addMouseListener(new MyMouseListener());
        requestFocus();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void render() {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        // Rita ut den nya bilden
        draw(g);

        g.dispose();
        bs.show();
    }

    public void draw(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLUE);
        g.fillRect(paddelX, paddelY, 80, 10);
        g.setColor(Color.RED);
        g.fillOval(bollX,bollY,10,10);
        g.setColor(Color.green);
        for (int i = 0 ; i < brickXs.size() ; i++) {
            g.fillRect(brickXs.get(i), brickYs.get(i), 50, 20);
        }
        }

    private void update() {
        paddelX += paddelVX;
        bollX += bollVX;
        bollY += bollVY;
        if (bollX < 0 || bollX > WIDTH) {
            bollVX = -bollVX;
        }
        for (int i = 0; i < brickXs.size(); i++) {
            int bricktop = brickYs.get(i);
            int brickbottom = brickYs.get(i) + 20;
            int brickleft = brickXs.get(i);
            int brickright = brickXs.get(i) + 50;
            if (bollX + 10 >= brickleft && bollX <= brickright && bollY +10 >= bricktop && bollY <= brickbottom) {
                bollVY = -bollVY;
                brickYs.set(i, -100);

            }
        }



        if (bollY < 0 || bollY > HEIGHT) {
            bollVY = -bollVY;
        }
        if (bollY >= paddelY - 10 && bollY <= paddelY && bollX >= paddelX && bollX <= paddelX + 80) {
            int paddleCenterX = paddelX + 40;
            int distanceFromCenter = bollX - paddleCenterX;
            double angle = (double) distanceFromCenter / 40.0 * Math.PI / 2.5;
            bollVX = (int) (10 * Math.sin(angle));
            bollVY = (int) (-10 * Math.cos(angle));
        }
    }
        public static void main(String[] args){
            breakout minGrafik = new breakout();
            minGrafik.start();
        }

        public synchronized void start () {
            running = true;
            thread = new Thread(this);
            thread.start();
        }

        public synchronized void stop () {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void run () {
            double ns = 1000000000.0 / 25.0;
            double delta = 0;
            long lastTime = System.nanoTime();

            while (running) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;

                while (delta >= 1) {
                    // Uppdatera koordinaterna
                    update();
                    // Rita ut bilden med updaterad data
                    render();
                    delta--;
                }
            }
            stop();
        }


    public class MyMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (bollVX == 0 && bollVY == 0) {
                bollVX = -10;
                bollVY = -10;
            }

            if (e.getKeyChar() == 'd') {
                paddelVX = 10;


            }
            if (e.getKeyChar() == 'a') {
                paddelVX = -10;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddelVX = 0;
        }
    }
}
