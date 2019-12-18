package main;

public class OrderTest extends Order {

    Location location1;
    Location location2;

    @Override
    public void update() {
        super.update();

        Unit owner = (Unit) getOwner();
        if (owner.getLocation().isTouching(location1)) {
            owner.getLocation().target = location2;
        }
        if (owner.getLocation().isTouching(location2)) {
            owner.getLocation().target = location1;
        }
    }

    @Override
    public void firstUpdate() {
        super.firstUpdate();
        Unit owner = (Unit) getOwner();
        owner.getLocation().target = location1;
    }

    public OrderTest setLocations(Location location1, Location location2) {
        this.location1 = location1;
        this.location2 = location2;
        return this;
    }

}