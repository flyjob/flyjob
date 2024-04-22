package com.intellibucket.onnetwork.exchange.domain.presentation.ports.output.currency.abstracts;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "free-currency-api", url = "${external-api.free-currency.url}")
public interface FreeCurrencyAPIClient {

    @GetMapping("v1/latest?apikey={api-key}")
    JsonNode fetchAllLatestRates(@PathVariable("api-key") String apiKey);
}
