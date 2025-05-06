package com.stanleypangg.stockopia.stock.exception;

public class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException(String symbol) {
        super("No quote found for symbol " + symbol);
    }
}
