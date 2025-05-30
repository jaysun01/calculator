package com.example.calculator;

import java.math.BigDecimal;
import java.util.Map;

public class Calculator {
    private final Map<Operation, OperationStrategy> strategies;

    public Calculator(Map<Operation, OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    public BigDecimal calculate(Operation op, BigDecimal a, BigDecimal b) {
        OperationStrategy strategy = strategies.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Unsupported operation: " + op);
        }
        return strategy.apply(a, b);
    }
}
