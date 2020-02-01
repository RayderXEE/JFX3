package main.place;

import main.Module;
import main.place.Guests;

/**
 * Created by Artem on 01.02.2020.
 */
public class Place extends Module {

    public Guests guests;

    public Place(Module owner) {
        super(owner);
        guests = new Guests(this);
    }

}
