package assignment.exchange.domain.countryrate.domain;

import assignment.exchange.domain.countryrate.exception.ExchangeException;

import java.util.concurrent.ConcurrentHashMap;

import static assignment.exchange.domain.countryrate.domain.CountryName.*;

public class CurrencyRate {

    private static final ConcurrentHashMap<String, Double> exchangeMap = new ConcurrentHashMap<>();

    public CurrencyRate() {
    }

    public static void updateKrwExchange(Double rate) {
        exchangeMap.put(KRW_KEY, rate);
    }

    public static void updateJpyExchange(Double rate) {
        exchangeMap.put(JPY_KEY, rate);
    }

    public static void updatePhpExchange(Double rate) {
        exchangeMap.put(PHP_KEY, rate);
    }

    public static Double getExchangeRate(String key) {
        Double exchange = exchangeMap.get(key);
        if (exchange == null) {
            throw new ExchangeException("Unable to get exchange rate information.");
        }
        return Math.round(exchange * 100) / 100.0;
    }
}
