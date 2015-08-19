package org.englert.stock.domain;

/**
 */
public class Trade {
    Stock stock;
    long timestamp;
    int quantity;
    int priceInPenny;

    public Trade(int priceInPenny, Stock stock, long timestamp, int quantity) {
        this.priceInPenny = priceInPenny;
        this.stock = stock;
        this.timestamp = timestamp;
        this.quantity = quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getPriceInPenny() {
        return priceInPenny;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Indicator{
        Buy,
        Sell;
    }
}
