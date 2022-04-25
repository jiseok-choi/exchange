package assignment.exchange.domain.currencyrate.service;

import assignment.exchange.domain.currencyrate.domain.CountryName;
import assignment.exchange.domain.currencyrate.domain.CurrencyRate;
import assignment.exchange.domain.currencyrate.dto.CurrencyRateResponse;
import assignment.exchange.domain.currencyrate.exception.ExchangeException;
import org.springframework.stereotype.Service;

@Service
public class CurrencyRateService {

    public CurrencyRateResponse getCurrencyRateInfo(String country) {

        CurrencyRateResponse response = new CurrencyRateResponse();
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
