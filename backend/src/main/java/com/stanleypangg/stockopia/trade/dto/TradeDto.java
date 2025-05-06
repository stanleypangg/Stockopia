package com.stanleypangg.stockopia.trade.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record TradeDto(Long id, String symbol, Integer quantity, BigDecimal price, Instant timestamp) {
}
