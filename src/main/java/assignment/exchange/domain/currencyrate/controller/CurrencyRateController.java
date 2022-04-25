package assignment.exchange.domain.currencyrate.controller;

import assignment.exchange.domain.currencyrate.dto.CurrencyRateResponse;
import assignment.exchange.domain.currencyrate.service.CurrencyRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyRateController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CurrencyRateService service;

    @GetMapping("/exchange/{country}")
    public CurrencyRateResponse exchange(@PathVariable String country) {
        logger.debug("request exchange rate country: " + country);
        return service.getCurrencyRateInfo(country);
    }

}
