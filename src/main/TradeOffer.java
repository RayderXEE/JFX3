package main;

public class TradeOffer {

    Item item;
    int buyOrSell;
    int price;
    int count;

    int Trade(TradeOffer tradeOffer) {
        if (buyOrSell == 0) {
            return buyFrom(tradeOffer);
        }
        if (buyOrSell == 1) {
            return sellTo(tradeOffer);
        }
        return 0;
    }

    int getCountCanBuy() {
        return (getTraderItems().getGold().count >= getTotalPrice()) ? count : getTraderItems().getGold().count/price;
    }

    int getCountCanBuyFrom(TradeOffer tradeOffer) {
        return Math.min(getCountCanBuy(), tradeOffer.getCountCanSell());
    }

    int getCountCanSell() {
        return (item.count >= count) ? count : item.count;
    }

    int sellTo(TradeOffer tradeOffer) {
        int m = Math.min(getCountCanSell(), tradeOffer.getCountCanBuy());
        this.item.giveTo(tradeOffer.getTraderItems(), m);
        tradeOffer.getTraderItems().getGold().giveTo(this.getTraderItems(), m*price);
        return m;
    }

    int buyFrom(TradeOffer tradeOffer) {
        int m = Math.min(getCountCanBuy(), tradeOffer.getCountCanSell());
        tradeOffer.getTraderItems().getItem(this.item.name).giveTo(this.getTraderItems(), m);
        getTraderItems().getGold().giveTo(tradeOffer.getTraderItems(), m*price);
        return m;
    }

    Items getTraderItems() {
        return (Items) this.item.getOwner();
    }

    int getTotalPrice() {
        return count * price;
    }

    int minCount(TradeOffer tradeOffer) {
        return Math.min(count, tradeOffer.count);
    }

}
