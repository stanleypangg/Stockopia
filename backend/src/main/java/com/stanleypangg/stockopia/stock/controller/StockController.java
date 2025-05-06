package com.stanleypangg.stockopia.stock.controller;

import com.stanleypangg.stockopia.stock.service.StockService;
import com.stanleypangg.stockopia.stock.dto.QuoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public QuoteDto getQuote(@RequestParam(name = "symbol") String symbol) {
        return stockService.getQuote(symbol);
    }
}
