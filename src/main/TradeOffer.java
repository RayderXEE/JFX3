package main;

public class TradeOffer {

    Item item;
    int buyOrSell;
    int price;
    int count;

    int Trade(TradeOffer tradeOffer) {
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

        return count;
    }


    Items getItems() {
        return (Items) this.item.getOwner();
    }

}
