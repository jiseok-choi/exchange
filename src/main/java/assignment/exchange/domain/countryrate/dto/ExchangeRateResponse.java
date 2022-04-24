package assignment.exchange.domain.countryrate.dto;

public class ExchangeRateResponse {

    private Boolean success;
    private Double rate;
    private String message;

    public ExchangeRateResponse() {
    }

    public ExchangeRateResponse(Boolean success, Double rate, String message) {
        this.success = success;
        this.rate = rate;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
