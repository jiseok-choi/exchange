package assignment.exchange.domain.currencyrate.domain;

import assignment.exchange.domain.currencyrate.exception.ExchangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountryNameTest {

    @Test
    @DisplayName("비정상 나라 입력시 에러")
    public void notSupportedCountry() {
        Assertions.assertThatThrownBy(() -> CountryName.validate("notSupported"))
        .isInstanceOf(ExchangeException.class);
    }

}
