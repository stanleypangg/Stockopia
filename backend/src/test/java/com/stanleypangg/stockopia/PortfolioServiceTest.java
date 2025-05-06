package com.stanleypangg.stockopia;

import com.stanleypangg.stockopia.portfolio.model.Portfolio;
import com.stanleypangg.stockopia.portfolio.repository.PortfolioRepository;
import com.stanleypangg.stockopia.portfolio.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PortfolioServiceTest {
    @Mock PortfolioRepository portfolioRepository;
    @InjectMocks
    PortfolioService portfolioService;

    @Test
    public void getAllPortfoliosReturnsAllPortfolios() {
        // given
        List<Portfolio> expected = List.of(
                new Portfolio("A"),
                new Portfolio("B")
        );
        given(portfolioRepository.findAll()).willReturn((expected));

        // when
        List<Portfolio> actual = portfolioService.getAllPortfolios();

        // then
        assertThat(actual)
                .hasSize(2)
                .extracting(Portfolio::getName)
                .containsExactly("A", "B");
    }

    @Test
    public void createPortfolioSavesWithGivenValues() {
        // given
        when(portfolioRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // when
        Portfolio portfolio = portfolioService.createPortfolio("Test", BigDecimal.TEN);

        // then
        assertThat(portfolio.getName()).isEqualTo("Test");
        assertThat(portfolio.getBalance()).isEqualTo(BigDecimal.TEN);
        then(portfolioRepository).should().save(portfolio);
    }
}
