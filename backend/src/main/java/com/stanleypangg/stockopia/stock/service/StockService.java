package com.stanleypangg.stockopia.stock.service;

import com.stanleypangg.stockopia.stock.dto.QuoteDto;
import com.stanleypangg.stockopia.stock.exception.ExternalApiException;
import com.stanleypangg.stockopia.stock.exception.QuoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class StockService {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    @Autowired
    public StockService(
            RestTemplate restTemplate,
            @Value("${stock.api.url}") String apiUrl,
            @Value("${stock.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public QuoteDto getQuote(String symbol) {
        // construct uri
        String uri = UriComponentsBuilder
                .fromUriString(apiUrl)
                .queryParam("function", "GLOBAL_QUOTE")
                .queryParam("symbol", symbol)
                .queryParam("apikey", apiKey)
                .toUriString();

        Map<?, ?> response;
        try {
            // convert JSON to generic Map
            response = restTemplate.getForObject(uri, Map.class);
        } catch (Exception e) {
            System.err.println("Error calling stock API for " + symbol + ": " + e);
            throw new ExternalApiException("Failed to fetch quote for " + symbol, e);
        }

        // extract global quote object
        Map<?, ?> global = (Map<?, ?>) response.get("Global Quote");
        if (global == null || !global.containsKey("05. price")) {
            throw new QuoteNotFoundException(symbol);
        }

        // parse and return price
        String price = (String) global.get("05. price");
        return new QuoteDto(symbol, new BigDecimal(price));
    }
}
