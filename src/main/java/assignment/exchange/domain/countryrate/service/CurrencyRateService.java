package assignment.exchange.domain.countryrate.service;

import assignment.exchange.domain.countryrate.domain.CountryName;
import assignment.exchange.domain.countryrate.domain.CurrencyRate;
import assignment.exchange.domain.countryrate.dto.ExchangeRateResponse;
import assignment.exchange.domain.countryrate.exception.ExchangeException;
import org.springframework.stereotype.Service;

@Service
public class CurrencyRateService {

    public ExchangeRateResponse getCurrencyRateInfo(String country) {

        ExchangeRateResponse response = new ExchangeRateResponse();
        response.setSuccess(true);

        try {
            CountryName.validate(country);
            response.setRate(CurrencyRate.getExchangeRate(country));
        } catch (ExchangeException e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
