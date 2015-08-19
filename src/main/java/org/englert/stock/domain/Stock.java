package org.englert.stock.domain;


/**
 * There is an assumption that ticker price is a statically provided value
 */
public abstract class Stock {
    final String symbol;
    final int parValue;
    final int tickerValue;
    final int lastDividend;
    private int lastDivident;
    private int tickerPrice;


    protected Stock(String symbol, int parValue, int lastDividend,int tickerValue) {
        this.symbol = symbol;
        this.parValue = parValue;
        this.lastDividend = lastDividend;
        this.tickerValue = tickerValue;
    }

    abstract double yieldDividend();

    public int getLastDivident() {
        return lastDivident;
    }

    public int getTickerPrice() {
        return tickerPrice;
    }
}
