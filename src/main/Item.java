package main;

import java.util.ArrayList;

public class Item extends Module {

    static ArrayList<Item> list = new ArrayList<>();

    String name;
    int count;
    int buyPrice = 0;
    int sellPrice = 1000000;
    String currency = "Gold";

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
        if (name.equals(currency)) return;
        if (buyPrice < 0) return;
        Unit owner = (Unit) this.owner.owner;
        if (tradingItem == null) for (Item item :
                list) {
            if (item != this && item.name.equals(name) && item.count > 0 && item.currency.equals(currency) && item.sellPrice <= buyPrice
            && owner.getItems().getItem(currency).count >= item.sellPrice) {
                tradingItem = item;
            }
        } else {
            if (tradingItem.count > 0 && tradingItem.currency.equals(currency) && tradingItem.sellPrice <= buyPrice
                    && owner.getItems().getItem(currency).count >= tradingItem.sellPrice) {
                tradingItem.giveTo(owner.getItems(),1);
                owner.getItems().getItem(currency).giveTo((Items) tradingItem.owner, tradingItem.sellPrice);
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
