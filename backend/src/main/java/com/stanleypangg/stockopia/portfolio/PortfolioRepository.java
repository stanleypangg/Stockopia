package com.stanleypangg.stockopia.portfolio;

import com.stanleypangg.stockopia.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
