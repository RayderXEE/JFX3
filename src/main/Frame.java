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
        unit1.getItems().getGold().changeCount(500);
        unit1.getItems().getItem("Wood").changeCount(100).setBuyPrice(2);

        Unit unit2 = new Unit();
        unit2.getLocation().setXY(200,200);
        unit2.getItems().getGold().changeCount(500);
        unit2.getItems().getItem("Wood").changeCount(100).setSellPrice(2);

        //unit1.getItems().getGold().setCount(50);
        //unit2.getItems().getItem("Wood").setCount(20);

        Unit unit3 = new Unit();
        unit3.getLocation().setXY(150,100);
        //unit3.getItems().getGold().changeCount(500);
        //unit3.addModule(new OrderTest().setLocations(unit1.getLocation(), unit2.getLocation()));

        Mine mine1 = new Mine();
        mine1.getLocation().setXY(300, 200);
        mine1.getItems().getGold().changeCount(500);
        int mineGoldCount = mine1.getItems().getGold().count;

        Mine mine2 = new Mine();
        mine2.getLocation().setXY(400, 200);
        mine2.getItems().getGold().changeCount(500);

        ArrayList<Unit> mineList = new ArrayList<>();
        for (Mine mine :
                Mine.list) {
            Unit unit = (Unit) mine;
            mineList.add(unit);
        }

        ArrayList<Unit> unit1MineDistanceMap = unit1.getLocation().getDistanceMap(mineList);
        //unit1.getLocation().target = unit1MineDistanceMap.get(0).getLocation();

        System.out.println(mineGoldCount);

        ArrayList<String> list1 = new ArrayList<>();
        String zipRequest = "";
        String[] splZipRequest = zipRequest.split(";");
        System.out.println(splZipRequest[0]);
        //list1.le

        ArrayList<String> strings = new ArrayList<>();
        strings.clear();
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
