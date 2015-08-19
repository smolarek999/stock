package org.englert.stock.domain;

public class CommonStockBuilder {
    private String symbol;
    private int parValue;
    private int lastDividend;
    private int tickerValue;

    public CommonStockBuilder setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public CommonStockBuilder setParValue(int parValue) {
        this.parValue = parValue;
        return this;
    }

    public CommonStockBuilder setLastDividend(int lastDividend) {
        this.lastDividend = lastDividend;
        return this;
    }

    public CommonStockBuilder setTickerValue(int tickerValue) {
        this.tickerValue = tickerValue;
        return this;
    }

    public CommonStock createCommonStock() {
        return new CommonStock(symbol, parValue, lastDividend, tickerValue);
    }
}