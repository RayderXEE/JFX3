package main;

public class Trader extends Module {

    Item tradingItem;

    @Override
    public void update() {
        super.update();
        Unit owner = (Unit) this.owner;
        if (tradingItem == null) for (Item item :
                Item.list) {
            if (item.name.equals("Wood") && item.owner.owner != this.owner && item.price <= 2
            && owner.getItems().getGold().count >= item.price) {
                tradingItem = item;
            }
        } else {
            if (tradingItem.price <= 2 && owner.getItems().getGold().count >= tradingItem.price) {
                tradingItem.giveTo(owner.getItems(),1);
                owner.getItems().getGold().giveTo((Items) tradingItem.owner, tradingItem.price);
            } else {
                tradingItem = null;
            }
        }
    }
}
