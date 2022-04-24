package assignment.exchange.domain.countryrate.domain;

import assignment.exchange.domain.countryrate.exception.ExchangeException;

public class CountryName {

    public static final String KRW_KEY = "krw";
    public static final String JPY_KEY = "jpy";
    public static final String PHP_KEY = "php";

    public static void validate(String name) {
        if (!KRW_KEY.equals(name) && !JPY_KEY.equals(name) && !PHP_KEY.equals(name)) {
            throw new ExchangeException("This is not a supported country.");
        }
    }
}
