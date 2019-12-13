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
        for (TradeOffer tradeOffer :
                list) {
            if (tradeOffer != this) {
                trade(tradeOffer);
            }
        }
    }

    int trade(TradeOffer tradeOffer) {
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
        buyOffer.getItems().getGold().giveTo(sellOffer.getItems(), count*price);
        sellOffer.item.giveTo(buyOffer.getItems(), count);

        buyOffer.count -= count;
        sellOffer.count -= count;

        return count;
    }


    Items getItems() {
        return (Items) this.item.getOwner();
    }

}
