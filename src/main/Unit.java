package main;

public class Unit extends Module {


    public Unit() {
        addModule(new Location());
        getLocation().setXY(100,100);
        getLocation().radius = 10;
        getLocation().visible = true;

        addModule(new Items());

        //System.out.println(getLocation().owner.getClassName());
    }

    Location getLocation() {
        return (Location) getModuleWithClassName("Location");
    }

    Items getItems() {
        return (Items) getModuleWithClassName("Items");
    }

}
