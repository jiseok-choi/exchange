package assignment.exchange.domain.externalapi.service;

import assignment.exchange.domain.externalapi.dto.ExternalApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalApiServiceTest {

    @Test
    @DisplayName("api 호출 테스트")
    public void apiTest() {
        ExternalApiService service = new ExternalApiService();
        ExternalApiResponse response = service.getRateInfo();
        Assertions.assertEquals(response.getSuccess(), true);
    }

}
