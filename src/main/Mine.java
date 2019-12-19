package main;

import java.awt.*;
import java.util.ArrayList;

public class Mine extends Unit {

    static ArrayList<Mine> list = new ArrayList<>();

    public Mine() {
        super();
        list.add(this);
    }

    @Override
    public void firstUpdate() {
        super.firstUpdate();
        this.getLocation().color = Color.gray;
    }

    void mine(Unit unit) {
        if (!unit.getLocation().isTouching(this.getLocation())) {
            return;
        }
        unit.getItems().getGold().changeCount(1);
    }

}
