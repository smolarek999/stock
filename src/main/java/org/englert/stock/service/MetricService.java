package org.englert.stock.service;

import org.englert.stock.dao.InMemoryStockRepository;
import org.englert.stock.domain.Stock;
import org.englert.stock.domain.Trade;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 */
public class MetricService {

    private static int FIFTEEN_MINUTES = 15 * 60 * 1000;

    TradeService tradeService;

    InMemoryStockRepository inMemoryStockRepository;

    public double calculatePriceEarningRatio(Stock stock) {
        return stock.getTickerPrice() / stock.getLastDivident();
    }

    public Optional<Long> calculateStockPrice(Stock stock) {
        long fifteenMinutesAgo = System.currentTimeMillis() - FIFTEEN_MINUTES;
        final List<Trade> tradesInCalculations = tradeService.getTrades().stream().filter(t -> t.getStock().equals(stock)).filter(t -> t.getTimestamp() >= fifteenMinutesAgo).collect(Collectors.toList());
        if (tradesInCalculations.isEmpty()) {
            return Optional.empty();
        }

        long numerator = 0L, denominator = 0L;


        for (Trade trade : tradesInCalculations) {
            numerator += trade.getPriceInPenny() * trade.getQuantity();
            denominator += trade.getQuantity();
        }
        return Optional.of(numerator / denominator);
    }


    public double calculateAllSharesIndex() {

        final Collection<Stock> allStocks = inMemoryStockRepository.getAll();
        long fractionalResult = allStocks.stream().map(s -> calculateStockPrice(s).orElse(0L)).reduce(1L, (price1, price2) -> price1 * price2);
        //FIXME: what about case when one of the stock has no recorded trades hence price will zeroed
        if(fractionalResult > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Current implementation is unable to perform calculation on such big numbers. To do so, there is need to write custom pow function");
        }else{
            return Math.pow(fractionalResult, 1.0 / allStocks.size());
        }



    }
}

