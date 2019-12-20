package main;

import java.util.ArrayList;

public class Item extends Module {

    static ArrayList<Item> list = new ArrayList<>();

    String name;
    int count;
    //int price = 1000000;
    int buyPrice = 0;
    int sellPrice = 1000000;

    Item tradingItem;

    public Item() {
        super();
        list.add(this);
    }

    @Override
    public void update() {
        super.update();

        trading();
    }

    void trading() {
        Unit owner = (Unit) this.owner.owner;
        if (buyPrice < 0) return;
        if (tradingItem == null) for (Item item :
                list) {
            if (!item.name.equals("Gold") && item != this && item.name.equals(name) && item.count > 0 && item.sellPrice <= buyPrice
            && owner.getItems().getGold().count >= item.sellPrice) {
                tradingItem = item;
            }
        } else {
            if (tradingItem.count > 0 && tradingItem.sellPrice <= buyPrice && owner.getItems().getGold().count >= tradingItem.sellPrice) {
                tradingItem.giveTo(owner.getItems(),1);
                owner.getItems().getGold().giveTo((Items) tradingItem.owner, tradingItem.sellPrice);
            } else {
                tradingItem = null;
            }
        }
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setCount(int count) {
        this.count = count;
        return this;
    }

    public Item setBuyPrice(int value) {
        this.buyPrice = value;
        return this;
    }

    public Item setSellPrice(int value) {
        this.sellPrice = value;
        return this;
    }

    public Item changeCount(int value) {
        this.count += value;
        return this;
    }

    int giveTo(Items items, int count) {
        int countCanTransfer = (count > this.count) ? this.count : count;
        this.count -= countCanTransfer;
        items.getItem(name).count += countCanTransfer;
        return countCanTransfer;
    }

}
