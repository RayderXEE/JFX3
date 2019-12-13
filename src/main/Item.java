package main;

public class Item extends Module {

    String name;
    int count;

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setCount(int count) {
        this.count = count;
        return this;
    }

    int giveTo(Items items, int count) {
        int countCanTransfer = (count > this.count) ? this.count : count;
        this.count -= countCanTransfer;
        items.getItem(name).count += countCanTransfer;
        return countCanTransfer;
    }

}
