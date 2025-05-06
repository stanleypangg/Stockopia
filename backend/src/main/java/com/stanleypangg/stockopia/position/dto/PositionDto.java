package com.stanleypangg.stockopia.position.dto;

import java.math.BigDecimal;

public record PositionDto(
        String symbol,
        Integer quantity,
        BigDecimal avgPrice,
        BigDecimal marketPrice,
        BigDecimal marketValue
) {}
