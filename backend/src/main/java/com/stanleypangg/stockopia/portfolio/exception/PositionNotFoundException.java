package com.stanleypangg.stockopia.portfolio.exception;

public class PositionNotFoundException extends RuntimeException {
    public PositionNotFoundException(String position) {
        super("Position ID " + position + " not found");
    }
}
