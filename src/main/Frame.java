package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Frame extends JFrame implements MouseListener, MouseMotionListener, KeyListener {

    public  static Frame frame;
    static ArrayList<KeyListener> keyListeners = new ArrayList<>();
    static int mousePressed;
    static Point mouseXY = new Point();

    public Image image;
    public Graphics ig;

    public static void main(String[] args) {
        frame = new Frame();
        frame.setTitle("JFX");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,600);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Frame.frame.repaint();
            }
        },0,10);

        Unit unit1 = new Unit();
        unit1.getLocation().setXY(100,100);

        Unit unit2 = new Unit();
        unit2.getLocation().setXY(200,200);

        unit1.getLocation().target = unit2.getLocation();

        Unit u = (Unit) unit1.getLocation().owners.get(0);

        unit1.removeModule(unit1.getLocation());

        u.getLocation().target = new Location().setXY(500,500);

    }

    public Frame() throws HeadlessException {
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {

        if (ig == null) {
            image = createImage(getWidth(), getHeight());
            ig = image.getGraphics();
        }

        ig.clearRect(0,0, getWidth(), getHeight());
        Module.updateAll();

        g.drawImage(image,0,0,null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = e.getButton();
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseXY = e.getPoint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
