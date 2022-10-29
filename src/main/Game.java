package main;

public class Game extends Module {

    public Game() {

    }

    @Override
    void update() {
        super.update();
        Frame.frame.ig.drawOval(100,100,20,20);
    }
}
