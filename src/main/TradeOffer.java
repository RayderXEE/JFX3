package main;

import java.util.ArrayList;

public class TradeOffer extends Module{

    static ArrayList<TradeOffer> list = new ArrayList<>();

    Item item;
    int buyOrSell;
    int price;
    int count;

    public TradeOffer() {
        super();
        list.add(this);
    }

    @Override
    public void update() {
        super.update();
        if (count == 0) {
            list.remove(this);
            return;
        }
        Location l1 = (Location) this.getItems().owner.getModuleWithClassName("Location");

        for (TradeOffer tradeOffer :
                list) {
            Location l2 = (Location) tradeOffer.getItems().owner.getModuleWithClassName("Location");
            if (tradeOffer != this) {
                if (l1.isTouching(l2)) {
                    trade(tradeOffer);
                } else {

                }
            }
        }
    }

    int trade(TradeOffer tradeOffer) {
        return trade(tradeOffer, false);
    }

    int trade(TradeOffer tradeOffer, boolean checkMode) {
        TradeOffer buyOffer;
        TradeOffer sellOffer;
        if (buyOrSell == 0 && tradeOffer.buyOrSell == 1) {
            buyOffer = this;
            sellOffer = tradeOffer;
        } else {
            buyOffer = tradeOffer;
            sellOffer = this;
        }

        if (!buyOffer.item.name.equals(sellOffer.item.name)) return 0;
        if (buyOffer.price < sellOffer.price) return 0;

        int price = sellOffer.price;
        int count = Math.min(buyOffer.count, sellOffer.count);
        count = Math.min(count, buyOffer.getItems().getGold().count/price);
        count = Math.min(count, sellOffer.getItems().getItem(sellOffer.item.name).count);

        if (checkMode == true) return count;

        buyOffer.getItems().getGold().giveTo(sellOffer.getItems(), count*price);
        sellOffer.item.giveTo(buyOffer.getItems(), count);

        buyOffer.count -= count;
        sellOffer.count -= count;

        System.out.println("TradeOffer " + item.name + " " + price + " " + count);

        return count;
    }


    Items getItems() {
        return (Items) this.item.owner;
    }

    public TradeOffer setItem(Item item) {
        this.item = item;
        return this;
    }

    public TradeOffer setBuyOrSell(int buyOrSell) {
        this.buyOrSell = buyOrSell;
        return this;
    }

    public TradeOffer setPrice(int price) {
        this.price = price;
        return this;
    }

    public TradeOffer setCount(int count) {
        this.count = count;
        return this;
    }
}
