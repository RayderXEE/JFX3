package main;

import main.unit.Location;

/**
 * Created by Artem on 01.02.2020.
 */
public class Unit extends Module {

    public Location location;

    public Unit(Module owner) {
        super(owner);
        location = new Location(this);
    }

}
