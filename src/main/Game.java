package main;

import main.place.PlaceBeverlyHills;
import main.place.PlaceSantaMonica;

public class Game extends Module {

    public Game() {
        super(null);
        Unit unit = new Unit(null);
        PlaceSantaMonica placeSantaMonica = new PlaceSantaMonica(null);
        PlaceBeverlyHills placeBeverlyHills = new PlaceBeverlyHills(null);
        unit.location.setPlace(placeSantaMonica);
        placeBeverlyHills.guests.add(unit);
        System.out.println(unit.location.place.getClass().getSimpleName());
    }

}
