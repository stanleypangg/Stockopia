package com.stanleypangg.stockopia.portfolio.dto;

import com.stanleypangg.stockopia.trade.dto.TradeDto;

import java.math.BigDecimal;
import java.util.List;

public record PortfolioDto(
        Long id,
        String name,
        BigDecimal balance,
        BigDecimal totalValue,
        List<PortfolioDto> positions,

        List<TradeDto> recentTrades
) {}