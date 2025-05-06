package com.stanleypangg.stockopia.portfolio.controller;

import com.stanleypangg.stockopia.portfolio.model.Portfolio;
import com.stanleypangg.stockopia.portfolio.service.PortfolioService;
import com.stanleypangg.stockopia.portfolio.dto.CreatePortfolioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody CreatePortfolioDto createPortfolioDto) {
        return portfolioService.createPortfolio(
                createPortfolioDto.name(),
                createPortfolioDto.balance()
        );
    }
}
