package main.place;

import main.Module;
import main.Unit;

import java.util.ArrayList;

/**
 * Created by Artem on 01.02.2020.
 */
public class Guests extends Module {

    //////////////////////////////

    ArrayList<Unit> units = new ArrayList<>();

    public Guests(Module owner) {
        super(owner);
    }

    public void add(Unit unit) {
        if (unit.location.place != null) unit.location.place.guests.units.remove(unit);
        unit.location.place = (Place) this.owner;
        this.units.add(unit);
    }

}
