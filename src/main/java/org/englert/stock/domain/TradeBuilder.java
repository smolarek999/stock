package org.englert.stock.domain;

public class TradeBuilder {
    private int priceInPenny;
    private Stock stock;
    private long timestamp;
    private int quantity;

    public TradeBuilder setPriceInPenny(int priceInPenny) {
        this.priceInPenny = priceInPenny;
        return this;
    }

    public TradeBuilder setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public TradeBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public TradeBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Trade createTrade() {
        return new Trade(priceInPenny, stock, timestamp, quantity);
    }
}