package assignment.exchange.domain.externalapi.service;

import assignment.exchange.domain.countryrate.domain.CurrencyRate;
import assignment.exchange.domain.externalapi.config.RestTemplateClient;
import assignment.exchange.domain.externalapi.dto.ExternalApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ExternalApiService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String API_URL = "http://api.currencylayer.com/live?access_key=6dddebe43e0280bc5fe1197eac07db48";

    private static String USDKRW = "USDKRW";
    private static String USDJPY = "USDJPY";
    private static String USDPHP = "USDPHP";

    /**
     * 환율 정보 조회
     */
    public ExternalApiResponse getRateInfo() {
        ExternalApiResponse response = new ExternalApiResponse();
        try {
            response = RestTemplateClient.restTemplate()
                    .getForObject(API_URL, ExternalApiResponse.class);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return response;
    }

    public Boolean currencyLayerCaching() {
        ExternalApiResponse rateExternalResponse = getRateInfo();
        if (rateExternalResponse.getSuccess()) {
            CurrencyRate.updateKrwExchange(rateExternalResponse.getQuotes().get(USDKRW));
            CurrencyRate.updateJpyExchange(rateExternalResponse.getQuotes().get(USDJPY));
            CurrencyRate.updatePhpExchange(rateExternalResponse.getQuotes().get(USDPHP));
        }
        return rateExternalResponse.getSuccess();
    }

}
