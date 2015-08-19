package org.englert.stock.service;

import org.englert.stock.dao.InMemoryTradeRepository;
import org.englert.stock.domain.Stock;
import org.englert.stock.domain.Trade;
import org.englert.stock.domain.TradeBuilder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class TradeService {


    InMemoryTradeRepository repository;

    public void buy(Stock stock, int quantity, int priceInPenny) {
        registerTrade(stock, quantity, priceInPenny, Trade.Indicator.Buy);
    }

    public void sell(Stock stock, int quantity, int priceInPenny) {
        registerTrade(stock, quantity, priceInPenny, Trade.Indicator.Sell);
    }

    private void registerTrade(Stock stock, int quantity, int priceInPenny, Trade.Indicator indicator) {
        Trade trade = new TradeBuilder().setPriceInPenny(priceInPenny).setQuantity(quantity).setStock(stock).setTimestamp(System.currentTimeMillis()).createTrade();
        repository.add(trade);

    }

    public Collection<Trade> getTrades() {
        return repository.getAll();
    }
}
