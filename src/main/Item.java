package main;

import java.util.ArrayList;

public class Item extends Module {

    static ArrayList<Item> list = new ArrayList<>();

    String name;
    int count;
    int price = 1000000;

    public Item() {
        super();
        list.add(this);
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setCount(int count) {
        this.count = count;
        return this;
    }

    public Item setPrice(int value) {
        this.price = value;
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
