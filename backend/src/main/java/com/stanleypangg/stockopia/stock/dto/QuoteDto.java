package com.stanleypangg.stockopia.stock.dto;

import java.math.BigDecimal;

public record QuoteDto(String symbol, BigDecimal price) {
}
