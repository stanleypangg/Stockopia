package com.stanleypangg.stockopia.portfolio.repository;

import com.stanleypangg.stockopia.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
