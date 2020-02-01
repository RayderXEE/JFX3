package main.unit;

import main.Module;
import main.place.Place;
import main.Unit;

/**
 * Created by Artem on 01.02.2020.
 */
public class Location extends Module {

    //////////////////////////////

    public Place place;

    public Location(Module owner) {
        super(owner);
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        place.guests.add((Unit) this.owner);
    }
}
