package com.stanleypangg.stockopia.position.model;

import com.stanleypangg.stockopia.portfolio.model.Portfolio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String symbol;
    @Positive
    @NotNull
    private Integer quantity;
    @Positive
    private BigDecimal averagePrice;
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
}
