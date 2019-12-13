package main;

import java.util.ArrayList;

public class Items extends Module {

    ArrayList<Item> itemList = new ArrayList<>();

    public Items() {
        itemList.add(new Item().setName("Gold"));
    }

    Item getItem(String name) {
        for (Item item :
                itemList) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

}
