package assignment.exchange.domain.externalapi.dto;

import java.util.Map;

public class ExternalApiResponse {

    private Boolean success;
    private String terms;
    private String privacy;
    private Long timestamp;
    private String source;
    private Map<String, Double> quotes;
    private Map<String, Object> error;

    public ExternalApiResponse() {
    }

    public ExternalApiResponse(Boolean success, String terms, String privacy, Long timestamp, String source, Map<String, Double> quotes, Map<String, Object> error) {
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getTerms() {
        return terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    public Map<String, Object> getError() {
        return error;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RateResponse{");
        sb.append("success=").append(success);
        sb.append(", terms='").append(terms).append('\'');
        sb.append(", privacy='").append(privacy).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append(", source='").append(source).append('\'');
        sb.append(", quotes=").append(quotes);
        sb.append(", error=").append(error);
        sb.append('}');
        return sb.toString();
    }
}
