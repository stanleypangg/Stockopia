package com.stanleypangg.stockopia.portfolio.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("Insufficient funds");
    }
}
