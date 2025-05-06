package com.stanleypangg.stockopia.portfolio;

import com.stanleypangg.stockopia.dto.CreatePortfolioDto;
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
