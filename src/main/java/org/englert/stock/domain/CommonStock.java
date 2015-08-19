package org.englert.stock.domain;

/**
 */
public class CommonStock extends Stock {
    protected CommonStock(String symbol, int parValue, int lastDividend, int tickerValue) {
        super(symbol, parValue, lastDividend, tickerValue);
    }


    @Override
    double yieldDividend() {
        return  lastDividend / tickerValue;
    }

}
