package ca.jrvs.apps.twitter.example.dto;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "exDate",
        "paymentDate",
        "recordDate",
        "declaredDate",
        "amount"
})
public class Dividend {

    @JsonProperty("exDate")
    private String exDate;
    @JsonProperty("paymentDate")
    private String paymentDate;
    @JsonProperty("recordDate")
    private String recordDate;
    @JsonProperty("declaredDate")
    private String declaredDate;
    @JsonProperty("amount")
    private Double amount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("exDate")
    public String getExDate() {
        return exDate;
    }

    @JsonProperty("exDate")
    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    @JsonProperty("paymentDate")
    public String getPaymentDate() {
        return paymentDate;
    }

    @JsonProperty("paymentDate")
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @JsonProperty("recordDate")
    public String getRecordDate() {
        return recordDate;
    }

    @JsonProperty("recordDate")
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    @JsonProperty("declaredDate")
    public String getDeclaredDate() {
        return declaredDate;
    }

    @JsonProperty("declaredDate")
    public void setDeclaredDate(String declaredDate) {
        this.declaredDate = declaredDate;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}