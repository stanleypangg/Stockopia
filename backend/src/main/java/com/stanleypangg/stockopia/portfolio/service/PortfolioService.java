package com.stanleypangg.stockopia.portfolio.service;

import com.stanleypangg.stockopia.portfolio.model.Portfolio;
import com.stanleypangg.stockopia.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public Portfolio createPortfolio(String name, BigDecimal balance) {
        Portfolio portfolio = new Portfolio();
        portfolio.setName(name);
        portfolio.setBalance(balance);
        return portfolioRepository.save(portfolio);
    }
}
