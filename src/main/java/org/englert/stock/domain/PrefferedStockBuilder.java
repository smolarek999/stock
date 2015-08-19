package org.englert.stock.domain;

public class PrefferedStockBuilder {
    private String symbol;
    private int parValue;
    private int lastDividend;
    private int tickerValue;
    private int fixedDividendPercentage;

    public PrefferedStockBuilder setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public PrefferedStockBuilder setParValue(int parValue) {
        this.parValue = parValue;
        return this;
    }

    public PrefferedStockBuilder setLastDividend(int lastDividend) {
        this.lastDividend = lastDividend;
        return this;
    }

    public PrefferedStockBuilder setTickerValue(int tickerValue) {
        this.tickerValue = tickerValue;
        return this;
    }

    public PrefferedStockBuilder setFixedDividendPercentage(int fixedDividendPercentage) {
        this.fixedDividendPercentage = fixedDividendPercentage;
        return this;
    }

    public PrefferedStock createPrefferedStock() {
        return new PrefferedStock(symbol, parValue, lastDividend,tickerValue,fixedDividendPercentage);
    }
}