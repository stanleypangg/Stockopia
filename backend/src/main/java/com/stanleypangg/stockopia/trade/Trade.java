package com.stanleypangg.stockopia.trade;

import com.stanleypangg.stockopia.portfolio.Portfolio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String symbol;
    @Positive
    @NotNull
    private Integer quantity;
    @Positive
    @NotNull
    private BigDecimal price;
    private Instant timestamp;
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
}
