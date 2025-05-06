package com.stanleypangg.stockopia.portfolio;

import com.stanleypangg.stockopia.position.Position;
import com.stanleypangg.stockopia.trade.Trade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotNull
    private BigDecimal balance = BigDecimal.ZERO;
    @OneToMany
    private List<Trade> trades;
    @OneToMany
    private List<Position> positions;

    public Portfolio() {}
    public Portfolio(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
