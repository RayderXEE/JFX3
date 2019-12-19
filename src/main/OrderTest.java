package main;

public class OrderTest extends Order {

    Location location1;
    Location location2;

    @Override
    public void update() {
        super.update();

        Unit owner = (Unit) this.owner;
        Unit unit1 = (Unit) location1.owner;
        Unit unit2 = (Unit) location2.owner;
        if (owner.getLocation().isTouching(location1)) {
            unit1.getItems().getGold().giveTo(owner.getItems(), 1);
            if (owner.getItems().getGold().count == 100 || unit1.getItems().getGold().count == 0) {
                owner.getLocation().target = location2;
            }

        }
        if (owner.getLocation().isTouching(location2)) {
            owner.getItems().getGold().giveTo(unit2.getItems(), 1);
            if (owner.getItems().getGold().count == 0) {
                owner.getLocation().target = location1;
            }
        }
        System.out.println(owner.getItems().getGold().count);
    }

    @Override
    public void firstUpdate() {
        super.firstUpdate();
        Mine mine = null;
        Unit owner = (Unit) this.owner;
        owner.getLocation().target = location1;
    }

    public OrderTest setLocations(Location location1, Location location2) {
        this.location1 = location1;
        this.location2 = location2;
        return this;
    }

}
