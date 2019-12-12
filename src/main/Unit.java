package main;

public class Unit extends Module {

    Location location;

    public Unit() {

        location = (Location) addModule(new Location());
        location.setXY(100,100);
        location.radius = 10;
        location.visible = true;
    }



}
