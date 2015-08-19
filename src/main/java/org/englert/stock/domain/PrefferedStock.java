package org.englert.stock.domain;

/**
 */
public class PrefferedStock extends Stock {
    int fixedDividendPercentage;

    protected PrefferedStock(String symbol, int parValue, int lastDividend, int tickerPrice, int fixedDividendPercentage) {
        super(symbol, parValue, lastDividend,tickerPrice);
        this.fixedDividendPercentage = fixedDividendPercentage;
    }

    @Override
    double yieldDividend() {

        return (fixedDividendPercentage * parValue)/tickerValue;
    }

}
