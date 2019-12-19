package main;

import java.util.ArrayList;

public class Items extends Module {

    ArrayList<Item> itemList = new ArrayList<>();

    public Items() {
        itemList.add((Item) new Item().setName("Gold").setOwner(this));
        itemList.add((Item) new Item().setName("Wood").setOwner(this));
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

    Item getGold() {
        return getItem("Gold");
    }

}
