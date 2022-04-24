package assignment.exchange.domain.externalapi.service;

import assignment.exchange.domain.countryrate.domain.CurrencyRate;
import assignment.exchange.domain.externalapi.config.RestTemplateClient;
import assignment.exchange.domain.externalapi.dto.ExternalApiResponse;
import org.springframework.stereotype.Service;


@Service
public class ExternalApiService {

    public static final String API_URL = "http://www.apilayer.net/api/live?access_key=ee50cd7cc73c9b7a7bb3d9617cfb6b9c";

    private static String USDKRW = "USDKRW";
    private static String USDJPY = "USDJPY";
    private static String USDPHP = "USDPHP";

    /**
     * 환율 정보 조회
     */
    public ExternalApiResponse getRateInfo() {
        return RestTemplateClient.restTemplate()
                .getForObject(API_URL, ExternalApiResponse.class);
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
